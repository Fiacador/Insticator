package com.challenge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.demo.entity.AnswerEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {


	@Query(value = "SELECT a.* FROM answer a WHERE a.user_id = ?1", nativeQuery = true)
	List<AnswerEntity> findByUserId(Long userId);

	
}