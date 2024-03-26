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
import com.cpa.ehr.service.system.EncQuestionOptionService;
import com.cpa.ehr.service.system.dto.EncQuestionOptionDTO;
import com.cpa.ehr.util.FormatConverterUtils;


@RestController
@RequestMapping("/api/rest/encQuestionOptions")
@CrossOrigin(origins = { "http://localhost:4300" })
public class EncQuestionOptionWebService {

	@Autowired
	private EHRBaseService ehrBaseService;
	
	@Autowired
	private EncQuestionOptionService encQuestionOptionService;
	
	
	//create the QuestionOption
	@PostMapping("/createEncounterQuestionOptions")
	public ResponseEntity<EncQuestionOptionDTO> insertEncounterQuestionOptions(@RequestBody List<EncQuestionOptionDTO> encQuestionOptionDTO) {
		StaffMember loginUser = ehrBaseService.currentUser();
		
		HttpHeaders headers= new HttpHeaders();
		for (EncQuestionOptionDTO encQuestionOptionDTOSingleObj : encQuestionOptionDTO) {
			FormatConverterUtils.setInitialDefaultValues(encQuestionOptionDTOSingleObj, loginUser);
			encQuestionOptionService.persistEncounterQuestionOption(encQuestionOptionDTOSingleObj);
		}
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteQuestionOptions")
	public ResponseEntity<Void> deleteQuestionOptions(@RequestParam("encounterId") Long encounterId,@RequestParam("sysType") String sysType)
	{
		encQuestionOptionService.removeQuestionOptions(encounterId,sysType);
			HttpHeaders headers= new HttpHeaders();
			return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
		
	}
	
}
