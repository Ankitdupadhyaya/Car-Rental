package com.company.application.carrental.server.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.application.carrental.client.model.vo.DriverEducationModelDto;
import com.company.carrental.data.pojo.DriverEducation;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverEducationDto;



public class DriverEducationClientTransformUtil{

    
    public static List<DriverEducationModelDto> transformToDriverEducationModelDtoList(List<DriverEducationDto> driverEducationDtos){
        if(driverEducationDtos == null){
            return null;
        }
        
        List<DriverEducationModelDto> driverEducationModelDtos = new ArrayList<DriverEducationModelDto>();
        for(DriverEducationDto driverEducationDto : driverEducationDtos){
        	driverEducationModelDtos.add(transformToDriverEducationModelDto(driverEducationDto));
        }
        
        return driverEducationModelDtos;
        
    }
    
    public static DriverEducationModelDto transformToDriverEducationModelDto(DriverEducationDto driverEducationDto){
        if(driverEducationDto == null){
            return null;
        }
        
        DriverEducationModelDto driverEducationModelDto = new DriverEducationModelDto();
        driverEducationModelDto.setDriverEducationId(driverEducationDto.getDriverEducationId());
        driverEducationModelDto.setEducationType(driverEducationDto.getEducationType());
        driverEducationModelDto.setRemarks(driverEducationDto.getRemarks());
        driverEducationModelDto.setSchoolOrCollege(driverEducationDto.getSchoolOrCollege());
        driverEducationModelDto.setUniversity(driverEducationDto.getUniversity());
        driverEducationModelDto.setYearOfPassing(String.valueOf(driverEducationDto.getYearOfPassing()));
        driverEducationModelDto.setDriverId(driverEducationDto.getDriverId());
        
        return driverEducationModelDto;
    }
    
    public static List<DriverEducationDto> transformToDriverEducationDtoList(List<DriverEducationModelDto> driverEducationModelDtos){
        if(driverEducationModelDtos == null){
            return null;
        }
        
        List<DriverEducationDto> driverEducationDtos = new ArrayList<DriverEducationDto>();
        for(DriverEducationModelDto driverEducationModelDto : driverEducationModelDtos){
            driverEducationDtos.add(transformToDriverEducationDto(driverEducationModelDto));
        }
        
        return driverEducationDtos;
        
    }
    
    public static DriverEducationDto transformToDriverEducationDto(DriverEducationModelDto driverEducationModelDto){
        if(driverEducationModelDto == null){
            return null;
        }
        
        DriverEducationDto driverEducationDto = new DriverEducationDto();
        driverEducationDto.setDriverEducationId(driverEducationModelDto.getDriverEducationId());
        driverEducationDto.setEducationType(driverEducationModelDto.getEducationType());
        driverEducationDto.setRemarks(driverEducationModelDto.getRemarks());
        driverEducationDto.setSchoolOrCollege(driverEducationModelDto.getSchoolOrCollege());
        driverEducationDto.setUniversity(driverEducationModelDto.getUniversity());
        driverEducationDto.setYearOfPassing(Integer.valueOf(driverEducationModelDto.getYearOfPassing()));
        driverEducationDto.setDriverId(driverEducationModelDto.getDriverId());
        
        return driverEducationDto;
    }
    
    
    
}