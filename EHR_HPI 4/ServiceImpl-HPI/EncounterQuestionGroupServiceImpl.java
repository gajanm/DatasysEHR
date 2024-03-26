package com.cpa.ehr.service.system.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.system.EncounterQuestionGroupRepository;
import com.cpa.ehr.backend.dao.system.entities.EncounterQuestionGroup;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.EncounterQuestionGroupService;
import com.cpa.ehr.service.system.dto.EncounterQuestionGroupDTO;
import com.cpa.ehr.service.system.dto.mapper.EncounterQuestionGroupMapper;

@Service
public class EncounterQuestionGroupServiceImpl implements EncounterQuestionGroupService {
	private static final Logger LOG = LoggerFactory.getLogger(EncounterQuestionGroupServiceImpl.class);

	@Autowired
	private EncounterQuestionGroupMapper encounterQuestionGroupMapper;

	@Autowired
	private EncounterQuestionGroupRepository encQuestionGroupRepository;

	@Autowired
	private EmailService emailService;

	/**
	 * Persists EncounterQuestionGroup information in database
	 * 
	 * @param EncounterQuestionGroupDTO DTO of the EncounterQuestionGroupDTO to be
	 *                                  persisted in DB
	 * @return EncounterQuestionGroupDTO DTO of the created entity
	 */

	@Override
	public EncounterQuestionGroupDTO persistEncounterQuestionGroup(
			EncounterQuestionGroupDTO encounterQuestionGroupDTO) {
		try {
			if (encounterQuestionGroupDTO != null) {

				EncounterQuestionGroup newEncounterQuestionGroup = encounterQuestionGroupMapper
						.encounterQuestionGroupDTOToEntity(encounterQuestionGroupDTO);
				
				//Spring boot for saving and retrieving data save ,findAll, findById
				EncounterQuestionGroup createdEncounterQuestionGroup = encQuestionGroupRepository
						.save(newEncounterQuestionGroup);
				return (createdEncounterQuestionGroup != null)
						? encounterQuestionGroupMapper.entityToEncounterQuestionGroupDTO(createdEncounterQuestionGroup)
						: null;

			}
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while persistEncounterQuestionGroup {}  " + "{" + encounterQuestionGroupDTO
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
		}

		return null;
	}

	@Override
	public void removeQuestionGroups(Long encounterId, String sysType) {
		// TODO Auto-generated method stub
		try {
			// encQuestionOptionRepository.de
			encQuestionGroupRepository.deleteByEncounterIdAndSysType(encounterId, sysType);
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while  removing Encounter {}  " + "{" + encounterId
					+ "} \n" + emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString, username);
			LOG.error("Error while removing Encounter {}", e);
		}
	}

}
