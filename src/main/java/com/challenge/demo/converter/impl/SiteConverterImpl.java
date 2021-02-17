package com.challenge.demo.converter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.demo.converter.SiteConverter;
import com.challenge.demo.dto.SiteDTO;
import com.challenge.demo.entity.SiteEntity;

@Component
public class SiteConverterImpl implements SiteConverter{

	@Override
	public SiteEntity dtoToEntity(SiteDTO dto) {
		SiteEntity siteEntity = new SiteEntity();
		siteEntity.setSiteUUID(dto.getSiteUUID());
		siteEntity.setUrl(dto.getUrl());
		return siteEntity;
	}

	@Override
	public SiteDTO entityToDto(SiteEntity entity) {
		SiteDTO dto = new SiteDTO();
		dto.setSiteId(entity.getSiteId());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setSiteUUID(entity.getSiteUUID());
		dto.setUrl(entity.getUrl());
		dto.setUpdatedAt(entity.getUpdatedAt());
		dto.setUrl(entity.getUrl());
		return dto;
	}

	@Override
	public List<SiteDTO> entityToDto(List<SiteEntity> sites) {
		List<SiteDTO> list = new ArrayList<>();
		sites.forEach(site -> list.add(entityToDto(site)));
		return list;
	}

	
	
}
