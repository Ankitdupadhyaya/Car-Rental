package com.company.carrental.services.core.dto;

import java.util.List;

// default package
// Generated 17 Nov, 2012 7:41:40 PM by Hibernate Tools 3.4.0.CR1


/**
 * DriverMaster generated by hbm2java
 */
public class SaveDriverBackgroundOutputDto implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1016990680874082305L;
    private List<DriverContactDto> driverContactDtos;
    private List<DriverAddressDto> driverAddressDtos;
    private List<DriverEducationDto> driverEducationDtos;
    private List<DriverEmploymentDto> driverEmploymentDtos;

    public List<DriverContactDto> getDriverContactDtos() {
        return driverContactDtos;
    }

    public void setDriverContactDtos(List<DriverContactDto> driverContactDtos) {
        this.driverContactDtos = driverContactDtos;
    }

    public List<DriverAddressDto> getDriverAddressDtos() {
        return driverAddressDtos;
    }

    public void setDriverAddressDtos(List<DriverAddressDto> driverAddressDtos) {
        this.driverAddressDtos = driverAddressDtos;
    }

    public List<DriverEducationDto> getDriverEducationDtos() {
        return driverEducationDtos;
    }

    public void setDriverEducationDtos(List<DriverEducationDto> driverEducationDtos) {
        this.driverEducationDtos = driverEducationDtos;
    }

    public List<DriverEmploymentDto> getDriverEmploymentDtos() {
        return driverEmploymentDtos;
    }

    public void setDriverEmploymentDtos(List<DriverEmploymentDto> driverEmploymentDtos) {
        this.driverEmploymentDtos = driverEmploymentDtos;
    }

    
}
