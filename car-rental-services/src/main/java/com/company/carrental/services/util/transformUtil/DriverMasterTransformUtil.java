package com.company.carrental.services.util.transformUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.carrental.data.pojo.AddressTypeMaster;
import com.company.carrental.data.pojo.AreaMaster;
import com.company.carrental.data.pojo.ContactTypeMaster;
import com.company.carrental.data.pojo.DriverAddress;
import com.company.carrental.data.pojo.DriverContact;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.ContactTypeMasterDto;
import com.company.carrental.services.core.dto.DriverAddressDto;
import com.company.carrental.services.core.dto.DriverContactDto;
import com.company.carrental.services.core.dto.DriverMasterDto;
import com.sun.org.apache.bcel.internal.generic.DADD;


public class DriverMasterTransformUtil{
 

    public static List<DriverMasterDto> transformToDriverMasterDtoList(List<DriverMaster> driverMasterList){
        List<DriverMasterDto> driverMasterDtoList = new ArrayList<DriverMasterDto>();
        for(DriverMaster driverMaster : driverMasterList){
            driverMasterDtoList.add(transformToDriverMasterDto(driverMaster));
        }
        
        return driverMasterDtoList;
        
    }
       
    public static DriverMasterDto transformToDriverMasterDto(DriverMaster driverMaster){        
        if(driverMaster == null){
            return null;
        }
        
        DriverMasterDto driverMasterDto = new DriverMasterDto();
        driverMasterDto.setDriverId(driverMaster.getDriverId());
        driverMasterDto.setDriverFullName(driverMaster.getDriverFullName());
        driverMasterDto.setGender(driverMaster.getGender());
        driverMasterDto.setDob(driverMaster.getDob());
        driverMasterDto.setTotalExperience(driverMaster.getTotalExperience());
        driverMasterDto.setPrimaryContactNumber(driverMaster.getPrimaryContactNumber());
        driverMasterDto.setCurrentAreaId(driverMaster.getCurrentAreaId());
        driverMasterDto.setLicenceNo(driverMaster.getLicenceNo());
        driverMasterDto.setLicenceType(driverMaster.getLicenceType());
        driverMasterDto.setLicenceExpiryDate(driverMaster.getLicenceExpiryDate());
//        driverMasterDto.setJobPrefIndividual(driverMaster.get);
        driverMasterDto.setCarTypeAutomatic(driverMaster.getCarTypeAutomatic());
        driverMasterDto.setCarTypeManual(driverMaster.getCarTypeManual());
        driverMasterDto.setRatingId(driverMaster.getRatingId());
        driverMasterDto.setReferenceName(driverMaster.getReferenceName());
        driverMasterDto.setReferenceNumber(driverMaster.getReferenceNumber());
        driverMasterDto.setMedicalHistory(driverMaster.getMedicalHistory());
        driverMasterDto.setAccidentHistory(driverMaster.getAccidentHistory());
        driverMasterDto.setDiabetes(driverMaster.getDiabetes());
        driverMasterDto.setEyeSight(driverMaster.getEyeSight());

        
        return driverMasterDto;
    }
    
    public static List<DriverMaster> transformToDriverMasterList(List<DriverMasterDto> driverMasterDtoList){
        List<DriverMaster> driverMasterList = new ArrayList<DriverMaster>();
        for(DriverMasterDto driverMasterDto : driverMasterDtoList){
            driverMasterList.add(transformToDriverMaster(driverMasterDto));
        }
        
        return driverMasterList;
        
    }
    
    public static DriverMaster transformToDriverMaster(DriverMasterDto driverMasterDto){        
        if(driverMasterDto == null){
            return null;
        }
        
        DriverMaster driverMaster = new DriverMaster();
        driverMaster.setDriverId(driverMasterDto.getDriverId());
        driverMaster.setDriverFullName(driverMasterDto.getDriverFullName());
        driverMaster.setGender(driverMasterDto.getGender());
        driverMaster.setDob(driverMasterDto.getDob());
        driverMaster.setTotalExperience(driverMasterDto.getTotalExperience());
        driverMaster.setPrimaryContactNumber(driverMasterDto.getPrimaryContactNumber());
        driverMaster.setCurrentAreaId(driverMasterDto.getCurrentAreaId());
        driverMaster.setLicenceNo(driverMasterDto.getLicenceNo());
        driverMaster.setLicenceType(driverMasterDto.getLicenceType());
        driverMaster.setLicenceExpiryDate(driverMasterDto.getLicenceExpiryDate());
//        driverMasterDto.setJobPrefIndividual(driverMaster.get);
        driverMaster.setCarTypeAutomatic(driverMasterDto.getCarTypeAutomatic());
        driverMaster.setCarTypeManual(driverMasterDto.getCarTypeManual());
        driverMaster.setRatingId(driverMasterDto.getRatingId());
        driverMaster.setReferenceName(driverMasterDto.getReferenceName());
        driverMaster.setReferenceNumber(driverMasterDto.getReferenceNumber());
        driverMaster.setMedicalHistory(driverMasterDto.getMedicalHistory());
        driverMaster.setAccidentHistory(driverMasterDto.getAccidentHistory());
        driverMaster.setDiabetes(driverMasterDto.getDiabetes());
        driverMaster.setEyeSight(driverMasterDto.getEyeSight());

        
        return driverMaster;
    }
    
}