package com.cpa.ehr.service.system;

import com.cpa.ehr.service.system.dto.EncQuestionOptionDTO;


public interface EncQuestionOptionService {
	/**
	 * Persists EncounterQuestionOption information in database
	 * 
	 * @param encQuestionOptionDTOSingleObj
	 * 		Object of the EncQuestionOptionDTO to be persisted in DB
	 * @return EncQuestionOptionDTO
	 * 		DTO of the created entity
	 */
	
	EncQuestionOptionDTO persistEncounterQuestionOption(EncQuestionOptionDTO encQuestionOptionDTOSingleObj);
	
	public void removeQuestionOptions(Long encounterId,String sysType);
}
