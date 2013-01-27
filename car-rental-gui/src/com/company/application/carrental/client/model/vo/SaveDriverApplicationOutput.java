package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class SaveDriverApplicationOutput implements Serializable {

    private static final long serialVersionUID = 7255634683903901134L;
    
    private DriverMasterClientDto driverMasterClientDto;

    public SaveDriverApplicationOutput() {
        super();
    }

    public SaveDriverApplicationOutput(DriverMasterClientDto driverMasterClientDto) {
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
