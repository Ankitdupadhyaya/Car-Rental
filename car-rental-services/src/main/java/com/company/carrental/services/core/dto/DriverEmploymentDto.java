package com.company.carrental.services.core.dto;

import java.util.Date;

public class DriverEmploymentDto {
    private Integer driverEmploymentId;
    private String employmentType;
    private Date beginDate;
    private Date endDate;
    private String employerName;
    private String companyName;
    private String employerAddress;
    private String reasonForLeaving;
    private Float salary;
    private String referenceAllowed;
    private Integer driverId;
    
    public Integer getDriverEmploymentId() {
        return driverEmploymentId;
    }
    public void setDriverEmploymentId(Integer driverEmploymentId) {
        this.driverEmploymentId = driverEmploymentId;
    }
    public String getEmploymentType() {
        return employmentType;
    }
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
    public Date getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public String getEmployerName() {
        return employerName;
    }
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getEmployerAddress() {
        return employerAddress;
    }
    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }
    public String getReasonForLeaving() {
        return reasonForLeaving;
    }
    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }
    public Float getSalary() {
        return salary;
    }
    public void setSalary(Float salary) {
        this.salary = salary;
    }
    public String getReferenceAllowed() {
        return referenceAllowed;
    }
    public void setReferenceAllowed(String referenceAllowed) {
        this.referenceAllowed = referenceAllowed;
    }
    public Integer getDriverId() {
        return driverId;
    }
    public void setDriverId(Integer driverMaster) {
        this.driverId = driverMaster;
    }
    

}
