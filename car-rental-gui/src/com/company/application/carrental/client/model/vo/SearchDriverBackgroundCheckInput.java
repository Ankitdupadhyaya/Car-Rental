package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class SearchDriverBackgroundCheckInput implements Serializable {

    private static final long serialVersionUID = 6519192032628995519L;
    private Integer driverId;

    public SearchDriverBackgroundCheckInput() {
        super();
    }
            
    public SearchDriverBackgroundCheckInput(Integer driverId) {
    	this.driverId = driverId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

}