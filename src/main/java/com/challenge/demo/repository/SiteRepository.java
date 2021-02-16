package com.challenge.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.demo.entity.SiteEntity;

import java.util.UUID;

public interface SiteRepository extends JpaRepository<SiteEntity, Long> {

	@Query(value = "SELECT s.* FROM Sites s WHERE s.site_uuid = ?1", nativeQuery = true)
	SiteEntity findByUuid(UUID siteUUID);
}