package com.challenge.demo.dto;

import java.util.List;
import java.util.Map;

public class AnswerDTO {
	
	private Long userId;
	
	private Map<Long, List<Long>> answers;

	/**
	 * @return the answerId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the answers
	 */
	public Map<Long, List<Long>> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Map<Long, List<Long>> answers) {
		this.answers = answers;
	}
	
}
