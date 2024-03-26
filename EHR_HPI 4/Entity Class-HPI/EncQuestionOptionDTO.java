package com.cpa.ehr.service.system.dto;

import java.util.Date;

public class EncQuestionOptionDTO {
	
	private Long encQuestionOptionId;
	
	private Long encounterId;
	
	private Long questionId;
	
	private Long questionGroupId;
	
	private Long systemId;
	
	private Long optionId;
	
	private String optionValue;
	
	private String answer;
	
	private Date createdDate;
	
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	private String lastUpdatedBy;
	
	private String answerComments;
	
	

	public Long getQuestionGroupId() {
		return questionGroupId;
	}

	public void setQuestionGroupId(Long questionGroupId) {
		this.questionGroupId = questionGroupId;
	}

	public Long getEncQuestionOptionId() {
		return encQuestionOptionId;
	}

	public void setEncQuestionOptionId(Long encQuestionOptionId) {
		this.encQuestionOptionId = encQuestionOptionId;
	}

	public Long getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(Long encounterId) {
		this.encounterId = encounterId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getAnswerComments() {
		return answerComments;
	}

	public void setAnswerComments(String answerComments) {
		this.answerComments = answerComments;
	}

	@Override
	public String toString() {
		return "EncQuestionOptionDTO [encQuestionOptionId=" + encQuestionOptionId + ", encounterId=" + encounterId
				+ ", questionId=" + questionId + ", questionGroupId=" + questionGroupId + ", systemId=" + systemId
				+ ", optionId=" + optionId + ", optionValue=" + optionValue + ", answer=" + answer + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", answerComments=" + answerComments + "]";
	}

	

	

}
