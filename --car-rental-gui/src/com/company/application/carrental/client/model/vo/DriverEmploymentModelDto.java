package com.company.application.carrental.client.model.vo;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class DriverEmploymentModelDto extends BaseModelData {

	private static final long serialVersionUID = -653180921138482184L;

	public static final String DRIVER_EMPLOYMENT_ID = "driverEmploymentId";
	public static final String EMPLOYMENT_TYPE = "employmentType";
	public static final String BEGIN_DATE = "beginDate";
	public static final String END_DATE = "endDate";
	public static final String EMPLOYER_NAME = "employerName";
	public static final String COMPANY_NAME = "companyName";
	public static final String EMPLOYER_ADDRESS = "employerAddress";
	public static final String EMPLOYER_CONTACT_NO = "employerContactNo";
	public static final String REASON_FOR_LEAVING = "reasonForLeaving";
	public static final String SALARY = "salary";
	public static final String REFERENCE_ALLOWED = "referenceAllowed";
	public static final String DRIVER_ID = "driverId";
	
	public DriverEmploymentModelDto() {
	}

	public DriverEmploymentModelDto(Integer driverEmploymentId, String employmentType, Date beginDate, Date endDate, String employerName,
			String companyName, String employerAddress, String employerContactNo, String reasonForLeaving, double salary, char referenceAllowed) {
		super();
		set(DRIVER_EMPLOYMENT_ID, driverEmploymentId);
		set(EMPLOYMENT_TYPE, employmentType);
		set(BEGIN_DATE, beginDate);
		set(END_DATE, endDate);
		set(EMPLOYER_NAME, employerName);
		set(COMPANY_NAME, companyName);
		set(EMPLOYER_ADDRESS, employerAddress);
		set(EMPLOYER_CONTACT_NO, employerContactNo);
		set(REASON_FOR_LEAVING, reasonForLeaving);
		set(SALARY, salary);
		set(REFERENCE_ALLOWED, referenceAllowed);
	}

	public Integer getDriverEmploymentId() {
		return get(DRIVER_EMPLOYMENT_ID);
	}

	public void setDriverEmploymentId(Integer driverEmploymentId) {
		set(DRIVER_EMPLOYMENT_ID, driverEmploymentId);
	}

	public String getEmploymentType() {
		return get(EMPLOYMENT_TYPE);
	}

	public void setEmploymentType(String employmentType) {
		set(EMPLOYMENT_TYPE, employmentType);
	}

	public Date getBeginDate() {
		return get(BEGIN_DATE);
	}

	public void setBeginDate(Date beginDate) {
		set(BEGIN_DATE, beginDate);
	}

	public Date getEndDate() {
		return get(END_DATE);
	}

	public void setEndDate(Date endDate) {
		set(END_DATE, endDate);
	}

	public String getEmployerName() {
		return get(EMPLOYER_NAME);
	}

	public void setEmployerName(String employerName) {
		set(EMPLOYER_NAME, employerName);
	}

	public String getCompanyName() {
		return get(COMPANY_NAME);
	}

	public void setCompanyName(String companyName) {
		set(COMPANY_NAME, companyName);
	}

	public String getEmployerAddress() {
		return get(EMPLOYER_ADDRESS);
	}

	public void setEmployerAddress(String employerAddress) {
		set(EMPLOYER_ADDRESS, employerAddress);
	}

	public String getEmployerContactNo() {
		return get(EMPLOYER_CONTACT_NO);
	}

	public void setEmployerContactNo(String employerContactNo) {
		set(EMPLOYER_CONTACT_NO, employerContactNo);
	}

	public String getReasonForLeaving() {
		return get(REASON_FOR_LEAVING);
	}

	public void setReasonForLeaving(String reasonForLeaving) {
		set(REASON_FOR_LEAVING, reasonForLeaving);
	}

	public double getSalary() {
		return get(SALARY);
	}

	public void setSalary(double salary) {
		set(SALARY, salary);
	}

	public char getReferenceAllowed() {
		return get(REFERENCE_ALLOWED);
	}

	public void setReferenceAllowed(char referenceAllowed) {
		set(REFERENCE_ALLOWED, referenceAllowed);
	}
	
	public Integer getDriverId(){
		return get(DRIVER_ID);
	}
	
	public void setDriverId(Integer dirverId){
		set(DRIVER_ID,dirverId);
	}
}