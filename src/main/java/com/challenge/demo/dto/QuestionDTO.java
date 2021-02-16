package com.challenge.demo.dto;

import java.util.Date;

public class QuestionDTO {

	private Long questionId;

	private Long siteId;

	private String question;

	private Date createdAt;

	private Date updatedAt;
	
	private Integer maxQuestionAnswer;

	private Integer maxResponseAnswer;
	
	private Boolean isExact;
	
	private SiteDTO site;
	

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(final Long siteId) {
		this.siteId = siteId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(final String question) {
		this.question = question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(final Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(final Long questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the site
	 */
	public SiteDTO getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(SiteDTO site) {
		this.site = site;
	}

	/**
	 * @return the maxAnswer
	 */
	public Integer getMaxQuestionAnswer() {
		return maxQuestionAnswer;
	}

	/**
	 * @param maxAnswer the maxAnswer to set
	 */
	public void setMaxQuestionAnswer(Integer maxQuestionAnswer) {
		this.maxQuestionAnswer = maxQuestionAnswer;
	}

	/**
	 * @return the maxResponseAnswer
	 */
	public Integer getMaxResponseAnswer() {
		return maxResponseAnswer;
	}

	/**
	 * @param maxResponseAnswer the maxResponseAnswer to set
	 */
	public void setMaxResponseAnswer(Integer maxResponseAnswer) {
		this.maxResponseAnswer = maxResponseAnswer;
	}

	/**
	 * @return the isExact
	 */
	public Boolean getIsExact() {
		return isExact;
	}

	/**
	 * @param isExact the isExact to set
	 */
	public void setIsExact(Boolean isExact) {
		this.isExact = isExact;
	}

}
