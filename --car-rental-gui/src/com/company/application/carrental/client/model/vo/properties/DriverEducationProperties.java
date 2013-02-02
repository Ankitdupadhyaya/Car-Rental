package com.company.application.carrental.client.model.vo.properties;

import com.company.application.carrental.client.model.vo.DriverEducation;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface DriverEducationProperties extends PropertyAccess<DriverEducation> {

	@Path("id")
	ModelKeyProvider<DriverEducation> key();

	@Path("name")
	LabelProvider<DriverEducation> nameLabel();

	ValueProvider<DriverEducation, String> educationType();

	ValueProvider<DriverEducation, String> yearofPassing();

	ValueProvider<DriverEducation, String> university();

	ValueProvider<DriverEducation, String> school_college();

	ValueProvider<DriverEducation, String> remarks();
}