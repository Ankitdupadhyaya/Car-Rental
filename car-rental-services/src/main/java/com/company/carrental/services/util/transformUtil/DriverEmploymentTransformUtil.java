package com.company.carrental.services.util.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.carrental.data.pojo.DriverEmployment;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverEmploymentDto;

public class DriverEmploymentTransformUtil {


    public static List<DriverEmploymentDto> transformToDriverEmploymentDtoList(Set<DriverEmployment> driverEmployments){
        if(driverEmployments == null){
            return null;
        }
        
        List<DriverEmploymentDto> driverEmploymentDtos = new ArrayList<DriverEmploymentDto>();
        for(DriverEmployment driverEmployment : driverEmployments){
            driverEmploymentDtos.add(transformToDriverEmploymentDto(driverEmployment));
        }
        return driverEmploymentDtos;
    }
    
    public static DriverEmploymentDto transformToDriverEmploymentDto(DriverEmployment driverEmployment) {

        if (driverEmployment == null) {
            return null;
        }

        DriverEmploymentDto driverEmploymentDto = new DriverEmploymentDto();
        driverEmploymentDto.setDriverEmploymentId(driverEmployment.getDriverEmploymentId());
        driverEmploymentDto.setCompanyName(driverEmployment.getCompanyName());
        driverEmploymentDto.setBeginDate(driverEmployment.getBeginDate());
        driverEmploymentDto.setEndDate(driverEmployment.getEndDate());
        driverEmploymentDto.setEmployerName(driverEmployment.getEmployerName());
        driverEmploymentDto.setEmploymentType(driverEmployment.getEmploymentType());
        driverEmploymentDto.setEmployerAddress(driverEmployment.getEmployerAddress());
        driverEmploymentDto.setReasonForLeaving(driverEmployment.getReasonForLeaving());
        driverEmploymentDto.setReferenceAllowed(driverEmployment.getReferenceAllowed());
        driverEmploymentDto.setSalary(driverEmployment.getSalary());
        driverEmploymentDto.setDriverId(driverEmployment.getDriverMaster().getDriverId());

        return driverEmploymentDto;

    }

    public static Set<DriverEmployment> transformToDriverEmploymentSet(List<DriverEmploymentDto> driverEmploymentDtos){
        if(driverEmploymentDtos == null){
            return null;
        }
        
        Set<DriverEmployment> driverEmployments = new HashSet<DriverEmployment>();
        for(DriverEmploymentDto driverEmploymentDto : driverEmploymentDtos){
            driverEmployments.add(transformToDriverEmployment(driverEmploymentDto));
        }
        return driverEmployments;
    }
    
    public static DriverEmployment transformToDriverEmployment(DriverEmploymentDto driverEmploymentDto) {

        if (driverEmploymentDto == null) {
            return null;
        }

        DriverEmployment driverEmployment = new DriverEmployment();
        driverEmployment.setDriverEmploymentId(driverEmploymentDto.getDriverEmploymentId());
        driverEmployment.setCompanyName(driverEmploymentDto.getCompanyName());
        driverEmployment.setBeginDate(driverEmploymentDto.getBeginDate());
        driverEmployment.setEndDate(driverEmploymentDto.getEndDate());
        driverEmployment.setEmployerName(driverEmploymentDto.getEmployerName());
        driverEmployment.setEmploymentType(driverEmploymentDto.getEmploymentType());
        driverEmployment.setEmployerAddress(driverEmploymentDto.getEmployerAddress());
        driverEmployment.setReasonForLeaving(driverEmploymentDto.getReasonForLeaving());
        driverEmployment.setReferenceAllowed(driverEmploymentDto.getReferenceAllowed());
        driverEmployment.setSalary(driverEmploymentDto.getSalary());
        driverEmployment.setDriverMaster(new DriverMaster(driverEmploymentDto.getDriverId()));

        return driverEmployment;

    }

}