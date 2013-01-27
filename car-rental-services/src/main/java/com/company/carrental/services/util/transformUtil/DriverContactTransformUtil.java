package com.company.carrental.services.util.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.carrental.data.pojo.ContactTypeMaster;
import com.company.carrental.data.pojo.DriverContact;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverContactDto;



public class DriverContactTransformUtil{
    
    
    public static Set<DriverContact> transformToDriverContactSet(List<DriverContactDto> driverContactDtos){
        if(driverContactDtos == null){
            return null;
        }
        
        Set<DriverContact> driverContacts = new HashSet<DriverContact>();
        
        for(DriverContactDto driverContactDto : driverContactDtos){
            driverContacts.add(transformToDriverContact(driverContactDto));
        }
        return driverContacts;
    }
    
    public static DriverContact transformToDriverContact(DriverContactDto driverContactDto){
       if(driverContactDto == null){
           return null;
       }
     
       DriverContact driverContact = new DriverContact();
       driverContact.setDriverContactId(driverContactDto.getDriverContactId());
       driverContact.setContactNumber(driverContactDto.getContactNumber());
       driverContact.setIsPrimary(driverContactDto.getIsPrimary());
       driverContact.setContactTypeMaster(new ContactTypeMaster(driverContactDto.getContactType()));
       driverContact.setDriverMaster(new DriverMaster(driverContactDto.getDriverId()));
       
       return driverContact;
    }
    
    public static List<DriverContactDto> transformToDriverContactDtoList(Set<DriverContact> driverContacts){
        if(driverContacts == null){
            return null;
        }
        
        List<DriverContactDto> driverContactDtos = new ArrayList<DriverContactDto>();
        
        for(DriverContact driverContact : driverContacts){
            driverContactDtos.add(transformToDriverContactDto(driverContact));
        }
        return driverContactDtos;
    }
    
    public static DriverContactDto transformToDriverContactDto(DriverContact driverContact){
       if(driverContact == null){
           return null;
       }
     
       DriverContactDto driverContactDto = new DriverContactDto();
       driverContactDto.setDriverContactId(driverContact.getDriverContactId());
       driverContactDto.setContactNumber(driverContact.getContactNumber());
       driverContactDto.setIsPrimary(driverContact.getIsPrimary());
       driverContactDto.setContactType(driverContact.getContactTypeMaster().getContactTypeId());
       driverContactDto.setDriverId(driverContact.getDriverMaster().getDriverId());
       
       return driverContactDto;
    }
 
}