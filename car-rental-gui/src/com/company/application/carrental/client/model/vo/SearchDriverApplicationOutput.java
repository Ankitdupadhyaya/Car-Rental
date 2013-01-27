package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class SearchDriverApplicationOutput implements Serializable {

    private static final long serialVersionUID = 5778670084717201925L;
    private DriverMasterClientDto driverMasterClientDto;

    public SearchDriverApplicationOutput() {
        super();
    }

    public DriverMasterClientDto getDriverMasterClientDto() {
        return driverMasterClientDto;
    }

    public void setDriverMasterClientDto(DriverMasterClientDto driverMasterClientDto) {
        this.driverMasterClientDto = driverMasterClientDto;
    }
}