package com.company.carrental.services.core.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.company.carrental.data.api.dao.DriverAddressDao;
import com.company.carrental.data.api.dao.DriverBackgroundCheckDao;
import com.company.carrental.data.api.dao.DriverContactDao;
import com.company.carrental.data.api.dao.DriverEducationDao;
import com.company.carrental.data.api.dao.DriverEmploymentDao;
import com.company.carrental.data.api.dao.DriverMasterDao;
import com.company.carrental.data.pojo.DriverAddress;
import com.company.carrental.data.pojo.DriverContact;
import com.company.carrental.data.pojo.DriverEducation;
import com.company.carrental.data.pojo.DriverEmployment;
import com.company.carrental.data.pojo.DriverMaster;
import com.company.carrental.services.api.service.DriverService;
import com.company.carrental.services.core.dto.DriverMasterDto;
import com.company.carrental.services.core.dto.SaveDriverApplicationInputDto;
import com.company.carrental.services.core.dto.SaveDriverApplicationOutputDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundInputDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundOutputDto;
import com.company.carrental.services.core.dto.SearchDriverApplicationInputDto;
import com.company.carrental.services.core.dto.SearchDriverApplicationOutputDto;
import com.company.carrental.services.core.dto.SearchDriverBackgroundCheckInputDto;
import com.company.carrental.services.core.dto.SearchDriverBackgroundCheckOutputDto;
import com.company.carrental.services.util.transformUtil.DriverAddressTransformUtil;
import com.company.carrental.services.util.transformUtil.DriverContactTransformUtil;
import com.company.carrental.services.util.transformUtil.DriverEducationTransformUtil;
import com.company.carrental.services.util.transformUtil.DriverEmploymentTransformUtil;
import com.company.carrental.services.util.transformUtil.DriverMasterTransformUtil;

public class DriverServiceImpl implements DriverService {

	private DriverMasterDao driverMasterDao;
	private DriverContactDao driverContactDao;
	private DriverAddressDao driverAddressDao;
	private DriverEducationDao driverEducationDao;
	private DriverEmploymentDao driverEmploymentDao;
	private DriverBackgroundCheckDao driverBackgroundCheckDao;

	public List<DriverMaster> getAllDrivers() {
		return driverMasterDao.getAll();
	}

	public DriverMaster getDriver(Integer driverId) {
		DriverMaster dm = driverMasterDao.get(driverId);
		for (DriverContact dC : dm.getDriverContacts()) {
			System.out.println(dC.getContactNumber());
		}

		return dm;
	}

	public SaveDriverApplicationOutputDto saveDriverApplication(
			SaveDriverApplicationInputDto saveDriverApplicationInputDto) {

		SaveDriverApplicationOutputDto saveDriverApplicationOutputDto = null;

		DriverMaster driverMaster = driverMasterDao
				.save(DriverMasterTransformUtil
						.transformToDriverMaster(saveDriverApplicationInputDto
								.getDriverMasterDto()));

		if (driverMaster != null) {
			saveDriverApplicationOutputDto = new SaveDriverApplicationOutputDto();
			saveDriverApplicationOutputDto
					.setDriverMasterDto(DriverMasterTransformUtil
							.transformToDriverMasterDto(driverMaster));
		}

		return saveDriverApplicationOutputDto;
	}

	public SaveDriverBackgroundOutputDto saveDriverBackGround(
			SaveDriverBackgroundInputDto saveDriverBackgroundInputDto) {

		SaveDriverBackgroundOutputDto saveDriverBackgroundOutputDto = new SaveDriverBackgroundOutputDto();

		Set<DriverContact> driverContacts = DriverContactTransformUtil
				.transformToDriverContactSet(saveDriverBackgroundInputDto
						.getDriverContactDtos());
		Set<DriverAddress> driverAddresses = DriverAddressTransformUtil
				.transformToDriverAddressSet(saveDriverBackgroundInputDto
						.getDriverAddressDtos());
		Set<DriverEducation> driverEducations = DriverEducationTransformUtil
				.transformToDriverEducationSet(saveDriverBackgroundInputDto
						.getDriverEducationDtos());
		Set<DriverEmployment> driverEmployments = DriverEmploymentTransformUtil
				.transformToDriverEmploymentSet(saveDriverBackgroundInputDto
						.getDriverEmploymentDtos());

		Set<DriverContact> savedContacts = new HashSet<DriverContact>();
		Set<DriverAddress> savedAddresses = new HashSet<DriverAddress>();
		Set<DriverEducation> savedEducation = new HashSet<DriverEducation>();
		Set<DriverEmployment> savedEmployments = new HashSet<DriverEmployment>();

		for (DriverContact driverContact : driverContacts) {
			savedContacts.add(driverContactDao.save(driverContact));
		}
		if(driverAddresses!=null)
		for (DriverAddress driverAddress : driverAddresses) {
			savedAddresses.add(driverAddressDao.save(driverAddress));
		}
		if (driverEducations != null) {
			for (DriverEducation driverEducation : driverEducations) {
				savedEducation.add(driverEducationDao.save(driverEducation));
			}
		}
		if (driverEmployments != null) {
			for (DriverEmployment driverEmployment : driverEmployments) {
				savedEmployments
						.add(driverEmploymentDao.save(driverEmployment));
			}
		}

		saveDriverBackgroundOutputDto
				.setDriverContactDtos(DriverContactTransformUtil
						.transformToDriverContactDtoList(savedContacts));
		saveDriverBackgroundOutputDto
				.setDriverAddressDtos(DriverAddressTransformUtil
						.transformToDriverAddressDtoList(savedAddresses));
		saveDriverBackgroundOutputDto
				.setDriverEducationDtos(DriverEducationTransformUtil
						.transformToDriverEducationDtoList(savedEducation));
		saveDriverBackgroundOutputDto
				.setDriverEmploymentDtos(DriverEmploymentTransformUtil
						.transformToDriverEmploymentDtoList(savedEmployments));

		return saveDriverBackgroundOutputDto;

	}

