

package com.cpa.ehr.service.system.dto;

import java.util.Date;

public class EncounterQuestionGroupDTO {
	
	private Long encQuestionGroupId;
	
	private Long encounterId;
	
	private Long questionGroupId;
	
	private Long systemId;
	
	private String questionGroupAnswer;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	private String lastUpdatedBy;
	
	

	public Long getEncQuestionGroupId() {
		return encQuestionGroupId;
	}

	public void setEncQuestionGroupId(Long encQuestionGroupId) {
		this.encQuestionGroupId = encQuestionGroupId;
	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public Long getQuestionGroupId() {
		return questionGroupId;
	}

	public void setQuestionGroupId(Long questionGroupId) {
		this.questionGroupId = questionGroupId;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getQuestionGroupAnswer() {
		return questionGroupAnswer;
	}

	public void setQuestionGroupAnswer(String questionGroupAnswer) {
		this.questionGroupAnswer = questionGroupAnswer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	@Override
	public String toString() {
		return "EncounterQuestionGroupDTO [encQuestionGroupId=" + encQuestionGroupId + ", encounterId=" + encounterId
				+ ", questionGroupId=" + questionGroupId + ", systemId=" + systemId + ", questionGroupAnswer="
				+ questionGroupAnswer + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}





	
}
