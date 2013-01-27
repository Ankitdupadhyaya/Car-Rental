package com.company.carrental.services.util.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.carrental.data.pojo.DriverEducation;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverEducationDto;



public class DriverEducationTransformUtil{
    
    public static Set<DriverEducation> transformToDriverEducationSet(List<DriverEducationDto> driverEducationDtos){
        if(driverEducationDtos == null){
            return null;
        }
        
        Set<DriverEducation> driverEducations = new HashSet<DriverEducation>();
        for(DriverEducationDto driverEducationDto : driverEducationDtos){
            driverEducations.add(transformToDriverEducation(driverEducationDto));
        }
        
        return driverEducations;
        
    }
    
    public static DriverEducation transformToDriverEducation(DriverEducationDto driverEducationDto){
        if(driverEducationDto == null){
            return null;
        }
        
        DriverEducation driverEducation = new DriverEducation();
        driverEducation.setDriverEducationId(driverEducationDto.getDriverEducationId());
        driverEducation.setEducationType(driverEducationDto.getEducationType());
        driverEducation.setRemarks(driverEducationDto.getRemarks());
        driverEducation.setSchoolOrCollege(driverEducationDto.getSchoolOrCollege());
        driverEducation.setUniversity(driverEducationDto.getUniversity());
        driverEducation.setYearOfPassing(driverEducationDto.getYearOfPassing());
        driverEducation.setDriverMaster(new DriverMaster(driverEducationDto.getDriverId()));
        
        return driverEducation;
    }
    
    public static List<DriverEducationDto> transformToDriverEducationDtoList(Set<DriverEducation> driverEducations){
        if(driverEducations == null){
            return null;
        }
        
        List<DriverEducationDto> driverEducationDtos = new ArrayList<DriverEducationDto>();
        for(DriverEducation driverEducation : driverEducations){
            driverEducationDtos.add(transformToDriverEducationDto(driverEducation));
        }
        
        return driverEducationDtos;
        
    }
    
    public static DriverEducationDto transformToDriverEducationDto(DriverEducation driverEducation){
        if(driverEducation == null){
            return null;
        }
        
        DriverEducationDto driverEducationDto = new DriverEducationDto();
        driverEducationDto.setDriverEducationId(driverEducation.getDriverEducationId());
        driverEducationDto.setEducationType(driverEducation.getEducationType());
        driverEducationDto.setRemarks(driverEducation.getRemarks());
        driverEducationDto.setSchoolOrCollege(driverEducation.getSchoolOrCollege());
        driverEducationDto.setUniversity(driverEducation.getUniversity());
        driverEducationDto.setYearOfPassing(driverEducation.getYearOfPassing());
        driverEducationDto.setDriverId(driverEducation.getDriverMaster().getDriverId());
        
        return driverEducationDto;
    }
    
}