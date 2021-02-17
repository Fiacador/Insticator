package com.challenge.demo.usecase;

import java.util.List;

import com.challenge.demo.dto.SiteDTO;
import com.challenge.demo.exception.SiteException;

public interface SiteUsecase {

	public List<SiteDTO> getSites() throws SiteException;

	public SiteDTO updateSite(SiteDTO updatedSite, Long siteId) throws SiteException;

	public SiteDTO deleteSite(Long siteId) throws SiteException;

	public SiteDTO getSiteById(Long siteId) throws SiteException;

	public SiteDTO createSite(SiteDTO createSite) throws SiteException;

}
