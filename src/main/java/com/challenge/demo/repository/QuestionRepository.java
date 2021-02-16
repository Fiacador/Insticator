package com.challenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.demo.entity.QuestionEntity;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

	@Query(value = "SELECT q.* FROM question q WHERE q.site_id = ?1", nativeQuery = true)
	List<QuestionEntity> findSiteQuestions(Long siteId);

	@Query(value = "SELECT q.* FROM question q WHERE q.parent_id = ?1 AND q.direction = 'HORIZONTAL'", nativeQuery = true)
	List<QuestionEntity> findByParentIdAndDirectionHorizontal(Long questionId);

	List<QuestionEntity> findByParentId(Long questionId);

	Long countByParentId(Long questionId);


}