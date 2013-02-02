package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class DriverEducation implements Serializable {

	private static final long serialVersionUID = -653180921138482184L;

	private Integer driverEducationId;
	private String educationType;
	private String yearofPassing;
	private String university;
	private String school_college;
	private String remarks;

	public DriverEducation() {
	}

	public DriverEducation(Integer driverEducationId, String educationType, String yearofPassing, String university, String school_college,
			String remarks) {
		super();
		this.driverEducationId = driverEducationId;
		this.educationType = educationType;
		this.yearofPassing = yearofPassing;
		this.university = university;
		this.school_college = school_college;
		this.remarks = remarks;
	}

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

	public String getYearofPassing() {
		return yearofPassing;
	}

	public void setYearofPassing(String yearofPassing) {
		this.yearofPassing = yearofPassing;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSchool_college() {
		return school_college;
	}

	public void setSchool_college(String school_college) {
		this.school_college = school_college;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}