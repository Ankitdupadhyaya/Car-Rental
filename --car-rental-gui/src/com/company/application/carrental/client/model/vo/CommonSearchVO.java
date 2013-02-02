package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class CommonSearchVO implements Serializable {

	private static final long serialVersionUID = -5299310439157110714L;

	private Integer branchId;
	private Integer portfolioId;
	private Integer folderId;
	private Integer folderGrpId;
	private Integer typeOfInstrId;
	private Integer currencyId;
	private String siteCode;
	private Integer userId;

	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the portfolioId
	 */
	public Integer getPortfolioId() {
		return portfolioId;
	}

	/**
	 * @param portfolioId the portfolioId to set
	 */
	public void setPortfolioId(Integer portfolioId) {
		this.portfolioId = portfolioId;
	}

	/**
	 * @return the folderId
	 */
	public Integer getFolderId() {
		return folderId;
	}

	/**
	 * @param folderId the folderId to set
	 */
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	/**
	 * @return the folderGrpId
	 */
	public Integer getFolderGrpId() {
		return folderGrpId;
	}

	/**
	 * @param folderGrpId the folderGrpId to set
	 */
	public void setFolderGrpId(Integer folderGrpId) {
		this.folderGrpId = folderGrpId;
	}

	/**
	 * @return the typeOfInstrId
	 */
	public Integer getTypeOfInstrId() {
		return typeOfInstrId;
	}

	/**
	 * @param typeOfInstrId the typeOfInstrId to set
	 */
	public void setTypeOfInstrId(Integer typeOfInstrId) {
		this.typeOfInstrId = typeOfInstrId;
	}

	/**
	 * @return the currencyId
	 */
	public Integer getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId the currencyId to set
	 */
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * @return the siteCode
	 */
	public String getSiteCode() {
		return siteCode;
	}

	/**
	 * @param siteCode the siteCode to set
	 */
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}