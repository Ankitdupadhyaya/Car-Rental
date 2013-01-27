package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class DriverAddress implements Serializable {

	private static final long serialVersionUID = -653180921138482184L;

	private Integer driverAddressId;
	private String addressType;
	private String address;
	private String landmark;

	public DriverAddress() {
	}

	public DriverAddress(Integer driverAddressId, String addressType, String address, String landmark) {
		super();
		this.driverAddressId = driverAddressId;
		this.addressType = addressType;
		this.address = address;
		this.landmark = landmark;
	}

	public Integer getDriverAddressId() {
		return driverAddressId;
	}

	public void setDriverAddressId(Integer driverAddressId) {
		this.driverAddressId = driverAddressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}