package com.challenge.demo.dto;

import java.util.Date;
import java.util.UUID;

public class UserDTO {
	
	private Long userId;

	private UUID userUUID;

	private Date createdAt;

	private Date updatedAt;
	
	private String userName;
	
	private Long siteId;
	
	private SiteDTO site;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userUUID
	 */
	public UUID getUserUUID() {
		return userUUID;
	}

	/**
	 * @param userUUID the userUUID to set
	 */
	public void setUserUUID(UUID userUUID) {
		this.userUUID = userUUID;
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

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the site
	 */
	public SiteDTO getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(SiteDTO site) {
		this.site = site;
	}

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
	
	

}
