package com.challenge.demo.dto;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class SiteDTO {
	
	private Long siteId;
	private UUID siteUUID;
	private String url;
	private Date createdAt;
	private Date updatedAt;
	/**
	 * @return the siteId
	 */
	public Long getSiteId() {
		return siteId;
	}
	/**
	 * @param siteId the siteId to set
	 */
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	/**
	 * @return the siteUUID
	 */
	public UUID getSiteUUID() {
		return siteUUID;
	}
	/**
	 * @param siteUUID the siteUUID to set
	 */
	public void setSiteUUID(UUID siteUUID) {
		this.siteUUID = siteUUID;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SiteDTO site = (SiteDTO) o;
		return Objects.equals(siteId, site.siteId) &&
				Objects.equals(siteUUID, site.siteUUID) &&
				Objects.equals(url, site.url) &&
				Objects.equals(createdAt, site.createdAt) &&
				Objects.equals(updatedAt, site.updatedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(siteId, siteUUID, url, createdAt, updatedAt);
	}
}
