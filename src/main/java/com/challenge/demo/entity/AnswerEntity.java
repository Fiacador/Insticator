package com.challenge.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "answer")
@EntityListeners(AuditingEntityListener.class)
public class AnswerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="answer_seq")
	@SequenceGenerator(name="answer_seq", sequenceName="a_seq")
	@Column(name = "answer_id")
	private Long answerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private UserEntity users;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
	private QuestionEntity questions;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_answer_id")
	private QuestionAnswerEntity questionsAnswer;

	/**
	 * @return the answerId
	 */
	public Long getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	/**
	 * @return the users
	 */
	public UserEntity getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(UserEntity users) {
		this.users = users;
	}

	/**
	 * @return the questions
	 */
	public QuestionEntity getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(QuestionEntity questions) {
		this.questions = questions;
	}

	/**
	 * @return the questionsAnswer
	 */
	public QuestionAnswerEntity getQuestionsAnswer() {
		return questionsAnswer;
	}

	/**
	 * @param questionsAnswer the questionsAnswer to set
	 */
	public void setQuestionsAnswer(QuestionAnswerEntity questionsAnswer) {
		this.questionsAnswer = questionsAnswer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + ((questionsAnswer == null) ? 0 : questionsAnswer.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnswerEntity other = (AnswerEntity) obj;
		if (answerId == null) {
			if (other.answerId != null)
				return false;
		} else if (!answerId.equals(other.answerId))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (questionsAnswer == null) {
			if (other.questionsAnswer != null)
				return false;
		} else if (!questionsAnswer.equals(other.questionsAnswer))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	
	
	
	
	

	

}
