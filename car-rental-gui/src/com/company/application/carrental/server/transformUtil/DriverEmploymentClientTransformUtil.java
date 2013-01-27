package com.company.application.carrental.server.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.application.carrental.client.model.vo.DriverEmploymentModelDto;
import com.company.carrental.data.pojo.DriverEmployment;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverEmploymentDto;



public class DriverEmploymentClientTransformUtil{



    public static List<DriverEmploymentDto> transformToDriverEmploymentDtoList(List<DriverEmploymentModelDto> driverEmploymentModelDtos){
        if(driverEmploymentModelDtos == null){
            return null;
        }
        
        List<DriverEmploymentDto> driverEmploymentDtos = new ArrayList<DriverEmploymentDto>();
        for(DriverEmploymentModelDto driverEmploymentModelDto : driverEmploymentModelDtos){
            driverEmploymentDtos.add(transformToDriverEmploymentDto(driverEmploymentModelDto));
        }
        return driverEmploymentDtos;
    }
    
    public static DriverEmploymentDto transformToDriverEmploymentDto(DriverEmploymentModelDto driverEmploymentModelDto) {

        if (driverEmploymentModelDto == null) {
            return null;
        }

        DriverEmploymentDto driverEmploymentDto = new DriverEmploymentDto();
        driverEmploymentDto.setDriverEmploymentId(driverEmploymentModelDto.getDriverEmploymentId());
        driverEmploymentDto.setCompanyName(driverEmploymentModelDto.getCompanyName());
        driverEmploymentDto.setBeginDate(driverEmploymentModelDto.getBeginDate());
        driverEmploymentDto.setEndDate(driverEmploymentModelDto.getEndDate());
        driverEmploymentDto.setEmployerName(driverEmploymentModelDto.getEmployerName());
        driverEmploymentDto.setEmploymentType(driverEmploymentModelDto.getEmploymentType());
        driverEmploymentDto.setEmployerAddress(driverEmploymentModelDto.getEmployerAddress());
        driverEmploymentDto.setReasonForLeaving(driverEmploymentModelDto.getReasonForLeaving());
        driverEmploymentDto.setReferenceAllowed(String.valueOf(driverEmploymentModelDto.getReferenceAllowed()));
//        driverEmploymentDto.setSalary(driverEmploymentModelDto.getSalary());
        driverEmploymentDto.setDriverId(driverEmploymentModelDto.getDriverId());

        return driverEmploymentDto;

    }

    public static List<DriverEmploymentModelDto> transformToDriverEmploymentModelDtoList(List<DriverEmploymentDto> driverEmploymentDtos){
        if(driverEmploymentDtos == null){
            return null;
        }
        
        List<DriverEmploymentModelDto> driverEmploymentModelDtos = new ArrayList<DriverEmploymentModelDto>();
        for(DriverEmploymentDto driverEmploymentDto : driverEmploymentDtos){
            driverEmploymentModelDtos.add(transformToDriverEmploymentModelDto(driverEmploymentDto));
        }
        return driverEmploymentModelDtos;
    }
    
    public static DriverEmploymentModelDto transformToDriverEmploymentModelDto(DriverEmploymentDto driverEmploymentDto) {

        if (driverEmploymentDto == null) {
            return null;
        }

        DriverEmploymentModelDto driverEmploymentModelDto = new DriverEmploymentModelDto();
        driverEmploymentModelDto.setDriverEmploymentId(driverEmploymentDto.getDriverEmploymentId());
        driverEmploymentModelDto.setCompanyName(driverEmploymentDto.getCompanyName());
        driverEmploymentModelDto.setBeginDate(driverEmploymentDto.getBeginDate());
        driverEmploymentModelDto.setEndDate(driverEmploymentDto.getEndDate());
        driverEmploymentModelDto.setEmployerName(driverEmploymentDto.getEmployerName());
        driverEmploymentModelDto.setEmploymentType(driverEmploymentDto.getEmploymentType());
        driverEmploymentModelDto.setEmployerAddress(driverEmploymentDto.getEmployerAddress());
        driverEmploymentModelDto.setReasonForLeaving(driverEmploymentDto.getReasonForLeaving());
        driverEmploymentModelDto.setReferenceAllowed(driverEmploymentDto.getReferenceAllowed().charAt(0));
        driverEmploymentModelDto.setSalary(driverEmploymentDto.getSalary());
        driverEmploymentModelDto.setDriverId(driverEmploymentDto.getDriverId());

        return driverEmploymentModelDto;

    }


    
    
}