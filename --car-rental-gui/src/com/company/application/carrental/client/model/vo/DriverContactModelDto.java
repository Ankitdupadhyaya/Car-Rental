package com.company.application.carrental.client.model.vo;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class DriverContactModelDto extends BaseModelData {

	private static final long serialVersionUID = -6483997085519543532L;

	public static final String DRIVER_CONTACT_ID = "driverContactId";
	public static final String CONTACT_TYPE = "contactType";
	public static final String CONTACT_NUMBER = "contactNumber";
	public static final String IS_PRIMARY = "isPrimary";
	public static final String DRIVER_ID = "driverId";

	// private Integer driverContactId;
	// private String contactType;
	// private String contactNumber;
	// private Boolean isPrimary;

	public DriverContactModelDto() {
	}

	public DriverContactModelDto(Integer driverContactId, String contactType, String contactNumber, Boolean isPrimary) {
		super();
		set(DRIVER_CONTACT_ID, driverContactId);
		set(CONTACT_TYPE, contactType);
		set(CONTACT_NUMBER, contactNumber);
		set(IS_PRIMARY, isPrimary);
	}

	public Integer getDriverContactId() {
		return get(DRIVER_CONTACT_ID);
	}

	public void setDriverContactId(Integer driverContactId) {
		set(DRIVER_CONTACT_ID, driverContactId);
	}

	public String getContactType() {
		return get(CONTACT_TYPE);
	}

	public void setContactType(String contactType) {
		set(CONTACT_TYPE, contactType);
	}

	public String getContactNumber() {
		return get(CONTACT_NUMBER);
	}

	public void setContactNumber(String contactNumber) {
		set(CONTACT_NUMBER, contactNumber);
	}

	public Boolean getIsPrimary() {
		return get(IS_PRIMARY);
	}

	public void setIsPrimary(boolean isPrimary) {
		set(IS_PRIMARY, isPrimary);
	}
	
	public Integer getDriverId(){
		return get(DRIVER_ID);
	}
	
	public void setDriverId(Integer driverId){
		set(DRIVER_ID,driverId);
	}
}