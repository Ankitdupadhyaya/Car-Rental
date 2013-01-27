package com.company.application.carrental.server.transformUtil;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverAddressModelDto;
import com.company.carrental.services.core.dto.DriverAddressDto;



public class DriverAddressClientTransformUtil{
 

 
    
    public static List<DriverAddressModelDto> transformToDriverAddressModelDtoList(List<DriverAddressDto> driverAddressDtos){
        if(driverAddressDtos == null){
            return null;
        }
        List<DriverAddressModelDto> driverAddresses = new ArrayList<DriverAddressModelDto>();
        for(DriverAddressDto driverAddressDto : driverAddressDtos){
            driverAddresses.add(transformToDriverAddressModelDto(driverAddressDto));
        }
        
        return driverAddresses;
    }
    
    public static DriverAddressModelDto transformToDriverAddressModelDto(DriverAddressDto driverAddressDto){
        if(driverAddressDto == null){
            return null;
        }
        
        DriverAddressModelDto driverAddressModelDto = new DriverAddressModelDto();
        driverAddressModelDto.setDriverAddressId(driverAddressDto.getDriverAddressId());
        driverAddressModelDto.setAddressType(driverAddressDto.getAddressType().toString());
        driverAddressModelDto.setAddress(driverAddressDto.getAddress());
        driverAddressModelDto.setLandmark(driverAddressDto.getLandmark());
//        driverAddressModelDto.setAreaId(driverAddressDto.getAreaId());
        driverAddressModelDto.setDriverId(driverAddressDto.getDriverId());
        
        return driverAddressModelDto;
    }
    
    public static List<DriverAddressDto> transformToDriverAddressDtoList(List<DriverAddressModelDto> driverAddressModelDtos){
        if(driverAddressModelDtos == null){
            return null;
        }
        List<DriverAddressDto> driverAddressDtos = new ArrayList<DriverAddressDto>();
        for(DriverAddressModelDto driverAddressModelDto : driverAddressModelDtos){
            driverAddressDtos.add(transformToDriverAddressDto(driverAddressModelDto));
        }
        
        return driverAddressDtos;
    }
    
    public static DriverAddressDto transformToDriverAddressDto(DriverAddressModelDto driverAddressModelDto){
        if(driverAddressModelDto == null){
            return null;
        }
        
        DriverAddressDto driverAddressDto = new DriverAddressDto();
        driverAddressDto.setDriverAddressId(driverAddressModelDto.getDriverAddressId());
        driverAddressDto.setAddressType(Integer.valueOf(driverAddressModelDto.getAddressType()));
        driverAddressDto.setAddress(driverAddressModelDto.getAddress());
        driverAddressDto.setAreaId(1);
//        driverAddressDto.setAreaId(driverAddressModelDto.getAreaId());
        driverAddressDto.setDriverId(driverAddressModelDto.getDriverId());
        driverAddressDto.setLandmark(driverAddressModelDto.getLandmark());
        
        return driverAddressDto;
    }
    
}