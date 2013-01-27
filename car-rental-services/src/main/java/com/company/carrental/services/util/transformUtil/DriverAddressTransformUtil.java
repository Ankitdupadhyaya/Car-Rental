package com.company.carrental.services.util.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.carrental.data.pojo.AddressTypeMaster;
import com.company.carrental.data.pojo.AreaMaster;
import com.company.carrental.data.pojo.DriverAddress;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverAddressDto;



public class DriverAddressTransformUtil{
    
    public static Set<DriverAddress> transformToDriverAddressSet(List<DriverAddressDto> driverAddressDtos){
        if(driverAddressDtos == null){
            return null;
        }
        Set<DriverAddress> driverAddresses = new HashSet<DriverAddress>();
        for(DriverAddressDto driverAddressDto : driverAddressDtos){
            driverAddresses.add(transformToDriverAddress(driverAddressDto));
        }
        
        return driverAddresses;
    }
    
    public static DriverAddress transformToDriverAddress(DriverAddressDto driverAddressDto){
        if(driverAddressDto == null){
            return null;
        }
        
        DriverAddress driverAddress = new DriverAddress();
        driverAddress.setDriverAddressId(driverAddressDto.getDriverAddressId());
        driverAddress.setAddressTypeMaster(new AddressTypeMaster(driverAddressDto.getAddressType()));
        driverAddress.setAddress(driverAddressDto.getAddress());
        driverAddress.setLandmark(driverAddressDto.getLandmark());
        driverAddress.setAreaMaster(new AreaMaster(driverAddressDto.getAreaId()));
        driverAddress.setDriverMaster(new DriverMaster(driverAddressDto.getDriverId()));
        
        return driverAddress;
    }
    
    public static List<DriverAddressDto> transformToDriverAddressDtoList(Set<DriverAddress> driverAddresses){
        if(driverAddresses == null){
            return null;
        }
        List<DriverAddressDto> driverAddressDtos = new ArrayList<DriverAddressDto>();
        for(DriverAddress driverAddress : driverAddresses){
            driverAddressDtos.add(transformToDriverAddressDto(driverAddress));
        }
        
        return driverAddressDtos;
    }
    
    public static DriverAddressDto transformToDriverAddressDto(DriverAddress driverAddress){
        if(driverAddress == null){
            return null;
        }
        
        DriverAddressDto driverAddressDto = new DriverAddressDto();
        driverAddressDto.setDriverAddressId(driverAddress.getDriverAddressId());
        driverAddressDto.setAddressType(driverAddress.getAddressTypeMaster().getAddressTypeId());
        driverAddressDto.setAddress(driverAddress.getAddress());
        driverAddressDto.setLandmark(driverAddress.getLandmark());
        driverAddressDto.setAreaId(driverAddress.getAreaMaster().getAreaId());
        driverAddressDto.setDriverId(driverAddress.getDriverMaster().getDriverId());
        
        return driverAddressDto;
    }
}