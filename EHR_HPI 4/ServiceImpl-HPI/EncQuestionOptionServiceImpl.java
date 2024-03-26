package com.cpa.ehr.service.system.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpa.ehr.backend.dao.system.EncQuestionOptionRepository;
import com.cpa.ehr.backend.dao.system.entities.EncQuestionOption;
import com.cpa.ehr.backend.dao.system.entities.Encounter;
import com.cpa.ehr.security.SecurityUtils;
import com.cpa.ehr.service.home.EmailService;
import com.cpa.ehr.service.system.EncQuestionOptionService;
import com.cpa.ehr.service.system.dto.EncQuestionOptionDTO;
import com.cpa.ehr.service.system.dto.mapper.EncQuestionOptionMapper;

@Service
public class EncQuestionOptionServiceImpl implements EncQuestionOptionService {
	private static final Logger LOG = LoggerFactory.getLogger(EncQuestionOptionServiceImpl.class);
	@Autowired
	private EncQuestionOptionMapper encQuestionOptionMapper;

	@Autowired
	private EncQuestionOptionRepository encQuestionOptionRepository;

	@Autowired
	private EmailService emailService;

	/**
	 * Persists encQuestionOption information in database
	 * 
	 * @param encQuestionOptionDTO DTO of the encQuestionOptionDTO to be persisted
	 *                             in DB
	 * @return encQuestionOptionDTO DTO of the created entity
	 */

	
	//Storing the data single object
	@Override
	public EncQuestionOptionDTO persistEncounterQuestionOption(EncQuestionOptionDTO encQuestionOptionDTO) {
		try {
			if (encQuestionOptionDTO != null) {

				EncQuestionOption newEncounterQuestionOption = encQuestionOptionMapper
						.encQuestionOptionDTOToEntity(encQuestionOptionDTO);
				
				//In  Built Functionality save method used...
				EncQuestionOption createdEncounterQuestionOption = encQuestionOptionRepository
						.save(newEncounterQuestionOption);
				return (createdEncounterQuestionOption != null)
						? encQuestionOptionMapper.entityToEncQuestionOptionDTO(createdEncounterQuestionOption)
						: null;

			}

		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error persistEncounterQuestionOption{}  " + "{" + encQuestionOptionDTO + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
		}

		return null;
	}

	//Optional
	@Override
	public void removeQuestionOptions(Long encounterId, String sysType) {
		// TODO Auto-generated method stub
		try {
			// encQuestionOptionRepository.de
			encQuestionOptionRepository.deleteByEncounterIdAndSysType(encounterId, sysType);
		} catch (Exception e) {
			String username = SecurityUtils.getCurrentUserLogin();
			String exceptionString = "Error while removing Encounter {}  " + "{" + encounterId + "} \n"
					+ emailService.getStackTrace(e);
			emailService.sendExceptionEmail(exceptionString,username);
			
			LOG.error("Error while removing Encounter {}", e);
		}
	}
}
