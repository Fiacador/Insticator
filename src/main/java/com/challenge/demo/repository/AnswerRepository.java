package com.challenge.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.demo.entity.AnswerEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {

	List<AnswerEntity> findByUserId(Long userId);

	
}