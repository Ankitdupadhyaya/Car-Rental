package com.company.application.carrental.server.transformUtil;

import java.util.ArrayList;
import java.util.List;

import com.company.application.carrental.client.model.vo.DriverMasterClientDto;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.core.dto.DriverMasterDto;


public class DriverMasterClientTransformUtil{
 

    public static List<DriverMasterDto> transformToDriverMasterDtoList(List<DriverMaster> driverMasterList){
        List<DriverMasterDto> driverMasterDtoList = new ArrayList<DriverMasterDto>();
        for(DriverMaster driverMaster : driverMasterList){
//            driverMasterDtoList.add(transformToDriverMasterDto(driverMaster));
        }
        
        return driverMasterDtoList;
        
    }
       
    public static DriverMasterDto transformToDriverMasterDto(DriverMasterClientDto driverMasterClientDto){        
        if(driverMasterClientDto == null){
            return null;
        }
        
        DriverMasterDto driverMasterDto = new DriverMasterDto();
        driverMasterDto.setDriverId(driverMasterClientDto.getDriverId());
        driverMasterDto.setDriverFullName(driverMasterClientDto.getDriverFullName());
        driverMasterDto.setGender(driverMasterClientDto.getGender());
        driverMasterDto.setDob(driverMasterClientDto.getDob());
        driverMasterDto.setTotalExperience(driverMasterClientDto.getTotalExperience());
        driverMasterDto.setPrimaryContactNumber(driverMasterClientDto.getPrimaryContactNumber());
        driverMasterDto.setCurrentAreaId(driverMasterClientDto.getCurrentAreaId());
        driverMasterDto.setLicenceNo(driverMasterClientDto.getLicenceNo());
        driverMasterDto.setLicenceType(driverMasterClientDto.getLicenceType());
        driverMasterDto.setLicenceExpiryDate(driverMasterClientDto.getLicenceExpiryDate());
//        driverMasterDto.setJobPrefIndividual(driverMaster.get);
        driverMasterDto.setCarTypeAutomatic(driverMasterClientDto.getCarTypeAutomatic());
        driverMasterDto.setCarTypeManual(driverMasterClientDto.getCarTypeManual());
        driverMasterDto.setRatingId(driverMasterClientDto.getRatingId());
        driverMasterDto.setReferenceName(driverMasterClientDto.getReferenceName());
        driverMasterDto.setReferenceNumber(driverMasterClientDto.getReferenceNumber());
        driverMasterDto.setMedicalHistory(driverMasterClientDto.getMedicalHistory());
        driverMasterDto.setAccidentHistory(driverMasterClientDto.getAccidentHistory());
        driverMasterDto.setDiabetes(driverMasterClientDto.getDiabetes());
        driverMasterDto.setEyeSight(driverMasterClientDto.getEyeSight());

        
        return driverMasterDto;
    }
    
    public static List<DriverMasterClientDto> transformToDriverMasterClientDtoList(List<DriverMasterDto> driverMasterDtoList){
        List<DriverMasterClientDto> driverMasterClientDtos = new ArrayList<DriverMasterClientDto>();
        for(DriverMasterDto driverMasterDto : driverMasterDtoList){
            driverMasterClientDtos.add(transformToDriverMasterClientDto(driverMasterDto));
        }
        
        return driverMasterClientDtos;
        
    }
    
    public static DriverMasterClientDto transformToDriverMasterClientDto(DriverMasterDto driverMasterDto){        
        if(driverMasterDto == null){
            return null;
        }
        
        DriverMasterClientDto driverMasterClientDto = new DriverMasterClientDto();
        driverMasterClientDto.setDriverId(driverMasterDto.getDriverId());
        driverMasterClientDto.setDriverFullName(driverMasterDto.getDriverFullName());
        driverMasterClientDto.setGender(driverMasterDto.getGender());
        driverMasterClientDto.setDob(driverMasterDto.getDob());
        driverMasterClientDto.setTotalExperience(driverMasterDto.getTotalExperience());
        driverMasterClientDto.setPrimaryContactNumber(driverMasterDto.getPrimaryContactNumber());
        driverMasterClientDto.setCurrentAreaId(driverMasterDto.getCurrentAreaId());
        driverMasterClientDto.setLicenceNo(driverMasterDto.getLicenceNo());
        driverMasterClientDto.setLicenceType(driverMasterDto.getLicenceType());
        driverMasterClientDto.setLicenceExpiryDate(driverMasterDto.getLicenceExpiryDate());
//        driverMasterDto.setJobPrefIndividual(driverMaster.get);
        driverMasterClientDto.setCarTypeAutomatic(driverMasterDto.getCarTypeAutomatic());
        driverMasterClientDto.setCarTypeManual(driverMasterDto.getCarTypeManual());
        driverMasterClientDto.setRatingId(driverMasterDto.getRatingId());
        driverMasterClientDto.setReferenceName(driverMasterDto.getReferenceName());
        driverMasterClientDto.setReferenceNumber(driverMasterDto.getReferenceNumber());
        driverMasterClientDto.setMedicalHistory(driverMasterDto.getMedicalHistory());
        driverMasterClientDto.setAccidentHistory(driverMasterDto.getAccidentHistory());
        driverMasterClientDto.setDiabetes(driverMasterDto.getDiabetes());
        driverMasterClientDto.setEyeSight(driverMasterDto.getEyeSight());

        
        return driverMasterClientDto;
    }
    

}