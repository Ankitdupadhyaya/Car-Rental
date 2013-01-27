package com.company.application.carrental.client.model.vo;

import java.io.Serializable;
import java.util.Date;

public class DriverEmployment implements Serializable {

	private static final long serialVersionUID = -653180921138482184L;

	private Integer driverEmploymentId;
	private String employmentType;
	private Date beginDate;
	private Date endDate;
	private String employerName;
	private String companyName;
	private String employerAddress;
	private String employerContactNo;
	private String reasonForLeaving;
	private double salary;
	private char referenceAllowed;

	public DriverEmployment() {
	}

	public DriverEmployment(Integer driverEmploymentId, String employmentType, Date beginDate, Date endDate, String employerName,
			String companyName, String employerAddress, String employerContactNo, String reasonForLeaving, double salary, char referenceAllowed) {
		super();
		this.driverEmploymentId = driverEmploymentId;
		this.employmentType = employmentType;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.employerName = employerName;
		this.companyName = companyName;
		this.employerAddress = employerAddress;
		this.employerContactNo = employerContactNo;
		this.reasonForLeaving = reasonForLeaving;
		this.salary = salary;
		this.referenceAllowed = referenceAllowed;
	}

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

	public String getEmployerContactNo() {
		return employerContactNo;
	}

	public void setEmployerContactNo(String employerContactNo) {
		this.employerContactNo = employerContactNo;
	}

	public String getReasonForLeaving() {
		return reasonForLeaving;
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		this.reasonForLeaving = reasonForLeaving;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public char getReferenceAllowed() {
		return referenceAllowed;
	}

	public void setReferenceAllowed(char referenceAllowed) {
		this.referenceAllowed = referenceAllowed;
	}
}