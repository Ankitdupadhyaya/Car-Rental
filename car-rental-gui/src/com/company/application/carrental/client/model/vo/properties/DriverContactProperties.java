package com.company.application.carrental.client.model.vo.properties;

import com.company.application.carrental.client.model.vo.DriverContact;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface DriverContactProperties extends PropertyAccess<DriverContact> {

	@Path("id")
	ModelKeyProvider<DriverContact> key();

	@Path("name")
	LabelProvider<DriverContact> nameLabel();

	ValueProvider<DriverContact, String> contactType();

	ValueProvider<DriverContact, String> contactNumber();

	ValueProvider<DriverContact, Boolean> isPrimary();
}