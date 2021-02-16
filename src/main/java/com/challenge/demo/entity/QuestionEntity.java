package com.challenge.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "question")
@EntityListeners(AuditingEntityListener.class)
public class QuestionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="question_seq")
			@SequenceGenerator(name="question_seq", sequenceName="q_seq")
	@Column(name = "question_id")
	private Long questionId;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "site_id", referencedColumnName = "site_id")
	private SiteEntity site;
	
	@Column(nullable = false)
	private Integer maxQuestionAnswer;

	@Column(nullable = false)
	private Integer maxResponseAnswer;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private Boolean isExact;
	
	@Column(name = "parent_id")
	private Long parentId;
	
	@Column
	private String direction;
	
	@NotBlank
	@Length(min = 0, max = 250)
	private String question;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	private List<QuestionAnswerEntity> answers = new ArrayList<>();

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getQuestionId() {
		return questionId;
	}

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public Date getCreatedAt() {
		return createdAt;
	}

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public SiteEntity getSite() {
		return site;
	}

	public void setSite(SiteEntity site) {
		this.site = site;
	}

	public List<QuestionAnswerEntity> getAnswers() {
		return answers;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final QuestionEntity question1 = (QuestionEntity) o;
		return Objects.equals(questionId, question1.questionId) &&
				Objects.equals(site, question1.site) &&
				Objects.equals(question, question1.question) &&
				Objects.equals(answers, question1.answers) &&
				Objects.equals(createdAt, question1.createdAt) &&
				Objects.equals(updatedAt, question1.updatedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(questionId, site, question, answers, createdAt, updatedAt);
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

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentQuestion the parentQuestion to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
}
