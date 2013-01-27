package com.company.carrental.services.core.dto;


public class DriverAddressDto {
    private Integer driverAddressId;
    private Integer addressType;
    private String address;
    private String landmark;
    private Integer areaId;
    private Integer driverId;
    public Integer getDriverAddressId() {
        return driverAddressId;
    }
    public void setDriverAddressId(Integer driverAddressId) {
        this.driverAddressId = driverAddressId;
    }
    public Integer getAddressType() {
        return addressType;
    }
    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getAreaId() {
        return areaId;
    }
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    public Integer getDriverId() {
        return driverId;
    }
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
        

}