	public SearchDriverApplicationOutputDto searchDriverApplication(
			SearchDriverApplicationInputDto searchDriverApplicationInputDto) {

		SearchDriverApplicationOutputDto outputDto = new SearchDriverApplicationOutputDto();
		DriverMasterDto masterDto = DriverMasterTransformUtil
				.transformToDriverMasterDto(driverMasterDao
						.get(searchDriverApplicationInputDto.getDriverId()));
		outputDto.setDriverMasterDto(masterDto);

		return outputDto;
	}

	public SearchDriverBackgroundCheckOutputDto searchDriverBackgroundCheck(
			SearchDriverBackgroundCheckInputDto driverBackgroundCheckInputDto) {

		SearchDriverBackgroundCheckOutputDto outputDto = new SearchDriverBackgroundCheckOutputDto();

		List<DriverContact> contacts = driverContactDao
				.searchDriverContacts(driverBackgroundCheckInputDto
						.getDriverId());
		List<DriverAddress> addresses = driverAddressDao
				.searchDriverAdddresses(driverBackgroundCheckInputDto
						.getDriverId());
		List<DriverEducation> educations = driverEducationDao
				.searchDriverEducation(driverBackgroundCheckInputDto
						.getDriverId());
		List<DriverEmployment> employments = driverEmploymentDao
				.searchDriverEmployment(driverBackgroundCheckInputDto
						.getDriverId());

		outputDto.setDriverContactDtos(DriverContactTransformUtil
				.transformToDriverContactDtoList(new HashSet<DriverContact>(
						contacts)));
		outputDto.setDriverAddressDtos(DriverAddressTransformUtil
				.transformToDriverAddressDtoList(new HashSet<DriverAddress>(
						addresses)));
		outputDto
				.setDriverEducationDtos(DriverEducationTransformUtil
						.transformToDriverEducationDtoList(new HashSet<DriverEducation>(
								educations)));
		outputDto
				.setDriverEmploymentDtos(DriverEmploymentTransformUtil
						.transformToDriverEmploymentDtoList(new HashSet<DriverEmployment>(
								employments)));

		return outputDto;
	}

	public DriverMasterDao getDriverMasterDao() {
		return driverMasterDao;
	}

	public void setDriverMasterDao(DriverMasterDao driverMasterDao) {
		this.driverMasterDao = driverMasterDao;
	}

	public DriverContactDao getDriverContactDao() {
		return driverContactDao;
	}

	public void setDriverContactDao(DriverContactDao driverContactDao) {
		this.driverContactDao = driverContactDao;
	}

	public DriverAddressDao getDriverAddressDao() {
		return driverAddressDao;
	}

	public void setDriverAddressDao(DriverAddressDao driverAddressDao) {
		this.driverAddressDao = driverAddressDao;
	}

	public DriverEducationDao getDriverEducationDao() {
		return driverEducationDao;
	}

	public void setDriverEducationDao(DriverEducationDao driverEducationDao) {
		this.driverEducationDao = driverEducationDao;
	}

	public DriverEmploymentDao getDriverEmploymentDao() {
		return driverEmploymentDao;
	}

	public void setDriverEmploymentDao(DriverEmploymentDao driverEmploymentDao) {
		this.driverEmploymentDao = driverEmploymentDao;
	}

	public DriverBackgroundCheckDao getDriverBackgroundCheckDao() {
		return driverBackgroundCheckDao;
	}

	public void setDriverBackgroundCheckDao(
			DriverBackgroundCheckDao driverBackgroundCheckDao) {
		this.driverBackgroundCheckDao = driverBackgroundCheckDao;
	}

}