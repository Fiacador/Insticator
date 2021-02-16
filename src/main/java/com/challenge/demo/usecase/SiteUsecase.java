package com.challenge.demo.usecase;

import java.util.List;

import com.challenge.demo.dto.SiteDTO;

public interface SiteUsecase {
	 
	public List<SiteDTO> getSites();
	public SiteDTO updateSite(SiteDTO updatedSite, Long siteId);
	public SiteDTO deleteSite( Long siteId);
	public SiteDTO getSiteById(Long siteId);
	public SiteDTO createSite(SiteDTO createSite);

}
