
package com.company.carrental.data.pojo;

import java.util.Date;

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
@Table(name = "Driver_Employment")
public class DriverEmployment {
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
    
    DriverMaster driverMaster;
    
    @ManyToOne
    @JoinColumn(name = "Driver_Id", nullable = false)
    @Cascade(value = CascadeType.DELETE_ORPHAN)
    public DriverMaster getDriverMaster() {
            return driverMaster;
    }
    public void setDriverMaster(DriverMaster driverMaster) {
            this.driverMaster = driverMaster;
    }

    @Id
    @Column(name = "Driver_Employment_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getDriverEmploymentId() {
        return driverEmploymentId;
    }
    public void setDriverEmploymentId(Integer driverEmploymentId) {
        this.driverEmploymentId = driverEmploymentId;
    }
    @Column(name= "Employment_Type",nullable=true)
    public String getEmploymentType() {
        return employmentType;
    }
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }
    
    @Column(name= "Begin_Date",nullable=true)
    public Date getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
    
    @Column(name= "End_Date",nullable=true)
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    @Column(name= "Employer_Name",nullable=true)
    public String getEmployerName() {
        return employerName;
    }
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    @Column(name= "Company_Name",nullable=true)
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    @Column(name= "Employer_Address",nullable=true)
    public String getEmployerAddress() {
        return employerAddress;
    }
    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }
    
    @Column(name= "Reason_For_Leaving",nullable=true)
    public String getReasonForLeaving() {
        return reasonForLeaving;
    }
    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }
    
    @Column(name= "Salary",nullable=true)
    public Float getSalary() {
        return salary;
    }
    public void setSalary(Float salary) {
        this.salary = salary;
    }
    
    @Column(name= "Reference_Allowed",nullable=true)
    public String getReferenceAllowed() {
        return referenceAllowed;
    }
    public void setReferenceAllowed(String referenceAllowed) {
        this.referenceAllowed = referenceAllowed;
    }
    
    
    

}
