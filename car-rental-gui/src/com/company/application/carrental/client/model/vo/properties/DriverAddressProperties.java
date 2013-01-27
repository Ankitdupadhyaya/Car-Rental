package com.company.application.carrental.client.model.vo.properties;

import com.company.application.carrental.client.model.vo.DriverAddress;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface DriverAddressProperties extends PropertyAccess<DriverAddress> {

	@Path("id")
	ModelKeyProvider<DriverAddress> key();

	@Path("name")
	LabelProvider<DriverAddress> nameLabel();

	ValueProvider<DriverAddress, String> addressType();

	ValueProvider<DriverAddress, String> address();

	ValueProvider<DriverAddress, String> landmark();
}