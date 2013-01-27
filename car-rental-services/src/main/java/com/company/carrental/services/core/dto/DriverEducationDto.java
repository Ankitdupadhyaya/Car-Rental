package com.company.carrental.services.core.dto;


public class DriverEducationDto {
    
    
    private Integer driverEducationId;
    private String educationType;
    private Integer yearOfPassing;
    private String university;
    private String schoolOrCollege;
    private String remarks;
    private Integer driverId;
    public Integer getDriverEducationId() {
        return driverEducationId;
    }
    public void setDriverEducationId(Integer driverEducationId) {
        this.driverEducationId = driverEducationId;
    }
    public String getEducationType() {
        return educationType;
    }
    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }
    public Integer getYearOfPassing() {
        return yearOfPassing;
    }
    public void setYearOfPassing(Integer yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    public String getSchoolOrCollege() {
        return schoolOrCollege;
    }
    public void setSchoolOrCollege(String schoolOrCollege) {
        this.schoolOrCollege = schoolOrCollege;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Integer getDriverId() {
        return driverId;
    }
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
    
}
