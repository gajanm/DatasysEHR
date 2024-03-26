package com.cpa.ehr.service.system.dto;

import java.util.List;

import com.cpa.ehr.backend.dao.system.entities.QuestionHistoryRecord;

public class EncounterHistoryRecordDTO {
    private Long systemId;
	
	private String systemType;
	
	private String systemCode;
	
	private String systemDesc;
	
	private List<QuestionHistoryRecord> questionRecord;

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getSystemDesc() {
		return systemDesc;
	}

	public void setSystemDesc(String systemDesc) {
		this.systemDesc = systemDesc;
	}

	public List<QuestionHistoryRecord> getQuestionRecord() {
		return questionRecord;
	}

	public void setQuestionRecord(List<QuestionHistoryRecord> questionRecord) {
		this.questionRecord = questionRecord;
	}
	
	
	
}
