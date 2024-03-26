package com.cpa.ehr.service.system.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpa.ehr.backend.dao.system.EncounterHistoryRepository;
import com.cpa.ehr.backend.dao.system.entities.ChiefCompliantDetails;
import com.cpa.ehr.backend.dao.system.entities.EncounterHistory;
import com.cpa.ehr.backend.dao.system.entities.EncounterHistoryRecord;
import com.cpa.ehr.backend.dao.system.entities.OptionRecord;
import com.cpa.ehr.backend.dao.system.entities.QuestionHistoryRecord;
import com.cpa.ehr.backend.dao.system.entities.QuestionRecord;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.EncounterHistoryService;
import com.cpa.ehr.service.system.dto.ChiefCompliantDetailsDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;
import com.cpa.ehr.service.system.dto.mapper.EncounterHistoryMapper;
import com.cpa.ehr.service.system.dto.mapper.EncounterHistoryRecordMapper;
import com.cpa.ehr.service.system.dto.mapper.QuestionRecordMapper;

@Service
public class EncounterHistoryServiceImpl implements EncounterHistoryService {
	private static final Logger LOG = LoggerFactory.getLogger(EncounterHistoryServiceImpl.class);
	@Autowired
	private EncounterHistoryRepository encHistoryRepo;

	@Autowired
	private EncounterHistoryRecordMapper encounterHistoryRecordMapper;

	@Autowired
	private EncounterHistoryMapper encounterHistoryMapper;
	
	@Autowired
	private EmailService emailService;

	@Override
	public List<EncounterHistoryRecordDTO> retrieveAllEncounterByEncounterId(Long encounterId) {

		try {
			long sysId = 0;
			
			//historyList
			List<Object> historyList = encHistoryRepo.getAllEncountersByEncounterId(encounterId);
			List<EncounterHistoryRecord> historyRecordList = new ArrayList<>();
			
			//Iterate the data..
			Iterator itr = historyList.iterator();
			
			while (itr.hasNext()) {
				EncounterHistoryRecord item = new EncounterHistoryRecord();
				Object[] obj = (Object[]) itr.next();
				Iterator itr1 = historyList.iterator();
				List<QuestionHistoryRecord> questionRecordList = new ArrayList<>();
				if (Long.parseLong(String.valueOf(obj[0])) != sysId) {
					while (itr1.hasNext()) {
						QuestionHistoryRecord questionRecord = new QuestionHistoryRecord();
						Object[] obj1 = (Object[]) itr1.next();
						if (Long.parseLong(String.valueOf(obj1[0])) == Long.parseLong(String.valueOf(obj[0]))) {
							if (String.valueOf(obj1[15]) == "null") {
								questionRecord.setOptionId((long) 0);
							} else {
								questionRecord.setOptionId(Long.parseLong(String.valueOf(obj1[15])));
							}
							if (String.valueOf(obj1[16]) == "null") {
								questionRecord.setOptionValue(null);
							} else {
								questionRecord.setOptionValue(String.valueOf(obj1[16]));
							}
							questionRecord.setQuestionGroupName(String.valueOf(obj1[5]));
							questionRecord.setQuestionDesc(String.valueOf(obj1[8]));
							questionRecord.setQuestionType(String.valueOf(obj1[9]));
							questionRecord.setQuestionId(Long.parseLong(String.valueOf(obj1[13])));
							questionRecord.setAnswer(String.valueOf(obj1[17]));
							questionRecordList.add(questionRecord);
						}
					}
					item.setSystemId(Long.parseLong(String.valueOf(obj[0])));
					item.setSystemType(String.valueOf(obj[1]));
					item.setSystemCode(String.valueOf(obj[2]));
					item.setSystemDesc(String.valueOf(obj[3]));
					item.setQuestionRecord(questionRecordList);
					historyRecordList.add(item);
				}
				sysId = Long.parseLong(String.valueOf(obj[0]));
			}
			return (historyList != null)
					? encounterHistoryRecordMapper.entityListToEncounterHistoryRecordDTOList(historyRecordList)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all questions by encounterId  {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all questions by encounterId {} ", e);
		}
		return Collections.emptyList();

	}

	@Override
	public List<EncounterHistoryDTO> retrieveEncounterListByEncounterId(Long encounterId) {
		try {
			List<EncounterHistory> encouterList = encHistoryRepo.getEncountersByEncounterId(encounterId);
			return (encouterList != null) ? encounterHistoryMapper.entityListToEncounterHistoryDTOList(encouterList)
					: null;
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while retrieving all Encounter By EncounterId {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while retrieving all Encounter By EncounterId {} ", e);
		}
		return Collections.emptyList();
	}
}
