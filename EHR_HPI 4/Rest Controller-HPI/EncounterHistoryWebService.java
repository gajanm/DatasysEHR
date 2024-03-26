package com.cpa.ehr.web.rest.system;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cpa.ehr.service.system.EncounterHistoryService;
import com.cpa.ehr.service.system.dto.EncounterHistoryDTO;
import com.cpa.ehr.service.system.dto.EncounterHistoryRecordDTO;

@RestController
@RequestMapping("/api/rest/encounterHistory")
@CrossOrigin(origins = { "http://localhost:4300" })
public class EncounterHistoryWebService {
	
	@Autowired
	private EncounterHistoryService encHistoryService;
	
	
	
	//getting all data from database
	@GetMapping("/getAllEncounterByEncounterId")
	public ResponseEntity<List<EncounterHistoryRecordDTO>> getAllEncounterByEncounterId(@RequestParam("encounterId") Long encounterId) {
		List<EncounterHistoryRecordDTO> encDTO = encHistoryService.retrieveAllEncounterByEncounterId(encounterId);
		return new ResponseEntity<>(encDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getEncounterListByEncounterId")
	public ResponseEntity<List<EncounterHistoryDTO>> getEncounterListByEncounterId(@RequestParam("encounterId") Long encounterId) {
		List<EncounterHistoryDTO> encDTO = encHistoryService.retrieveEncounterListByEncounterId(encounterId);
		return new ResponseEntity<>(encDTO, HttpStatus.OK);
	}
}
