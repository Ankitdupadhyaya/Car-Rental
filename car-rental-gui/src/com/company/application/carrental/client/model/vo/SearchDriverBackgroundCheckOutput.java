package com.company.application.carrental.client.model.vo;

import java.io.Serializable;
import java.util.List;

public class SearchDriverBackgroundCheckOutput implements Serializable {

    private static final long serialVersionUID = 5778670084717201925L;
    private Integer driverId;
    private List<DriverContactModelDto> driverContactModelDtos;
    private List<DriverAddressModelDto> driverAddressModelDtos;
    private List<DriverEducationModelDto> driverEducationModelDtos;
    private List<DriverEmploymentModelDto> driverEmploymentModelDtos;

    public SearchDriverBackgroundCheckOutput() {
        super();
    }

	public List<DriverContactModelDto> getDriverContactModelDtos() {
		return driverContactModelDtos;
	}

	public void setDriverContactModelDtos(
			List<DriverContactModelDto> driverContactModelDtos) {
		this.driverContactModelDtos = driverContactModelDtos;
	}

	public List<DriverAddressModelDto> getDriverAddressModelDtos() {
		return driverAddressModelDtos;
	}

	public void setDriverAddressModelDtos(
			List<DriverAddressModelDto> driverAddressModelDtos) {
		this.driverAddressModelDtos = driverAddressModelDtos;
	}

	public List<DriverEducationModelDto> getDriverEducationModelDtos() {
		return driverEducationModelDtos;
	}

	public void setDriverEducationModelDtos(
			List<DriverEducationModelDto> driverEducationModelDtos) {
		this.driverEducationModelDtos = driverEducationModelDtos;
	}

	public List<DriverEmploymentModelDto> getDriverEmploymentModelDtos() {
		return driverEmploymentModelDtos;
	}

	public void setDriverEmploymentModelDtos(
			List<DriverEmploymentModelDto> driverEmploymentModelDtos) {
		this.driverEmploymentModelDtos = driverEmploymentModelDtos;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}


}