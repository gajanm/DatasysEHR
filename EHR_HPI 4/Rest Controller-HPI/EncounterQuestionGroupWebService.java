package com.cpa.ehr.web.rest.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpa.ehr.backend.dao.admin.entities.StaffMember;
import com.cpa.ehr.service.admin.EHRBaseService;
import com.cpa.ehr.service.system.EncounterQuestionGroupService;
import com.cpa.ehr.service.system.dto.EncounterQuestionGroupDTO;
import com.cpa.ehr.util.FormatConverterUtils;

@RestController
@RequestMapping("/api/rest/encounterQuestionGroup")
@CrossOrigin(origins = { "http://localhost:4300" })
public class EncounterQuestionGroupWebService {

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private EncounterQuestionGroupService encounterQuestionGroupService;
	
	@PostMapping("/createEncounterQuestionGroup")
	public ResponseEntity<EncounterQuestionGroupDTO> insertEncounterQuestionGroup(@RequestBody List<EncounterQuestionGroupDTO> encounterQuestionGroupDTO) {
		StaffMember loginUser = ehrBaseService.currentUser();
		HttpHeaders headers= new HttpHeaders();
		for (EncounterQuestionGroupDTO encQuestionGroupDTOSingleObj : encounterQuestionGroupDTO) {
			FormatConverterUtils.setInitialDefaultValues(encQuestionGroupDTOSingleObj, loginUser);
			encounterQuestionGroupService.persistEncounterQuestionGroup(encQuestionGroupDTOSingleObj);
 
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteQuestionGroups")
	public ResponseEntity<Void> deleteQuestionGroups(@RequestParam("encounterId") Long encounterId,@RequestParam("sysType") String sysType)
	{
		encounterQuestionGroupService.removeQuestionGroups(encounterId,sysType);
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		
	}
	
}
