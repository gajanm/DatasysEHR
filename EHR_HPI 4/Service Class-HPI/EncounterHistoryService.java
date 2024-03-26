package com.cpa.ehr.service.system;

import java.util.List;

import com.cpa.ehr.service.system.dto.EncounterHistoryDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;

public interface EncounterHistoryService {

	
	// List of display all data from db
	List<EncounterHistoryRecordDTO> retrieveAllEncounterByEncounterId(Long encounterId);
	
	
	//retrieve the data along with Encounter ID
	List<EncounterHistoryDTO> retrieveEncounterListByEncounterId(Long encounterId);
	
	

}
