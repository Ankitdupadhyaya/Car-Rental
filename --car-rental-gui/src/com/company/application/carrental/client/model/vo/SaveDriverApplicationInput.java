package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class SaveDriverApplicationInput implements Serializable {

    private static final long serialVersionUID = 6224940718531677881L;

    private DriverMasterClientDto driverMasterClientDto;

    public SaveDriverApplicationInput() {
        super();
    }

    public SaveDriverApplicationInput(DriverMasterClientDto driverMasterClientDto) {
        super();
        this.driverMasterClientDto = driverMasterClientDto;
    }

    public DriverMasterClientDto getDriverMasterClientDto() {
        return driverMasterClientDto;
    }

    public void setDriverMasterClientDto(DriverMasterClientDto driverMasterClientDto) {
        this.driverMasterClientDto = driverMasterClientDto;
    }
}