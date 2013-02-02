package com.company.application.carrental.client.model.vo;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class DriverEducationModelDto extends BaseModelData {

	private static final long serialVersionUID = -653180921138482184L;

	public static final String DRIVER_EDUCATION_ID = "driverEducationId";
	public static final String EDUCATION_TYPE = "educationType";
	public static final String YEAR_OF_PASSING = "yearofPassing";
	public static final String UNIVERSITY = "university";
	public static final String SCHOOL_OR_COLLEGE = "school_college";
	public static final String REMARKS = "remarks";
	public static final String DRIVER_ID = "driverId";
	// private Integer driverEducationId;
	// private String educationType;
	// private String yearofPassing;
	// private String university;
	// private String school_college;
	// private String remarks;

	public DriverEducationModelDto() {
	}

	public DriverEducationModelDto(Integer driverEducationId, String educationType, String yearofPassing, String university,
			String school_college, String remarks) {
		super();
		set(DRIVER_EDUCATION_ID, driverEducationId);
		set(EDUCATION_TYPE, educationType);
		set(YEAR_OF_PASSING, yearofPassing);
		set(UNIVERSITY, university);
		set(SCHOOL_OR_COLLEGE, school_college);
		set(REMARKS, remarks);
	}

	public Integer getDriverEducationId() {
		return get(DRIVER_EDUCATION_ID);
	}

	public void setDriverEducationId(Integer driverEducationId) {
		set(DRIVER_EDUCATION_ID, driverEducationId);
	}

	public String getEducationType() {
		return get(EDUCATION_TYPE);
	}

	public void setEducationType(String educationType) {
		set(EDUCATION_TYPE, educationType);
	}

	public String getYearOfPassing() {
		return get(YEAR_OF_PASSING);
	}

	public void setYearOfPassing(String yearofPassing) {
		set(YEAR_OF_PASSING, yearofPassing);
	}

	public String getUniversity() {
		return get(UNIVERSITY);
	}

	public void setUniversity(String university) {
		set(UNIVERSITY, university);
	}

	public String getSchoolOrCollege() {
		return get(SCHOOL_OR_COLLEGE);
	}

	public void setSchoolOrCollege(String school_college) {
		set(SCHOOL_OR_COLLEGE, school_college);
	}

	public String getRemarks() {
		return get(REMARKS);
	}

	public void setRemarks(String remarks) {
		set(REMARKS, remarks);
	}
	
	public Integer getDriverId(){
		return get(DRIVER_ID);
	}
	
	public void setDriverId(Integer dirverId){
		set(DRIVER_ID,dirverId);
	}
}