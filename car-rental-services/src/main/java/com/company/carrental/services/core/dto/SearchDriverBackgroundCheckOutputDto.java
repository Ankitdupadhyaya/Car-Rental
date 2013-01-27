package com.company.carrental.services.core.dto;

import java.io.Serializable;
import java.util.List;

public class SearchDriverBackgroundCheckOutputDto implements Serializable {

    private static final long serialVersionUID = 5778670084717201925L;
    private List<DriverContactDto> DriverContactDtos;
    private List<DriverAddressDto> DriverAddressDtos;
    private List<DriverEducationDto> DriverEducationDtos;
    private List<DriverEmploymentDto> DriverEmploymentDtos;

    public SearchDriverBackgroundCheckOutputDto() {
        super();
    }

    public List<DriverContactDto> getDriverContactDtos() {
        return DriverContactDtos;
    }

    public void setDriverContactDtos(List<DriverContactDto> DriverContactDtos) {
        this.DriverContactDtos = DriverContactDtos;
    }

    public List<DriverAddressDto> getDriverAddressDtos() {
        return DriverAddressDtos;
    }

    public void setDriverAddressDtos(List<DriverAddressDto> DriverAddressDtos) {
        this.DriverAddressDtos = DriverAddressDtos;
    }

    public List<DriverEducationDto> getDriverEducationDtos() {
        return DriverEducationDtos;
    }

    public void setDriverEducationDtos(List<DriverEducationDto> DriverEducationDtos) {
        this.DriverEducationDtos = DriverEducationDtos;
    }

    public List<DriverEmploymentDto> getDriverEmploymentDtos() {
        return DriverEmploymentDtos;
    }

    public void setDriverEmploymentDtos(List<DriverEmploymentDto> DriverEmploymentDtos) {
        this.DriverEmploymentDtos = DriverEmploymentDtos;
    }


}