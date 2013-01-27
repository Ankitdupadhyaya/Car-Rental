package com.company.carrental.services.core.dto;

import java.io.Serializable;

public class SearchDriverBackgroundCheckInputDto implements Serializable {

    private static final long serialVersionUID = 6519192032628995519L;
    private Integer driverId;

    public SearchDriverBackgroundCheckInputDto() {
        super();
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

}