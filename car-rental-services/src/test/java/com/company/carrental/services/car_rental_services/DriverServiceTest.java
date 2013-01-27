package com.company.carrental.services.car_rental_services;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.company.carrental.services.api.service.generic.CarRentalServiceFactory;
import com.company.carrental.services.core.dto.DriverAddressDto;
import com.company.carrental.services.core.dto.DriverContactDto;
import com.company.carrental.services.core.dto.DriverEducationDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundInputDto;
import com.company.carrental.services.test.generic.GenericTest;

/**
 * @author Vijay
 * 
 */
public class DriverServiceTest extends GenericTest {

    /**
     * Constructor
     */
    public DriverServiceTest() {
        super();
    }

//    public void testGetAllDrivers() {
//
//        List<DriverMaster> dms = CarRentalServiceFactory.getDriverService().getAllDrivers();
//
//        for(DriverMaster dm : dms){
//        System.out.println(dm.getDriverFullName());
//        }
//
//    }
    
//    public void testGetDriver() {
//
//        DriverMaster dm = CarRentalServiceFactory.getDriverService().getDriver(1);
//
//        System.out.println(dm.getDriverFullName());
//
//    }
    
    public void testSave(){
        
        DriverContactDto driverContactDto = new DriverContactDto();
        driverContactDto.setDriverId(10);
        driverContactDto.setContactNumber("982121213");
        driverContactDto.setContactType(1);
        driverContactDto.setIsPrimary(false);
        
        List<DriverContactDto> driverContactDtos = new ArrayList<DriverContactDto>();
        driverContactDtos.add(driverContactDto);
        
        DriverAddressDto driverAddressDto = new DriverAddressDto();
        driverAddressDto.setAddress("Mulund-w,mumbai-400081");
        driverAddressDto.setDriverId(2);
        driverAddressDto.setAddressType(1);
        driverAddressDto.setAreaId(1);
        
        List<DriverAddressDto> driverAddressDtos = new ArrayList<DriverAddressDto>();
        driverAddressDtos.add(driverAddressDto);
        
        DriverEducationDto educationDto = new DriverEducationDto();
        educationDto.setDriverId(1);
        educationDto.setEducationType("HSC");
        educationDto.setRemarks("Test");
        educationDto.setSchoolOrCollege("School");
        educationDto.setUniversity("University");
        educationDto.setYearOfPassing(2012);
        
        List<DriverEducationDto> driverEducationDtos = new ArrayList<DriverEducationDto>();
        driverEducationDtos.add(educationDto);
        
        SaveDriverBackgroundInputDto input = new SaveDriverBackgroundInputDto();
        input.setDriverContactDtos(driverContactDtos);
        input.setDriverAddressDtos(driverAddressDtos);
        input.setDriverEducationDtos(driverEducationDtos);
        
        CarRentalServiceFactory.getDriverService().saveDriverBackGround(input);
//        CarRentalServiceFactory.getDriverService().saveDriverApplication(dm);
    }

    /**
     * @return Test
     */
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(DriverServiceTest.class);
        return suite;
    }
}