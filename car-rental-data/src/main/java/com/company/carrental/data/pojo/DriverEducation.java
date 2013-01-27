package com.company.carrental.data.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "Driver_Education")
public class DriverEducation {
    
    
    private Integer driverEducationId;
    private String educationType;
    private Integer yearOfPassing;
    private String university;
    private String schoolOrCollege;
    private String remarks;
    
    DriverMaster driverMaster;
    

    @Id
    @Column(name = "Driver_Education_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getDriverEducationId() {
        return driverEducationId;
    }
    public void setDriverEducationId(Integer driverEducationId) {
        this.driverEducationId = driverEducationId;
    }
    @Column(name= "Education_Type",nullable=false)
    public String getEducationType() {
        return educationType;
    }
    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }
    
    @Column(name= "Year_Of_Passing",nullable=false)
    public Integer getYearOfPassing() {
        return yearOfPassing;
    }
    public void setYearOfPassing(Integer yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }
    
    @Column(name= "University",nullable=false)
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }
    
    @Column(name= "School_Or_College",nullable=false)
    public String getSchoolOrCollege() {
        return schoolOrCollege;
    }
    public void setSchoolOrCollege(String schoolOrCollege) {
        this.schoolOrCollege = schoolOrCollege;
    }
    
    @Column(name= "Remarks",nullable=false)
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    @ManyToOne
    @JoinColumn(name = "Driver_Id", nullable = false)
    @Cascade(value = CascadeType.DELETE_ORPHAN)
    public DriverMaster getDriverMaster() {
        return driverMaster;
    }
    
    public void setDriverMaster(DriverMaster driverMaster) {
        this.driverMaster = driverMaster;
    }
    
}
