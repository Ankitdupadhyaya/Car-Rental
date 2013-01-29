package com.company.carrental.services.api.service;

import java.util.List;

import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.SaveDriverApplicationInputDto;
import com.company.carrental.services.core.dto.SaveDriverApplicationOutputDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundInputDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundOutputDto;
import com.company.carrental.services.core.dto.SearchDriverApplicationInputDto;
import com.company.carrental.services.core.dto.SearchDriverApplicationOutputDto;
import com.company.carrental.services.core.dto.SearchDriverBackgroundCheckInputDto;
import com.company.carrental.services.core.dto.SearchDriverBackgroundCheckOutputDto;


public interface DriverService {

    public List<DriverMaster> getAllDrivers();
    
    public DriverMaster getDriver(Integer driverId);
    
    public SaveDriverApplicationOutputDto saveDriverApplication(SaveDriverApplicationInputDto saveDriverApplicationInputDto);
    
    public SaveDriverBackgroundOutputDto saveDriverBackGround(SaveDriverBackgroundInputDto saveDriverBackgroundInputDto);
    
    public SearchDriverApplicationOutputDto searchDriverApplication(SearchDriverApplicationInputDto searchDriverApplicationInputDto);
    
    public SearchDriverBackgroundCheckOutputDto searchDriverBackgroundCheck(SearchDriverBackgroundCheckInputDto driverBackgroundCheckInputDto);
    
}