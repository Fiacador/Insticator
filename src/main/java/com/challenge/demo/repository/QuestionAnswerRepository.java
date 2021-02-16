package com.challenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.demo.entity.QuestionAnswerEntity;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswerEntity, Long> {

	@Query(value = "SELECT COUNT(*) FROM question_answer q WHERE q.question_id=?1", nativeQuery = true)
	Long countByQuestionId(Long questionId);
}
