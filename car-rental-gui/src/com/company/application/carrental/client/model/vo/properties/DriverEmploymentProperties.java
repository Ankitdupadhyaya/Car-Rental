package com.company.application.carrental.client.model.vo.properties;

import java.util.Date;

import com.company.application.carrental.client.model.vo.DriverEmploymentModelDto;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface DriverEmploymentProperties extends PropertyAccess<DriverEmploymentModelDto> {

	@Path("id")
	ModelKeyProvider<DriverEmploymentModelDto> key();

	@Path("name")
	LabelProvider<DriverEmploymentModelDto> nameLabel();

	ValueProvider<DriverEmploymentModelDto, String> employmentType();

	ValueProvider<DriverEmploymentModelDto, Date> beginDate();

	ValueProvider<DriverEmploymentModelDto, Date> endDate();

	ValueProvider<DriverEmploymentModelDto, String> employerName();

	ValueProvider<DriverEmploymentModelDto, String> companyName();

	ValueProvider<DriverEmploymentModelDto, String> employerAddress();

	ValueProvider<DriverEmploymentModelDto, String> employerContactNo();

	ValueProvider<DriverEmploymentModelDto, String> reasonForLeaving();

	ValueProvider<DriverEmploymentModelDto, Double> salary();

	ValueProvider<DriverEmploymentModelDto, Character> referenceAllowed();
}