package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class DriverContact implements Serializable {

	private static final long serialVersionUID = -6483997085519543532L;

	private Integer driverContactId;
	private String contactType;
	private String contactNumber;
	private Boolean isPrimary;

	public DriverContact() {
	}

	public DriverContact(Integer driverContactId, String contactType, String contactNumber, Boolean isPrimary) {
		super();
		this.driverContactId = driverContactId;
		this.contactType = contactType;
		this.contactNumber = contactNumber;
		this.isPrimary = isPrimary;
	}

	public Integer getDriverContactId() {
		return this.driverContactId;
	}

	public void setDriverContactId(Integer driverContactId) {
		this.driverContactId = driverContactId;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Boolean getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
}