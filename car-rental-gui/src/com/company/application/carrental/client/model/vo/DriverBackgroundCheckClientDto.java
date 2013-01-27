package com.company.application.carrental.client.model.vo;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class DriverBackgroundCheckClientDto extends BaseModelData {

	private static final long serialVersionUID = -7082422284984828865L;

	private String identificationCode;
	private String maritalStatus;
	private String passportNo;
	private String panNo;
	private boolean trafficViolation;
	private boolean employmentGap;
	private boolean financialRegCheck;

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public boolean isTrafficViolation() {
		return trafficViolation;
	}

	public void setTrafficViolation(boolean trafficViolation) {
		this.trafficViolation = trafficViolation;
	}

	public boolean isEmploymentGap() {
		return employmentGap;
	}

	public void setEmploymentGap(boolean employmentGap) {
		this.employmentGap = employmentGap;
	}

	public boolean isFinancialRegCheck() {
		return financialRegCheck;
	}

	public void setFinancialRegCheck(boolean financialRegCheck) {
		this.financialRegCheck = financialRegCheck;
	}
}