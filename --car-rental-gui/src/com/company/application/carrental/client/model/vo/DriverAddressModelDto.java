package com.company.application.carrental.client.model.vo;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class DriverAddressModelDto extends BaseModelData {

	private static final long serialVersionUID = -653180921138482184L;

	public static final String DRIVER_ADDRESS_ID = "driverAddressId";
	public static final String ADDRESS_TYPE = "addressType";
	public static final String ADDRESS = "address";
	public static final String LANDMARK = "landmark";
	public static final String DRIVER_ID = "driverId";
	// private Integer driverAddressId;
	// private String addressType;
	// private String address;
	// private String landmark;

	public DriverAddressModelDto() {
	}

	public DriverAddressModelDto(Integer driverAddressId, String addressType, String address, String landmark) {
		super();
		set(DRIVER_ADDRESS_ID, driverAddressId);
		set(ADDRESS_TYPE, addressType);
		set(ADDRESS, address);
		set(LANDMARK, landmark);
	}

	public Integer getDriverAddressId() {
		return get(DRIVER_ADDRESS_ID);
	}

	public void setDriverAddressId(Integer driverAddressId) {
		set(DRIVER_ADDRESS_ID, driverAddressId);
	}

	public String getAddressType() {
		return get(ADDRESS_TYPE);
	}

	public void setAddressType(String addressType) {
		set(ADDRESS_TYPE, addressType);
	}

	public String getAddress() {
		return get(ADDRESS);
	}

	public void setAddress(String address) {
		set(ADDRESS, address);
	}

	public String getLandmark() {
		return get(LANDMARK);
	}

	public void setLandmark(String landmark) {
		set(LANDMARK, landmark);
	}
	
	public Integer getDriverId(){
		return get(DRIVER_ID);
	}
	
	public void setDriverId(Integer dirverId){
		set(DRIVER_ID,dirverId);
	}
}