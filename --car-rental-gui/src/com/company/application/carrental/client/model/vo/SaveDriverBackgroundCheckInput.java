package com.company.application.carrental.client.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SaveDriverBackgroundCheckInput implements Serializable {

	private static final long serialVersionUID = 6224940718531677881L;

	private Integer driverId;
	private DriverBackgroundCheckClientDto driverBackgroundCheckModelDto;
	private List<DriverContactModelDto> driverContactList = new ArrayList<DriverContactModelDto>();
	private List<DriverAddressModelDto> driverAddressList = new ArrayList<DriverAddressModelDto>();
	private List<DriverEducationModelDto> driverEducationList = new ArrayList<DriverEducationModelDto>();
	private List<DriverEmploymentModelDto> driverEmploymentList = new ArrayList<DriverEmploymentModelDto>();

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public DriverBackgroundCheckClientDto getDriverBackgroundCheckModelDto() {
		return driverBackgroundCheckModelDto;
	}

	public void setDriverBackgroundCheckModelDto(DriverBackgroundCheckClientDto driverBackgroundCheckModelDto) {
		this.driverBackgroundCheckModelDto = driverBackgroundCheckModelDto;
	}

	public List<DriverContactModelDto> getDriverContactList() {
		return driverContactList;
	}

	public void setDriverContactList(List<DriverContactModelDto> driverContactList) {
		this.driverContactList = driverContactList;
	}

	public void addDriverContactList(List<DriverContactModelDto> driverContactList) {
		this.driverContactList.addAll(driverContactList);
	}

	public void addDriverContact(DriverContactModelDto driverContact) {
		this.driverContactList.add(driverContact);
	}

	public List<DriverAddressModelDto> getDriverAddressList() {
		return driverAddressList;
	}

	public void setDriverAddressList(List<DriverAddressModelDto> driverAddressList) {
		this.driverAddressList = driverAddressList;
	}

	public void addDriverAddressList(List<DriverAddressModelDto> driverAddressList) {
		this.driverAddressList.addAll(driverAddressList);
	}

	public void addDriverAddress(DriverAddressModelDto driverAddress) {
		this.driverAddressList.add(driverAddress);
	}

	public List<DriverEducationModelDto> getDriverEducationList() {
		return driverEducationList;
	}

	public void setDriverEducationList(List<DriverEducationModelDto> driverEducationList) {
		this.driverEducationList = driverEducationList;
	}

	public void addDriverEducationList(List<DriverEducationModelDto> driverEducationList) {
		this.driverEducationList.addAll(driverEducationList);
	}

	public void addDriverEducation(DriverEducationModelDto driverEducation) {
		this.driverEducationList.add(driverEducation);
	}

	public List<DriverEmploymentModelDto> getDriverEmploymentList() {
		return driverEmploymentList;
	}

	public void setDriverEmploymentList(List<DriverEmploymentModelDto> driverEmploymentList) {
		this.driverEmploymentList = driverEmploymentList;
	}

	public void addDriverEmploymentList(List<DriverEmploymentModelDto> driverEmploymentList) {
		this.driverEmploymentList.addAll(driverEmploymentList);
	}

	public void addDriverEmployment(DriverEmploymentModelDto driverEmployment) {
		this.driverEmploymentList.add(driverEmployment);
	}
}