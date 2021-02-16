package com.challenge.demo.converter;

import java.util.List;

import com.challenge.demo.dto.SiteDTO;
import com.challenge.demo.entity.SiteEntity;

public interface SiteConverter {
	
	SiteEntity dtoToEntity(SiteDTO dto);
	SiteDTO entityToDto(SiteEntity entity);
	List<SiteDTO> entityToDto(List<SiteEntity> sites);

}
