package com.company.carrental.services.core.dto;



public class DriverContactDto {
    private Integer driverContactId;
    private String contactNumber;
    private Boolean isPrimary;
    private Integer contactType;
    private Integer driverId;
    
    public Integer getDriverContactId() {
        return driverContactId;
    }
    public void setDriverContactId(Integer driverContactId) {
        this.driverContactId = driverContactId;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public Boolean getIsPrimary() {
        return isPrimary;
    }
    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }
    public Integer getContactType() {
        return contactType;
    }
    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }
    public Integer getDriverId() {
        return driverId;
    }
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    }
