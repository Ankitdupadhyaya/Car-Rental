package com.company.application.carrental.client.model.vo;

import java.io.Serializable;
import java.util.List;

public class SaveDriverBackgroundCheckOutput implements Serializable {


    /**
     * 
     */
    private static final long serialVersionUID = 1016990680874082305L;
    private List<DriverContactModelDto> driverContactModelDtos;
    private List<DriverAddressModelDto> driverAddressModelDtos;
    private List<DriverEducationModelDto> driverEducationModelDtos;
    private List<DriverEmploymentModelDto> driverEmploymentModelDtos;

    public List<DriverContactModelDto> getDriverContactDtos() {
        return driverContactModelDtos;
    }

    public void setDriverContactDtos(List<DriverContactModelDto> driverContactDtos) {
        this.driverContactModelDtos = driverContactDtos;
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


}
