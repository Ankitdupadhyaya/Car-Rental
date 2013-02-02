package com.company.application.carrental.server.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.company.application.carrental.client.model.vo.GenericResultModelDto;
import com.company.application.carrental.client.model.vo.HelpListInputDto;
import com.company.application.carrental.client.model.vo.HelpListOutputModelDto;
import com.company.application.carrental.client.model.vo.MasterDataVO;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SaveDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SaveDriverBackgroundCheckOutput;
import com.company.application.carrental.client.model.vo.SearchDriverApplicationInput;
import com.company.application.carrental.client.model.vo.SearchDriverApplicationOutput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckInput;
import com.company.application.carrental.client.model.vo.SearchDriverBackgroundCheckOutput;
import com.company.application.carrental.client.service.interfaces.CarRentalService;
import com.company.application.carrental.server.transformUtil.DriverAddressClientTransformUtil;
import com.company.application.carrental.server.transformUtil.DriverContactClientTransformUtil;
import com.company.application.carrental.server.transformUtil.DriverEducationClientTransformUtil;
import com.company.application.carrental.server.transformUtil.DriverEmploymentClientTransformUtil;
import com.company.application.carrental.server.transformUtil.DriverMasterClientTransformUtil;
import com.company.carrental.services.api.service.DriverService;
import com.company.carrental.services.api.service.generic.CarRentalServiceFactory;
import com.company.carrental.services.core.dto.SaveDriverApplicationInputDto;
import com.company.carrental.services.core.dto.SaveDriverApplicationOutputDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundInputDto;
import com.company.carrental.services.core.dto.SaveDriverBackgroundOutputDto;
import com.company.carrental.services.core.dto.SearchDriverApplicationInputDto;
import com.company.carrental.services.core.dto.SearchDriverApplicationOutputDto;
import com.company.carrental.services.core.dto.SearchDriverBackgroundCheckInputDto;
import com.company.carrental.services.core.dto.SearchDriverBackgroundCheckOutputDto;
import com.company.customrequest.services.api.service.generic.CustomRequestServiceFactory;
import com.company.customrequest.services.core.dto.GenericResultDto;
import com.company.customrequest.services.core.dto.HelpListInputServiceDto;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CarRentalServiceImpl extends RemoteServiceServlet implements
		CarRentalService {

	private static final long serialVersionUID = 7030418212489596688L;
	private static final Logger LOG = Logger
			.getLogger(CarRentalServiceImpl.class);
	private DriverService driverService = (DriverService) CarRentalServiceFactory
			.getDriverService();

	public MasterDataVO getMasterData() throws Throwable {
		MasterDataVO masterDataVO = new MasterDataVO();

		return masterDataVO;
	}

	public SaveDriverApplicationOutput saveDriverApplication(
			SaveDriverApplicationInput input) {
		SaveDriverApplicationOutput output = new SaveDriverApplicationOutput();

		SaveDriverApplicationInputDto inputDto = new SaveDriverApplicationInputDto();
		inputDto.setDriverMasterDto(DriverMasterClientTransformUtil
				.transformToDriverMasterDto(input.getDriverMasterClientDto()));

		SaveDriverApplicationOutputDto outputDto = driverService
				.saveDriverApplication(inputDto);

		output.setDriverMasterClientDto(DriverMasterClientTransformUtil
				.transformToDriverMasterClientDto(outputDto
						.getDriverMasterDto()));
		return output;
	}

	public SaveDriverBackgroundCheckOutput saveDriverBackgroundCheck(
			SaveDriverBackgroundCheckInput input) {
		SaveDriverBackgroundCheckOutput output = new SaveDriverBackgroundCheckOutput();

		SaveDriverBackgroundInputDto saveDriverBackgroundInputDto = new SaveDriverBackgroundInputDto();
		saveDriverBackgroundInputDto
				.setDriverContactDtos(DriverContactClientTransformUtil
						.transformToDriverContactDtoList(input
								.getDriverContactList()));
		saveDriverBackgroundInputDto
				.setDriverAddressDtos(DriverAddressClientTransformUtil
						.transformToDriverAddressDtoList(input
								.getDriverAddressList()));
		saveDriverBackgroundInputDto
				.setDriverEducationDtos(DriverEducationClientTransformUtil
						.transformToDriverEducationDtoList(input
								.getDriverEducationList()));
		saveDriverBackgroundInputDto
				.setDriverEmploymentDtos(DriverEmploymentClientTransformUtil
						.transformToDriverEmploymentDtoList(input
								.getDriverEmploymentList()));

		SaveDriverBackgroundOutputDto outputDto = driverService
				.saveDriverBackGround(saveDriverBackgroundInputDto);

		output.setDriverContactModelDtos(DriverContactClientTransformUtil
				.transformToDriverContactModelDtoList(outputDto
						.getDriverContactDtos()));
		output.setDriverAddressModelDtos(DriverAddressClientTransformUtil
				.transformToDriverAddressModelDtoList(outputDto
						.getDriverAddressDtos()));
		output.setDriverEducationModelDtos(DriverEducationClientTransformUtil
				.transformToDriverEducationModelDtoList(outputDto
						.getDriverEducationDtos()));
		output.setDriverEmploymentModelDtos(DriverEmploymentClientTransformUtil
				.transformToDriverEmploymentModelDtoList(outputDto
						.getDriverEmploymentDtos()));

		return output;
	}

	public SearchDriverApplicationOutput searchDriverApplication(
			SearchDriverApplicationInput input) {
		SearchDriverApplicationOutput output = new SearchDriverApplicationOutput();

		SearchDriverApplicationInputDto inputDto = new SearchDriverApplicationInputDto();
		inputDto.setDriverId(input.getDriverId());

		SearchDriverApplicationOutputDto outputDto = driverService
				.searchDriverApplication(inputDto);

		output.setDriverMasterClientDto(DriverMasterClientTransformUtil
				.transformToDriverMasterClientDto(outputDto
						.getDriverMasterDto()));
		return output;
	}

	public SearchDriverBackgroundCheckOutput searchDriverBackground(
			SearchDriverBackgroundCheckInput input) {
		SearchDriverBackgroundCheckOutput output = new SearchDriverBackgroundCheckOutput();

		SearchDriverBackgroundCheckInputDto inputDto = new SearchDriverBackgroundCheckInputDto();
		inputDto.setDriverId(input.getDriverId());

		SearchDriverBackgroundCheckOutputDto outputDto = driverService
				.searchDriverBackgroundCheck(inputDto);

		output.setDriverId(input.getDriverId());
		output.setDriverContactModelDtos(DriverContactClientTransformUtil
				.transformToDriverContactModelDtoList(outputDto
						.getDriverContactDtos()));
		output.setDriverAddressModelDtos(DriverAddressClientTransformUtil
				.transformToDriverAddressModelDtoList(outputDto
						.getDriverAddressDtos()));
		output.setDriverEducationModelDtos(DriverEducationClientTransformUtil
				.transformToDriverEducationModelDtoList(outputDto
						.getDriverEducationDtos()));
		output.setDriverEmploymentModelDtos(DriverEmploymentClientTransformUtil
				.transformToDriverEmploymentModelDtoList(outputDto
						.getDriverEmploymentDtos()));

		return output;
	}

	public List<GenericResultModelDto> getGenericResult(String database,
			String tableName, String prefixField, String value, int maxResult)
			throws Throwable {
		List<GenericResultModelDto> results = new ArrayList<GenericResultModelDto>();
		// List<GenericResultDto> genericDtos =
		// ServiceAccessProxy.getInstance().getCustomRequestService().getGenericResult(database,
		// tableName,
		// prefixField, value, maxResult);
		List<GenericResultDto> genericDtos = CustomRequestServiceFactory
				.getCustomRequestService().getGenericResult(database,
						tableName, prefixField, value, maxResult);

		for (GenericResultDto genericDto : genericDtos) {
			GenericResultModelDto genericModel = new GenericResultModelDto(
					tableName);
			genericModel.setId(genericDto.getId());
			genericModel.setShortName(genericDto.getShortName());
			genericModel.setName(genericDto.getName());
			genericModel.setPrefixColumnName(genericDto.getPrefixName());
			results.add(genericModel);
		}

		return results;
	}

	public List<HelpListOutputModelDto> getCustomGenericResult(
			HelpListInputDto helpListInputDto) throws Throwable {
		List<HelpListOutputModelDto> results = new ArrayList<HelpListOutputModelDto>();
		HelpListInputServiceDto serviceDto = transformToHelpListServiceDto(helpListInputDto);
		List genericDtos = CustomRequestServiceFactory
				.getCustomRequestService().getCustomGenericResult(serviceDto);

		for (int count = 0; count < genericDtos.size(); count++) {
			HelpListOutputModelDto helpListOutputModelDto = new HelpListOutputModelDto();
			helpListOutputModelDto.set(helpListInputDto.getInputColumn(),
					helpListInputDto.getValue());

			if (genericDtos.get(count) instanceof Object[]) {
				Object[] genericDto = (Object[]) genericDtos.get(count);
				for (int loop = 0; loop < genericDto.length; loop++) {
					helpListOutputModelDto.set(serviceDto.getOutputColumns()
							.get(loop), genericDto[loop]);
				}

			} else if (genericDtos.get(count) instanceof String) {
				String genericDto = (String) genericDtos.get(count);
				helpListOutputModelDto.set(
						serviceDto.getOutputColumns().get(0), genericDto);
			}

			results.add(helpListOutputModelDto);
		}

		return results;
	}

	public static HelpListInputServiceDto transformToHelpListServiceDto(
			HelpListInputDto helpListInputDto) {

		HelpListInputServiceDto helpListInputServiceDto = new HelpListInputServiceDto();
		helpListInputServiceDto.setDatabase(helpListInputDto.getDatabase());
		helpListInputServiceDto.setInputColumn(helpListInputDto
				.getInputColumn());
		helpListInputServiceDto.setMaxResult(helpListInputDto.getMaxResult());
		helpListInputServiceDto.setOutputColumns(helpListInputDto
				.getOutputColumns());
		helpListInputServiceDto.setTableName(helpListInputDto.getTableName());
		helpListInputServiceDto.setValue(helpListInputDto.getValue());

		return helpListInputServiceDto;

	}
}