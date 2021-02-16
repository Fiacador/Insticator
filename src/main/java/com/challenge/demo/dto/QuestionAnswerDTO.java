package com.challenge.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.challenge.demo.entity.QuestionEntity;
import com.challenge.demo.entity.QuestionAnswerEntity;

public class QuestionAnswerDTO {

	private Long id;

	private Long questionId;

	private String answer;

	private boolean isCorrectAnswer;

	private Date createdAt;

	private Date updatedAt;
	
	private String direction;

	private Integer maxQuestionAnswer;

	public static QuestionAnswerEntity transform(final QuestionAnswerDTO newQADto, final QuestionEntity question) {
		final QuestionAnswerEntity newQa = new QuestionAnswerEntity();
		newQa.setAnswer(newQADto.getAnswer());
		newQa.setIsCorrectAnswer(newQADto.getIsCorrectAnswer());
		newQa.setQuestion(question);

		return newQa;
	}

	public static QuestionAnswerDTO build(final QuestionAnswerEntity save) {
		final QuestionAnswerDTO newQaDto = new QuestionAnswerDTO();

		newQaDto.setId(save.getId());
		newQaDto.setAnswer(save.getAnswer());
		newQaDto.setIsCorrectAnswer(save.isCorrectAnswer());
		newQaDto.setCreatedAt(save.getCreatedAt());
		newQaDto.setUpdatedAt(save.getUpdatedAt());
		newQaDto.setQuestionId(save.getQuestion().getQuestionId());

		return newQaDto;
	}

	public static List<QuestionAnswerDTO> build(final List<QuestionAnswerEntity> answers) {
		final List<QuestionAnswerDTO> ret = new ArrayList<>();
		for (QuestionAnswerEntity qa : answers) {
			ret.add(build(qa));
		}
		return ret;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(final Long questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(final String answer) {
		this.answer = answer;
	}

	public boolean getIsCorrectAnswer() {
		return isCorrectAnswer;
	}

	public void setIsCorrectAnswer(final boolean correctAnswer) {
		isCorrectAnswer = correctAnswer;
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

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the maxQuestionAnswer
	 */
	public Integer getMaxQuestionAnswer() {
		return maxQuestionAnswer;
	}

	/**
	 * @param maxQuestionAnswer the maxQuestionAnswer to set
	 */
	public void setMaxQuestionAnswer(Integer maxQuestionAnswer) {
		this.maxQuestionAnswer = maxQuestionAnswer;
	}


}
