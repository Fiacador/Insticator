package com.challenge.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT s.* FROM User s WHERE s.user_uuid = ?1", nativeQuery = true)
	UserEntity findByUuid(UUID siteUUID);
}