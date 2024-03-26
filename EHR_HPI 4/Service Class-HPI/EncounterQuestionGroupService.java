package com.cpa.ehr.service.system;

import com.cpa.ehr.service.system.dto.EncounterQuestionGroupDTO;

public interface EncounterQuestionGroupService {
	public void removeQuestionGroups(Long encounterId,String sysType);
	
	/**
	 * Persists EncounterQuestionGroup information in database
	 * 
	 * @param EncounterQuestionGroupDTOSingleObject
	 * 		Object of the EncounterQuestionGroupDTO to be persisted in DB
	 * @return EncounterQuestionGroupDTO
	 * 		DTO of the created entity
	 */
	
	//Service layer for storing data as Question Group
	EncounterQuestionGroupDTO persistEncounterQuestionGroup(EncounterQuestionGroupDTO encQuestionGroupDTOSingleObj);
	
}
