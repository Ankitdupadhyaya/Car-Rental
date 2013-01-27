package com.company.application.carrental.server.transformUtil;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverContactModelDto;
import com.company.carrental.services.core.dto.DriverContactDto;


public class DriverContactClientTransformUtil{
 

    public static List<DriverContactModelDto> transformToDriverContactClientList(List<DriverContactDto> driverContactDtos){
        if(driverContactDtos == null){
            return null;
        }
        
        List<DriverContactModelDto> driverContactModelDtos = new ArrayList<DriverContactModelDto>();
        
        for(DriverContactDto driverContactDto : driverContactDtos){
            driverContactModelDtos.add(transformToDriverContactModelDto(driverContactDto));
        }
        return driverContactModelDtos;
    }
    
    public static DriverContactModelDto transformToDriverContactModelDto(DriverContactDto driverContactDto){
       if(driverContactDto == null){
           return null;
       }
     
       DriverContactModelDto driverContactModelDto = new DriverContactModelDto();
       driverContactModelDto.setDriverContactId(driverContactDto.getDriverContactId());
       driverContactModelDto.setContactType(String.valueOf(driverContactDto.getContactType()));
       driverContactModelDto.setContactNumber(driverContactDto.getContactNumber());
       driverContactModelDto.setIsPrimary(driverContactDto.getIsPrimary());
       driverContactModelDto.setDriverId(driverContactDto.getDriverId());
       
       return driverContactModelDto;
    }
    
    public static List<DriverContactDto> transformToDriverContactDtoList(List<DriverContactModelDto> driverContactModelDtos){
        if(driverContactModelDtos == null){
            return null;
        }
        
        List<DriverContactDto> driverContactDtos = new ArrayList<DriverContactDto>();
        
        for(DriverContactModelDto driverContactModelDto : driverContactModelDtos){
            driverContactDtos.add(transformToDriverContactDto(driverContactModelDto));
        }
        return driverContactDtos;
    }
    
    public static DriverContactDto transformToDriverContactDto(DriverContactModelDto driverContactModelDto){
       if(driverContactModelDto == null){
           return null;
       }
     
       DriverContactDto driverContactDto = new DriverContactDto();
       driverContactDto.setDriverContactId(driverContactModelDto.getDriverContactId());
       driverContactDto.setContactType(Integer.valueOf(driverContactModelDto.getContactType()));
       driverContactDto.setContactNumber(driverContactModelDto.getContactNumber());
       driverContactDto.setIsPrimary(driverContactModelDto.getIsPrimary());
       driverContactDto.setDriverId(driverContactModelDto.getDriverId());
       
       return driverContactDto;
    }
    
}