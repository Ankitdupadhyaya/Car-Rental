package com.company.application.carrental.client.model.vo;

import java.io.Serializable;

public class SearchDriverApplicationInput implements Serializable {

    private static final long serialVersionUID = 6519192032628995519L;
    private Integer driverId;

    public SearchDriverApplicationInput() {
        super();
    }
    
    public SearchDriverApplicationInput(Integer driverId) {
     this.driverId = driverId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

}