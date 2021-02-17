package com.challenge.demo.usecase.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.challenge.demo.converter.SiteConverter;
import com.challenge.demo.dto.SiteDTO;
import com.challenge.demo.exception.SiteException;
import com.challenge.demo.repository.SiteRepository;
import com.challenge.demo.usecase.SiteUsecase;


@Component
public class SiteUsecaseImpl implements SiteUsecase{
	@Autowired
	SiteRepository siteRepository;
	
	@Autowired
	SiteConverter siteConverter;
	
	public SiteDTO createSite( SiteDTO createSite) throws SiteException{
		createSite.setSiteUUID(UUID.randomUUID());
		return siteConverter.entityToDto(siteRepository.save(siteConverter.dtoToEntity(createSite)));
	}
	
	@Override
	public List<SiteDTO> getSites() throws SiteException{
		return Optional
		.ofNullable(siteRepository.findAll())
		.map(sites -> siteConverter.entityToDto(sites))
		.orElseGet(() -> null);
		
		
	}

	@Override
	public SiteDTO updateSite(SiteDTO updatedSite, Long siteId)  throws SiteException{
		return siteRepository
				.findById(siteId)
				.map(site -> {
					site.setUrl(updatedSite.getUrl());
					return siteConverter.entityToDto(siteRepository.save(site));
				})
				.orElseGet(() ->null);
	}

	@Override
	public SiteDTO deleteSite(Long siteId)  throws SiteException{
		return siteRepository
				.findById(siteId)
				.map(site -> {
					siteRepository.delete(site);
					return siteConverter.entityToDto(site);
				})
				.orElseGet(() -> null);
	}

	@Override
	public SiteDTO getSiteById(Long siteId) throws SiteException{
		return siteRepository
				.findById(siteId)
				.map(site -> siteConverter.entityToDto(site))
				.orElseGet(() -> null);
	}

}
