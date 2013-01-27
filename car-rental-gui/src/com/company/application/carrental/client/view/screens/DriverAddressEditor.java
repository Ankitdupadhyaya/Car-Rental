package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.model.vo.DriverAddress;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DriverAddressEditor implements IsWidget, Editor<DriverAddress> {

	private FormPanel panel;
	private VerticalLayoutContainer container;

	TextField addressType;
	TextArea address;
	TextField landmark;

	private TextButton save;

	public DriverAddressEditor() {
		panel = new FormPanel();
		panel.setLabelWidth(60);

		container = new VerticalLayoutContainer();
		panel.setWidget(container);

		addressType = new TextField();
		// contactType.setEnabled(false);
		address = new TextArea();
		// contactNumber.setEnabled(false);
		landmark = new TextField();

		container.add(new FieldLabel(addressType, "Address Type"), new VerticalLayoutData(.5, -1));
		container.add(new FieldLabel(address, "Address"), new VerticalLayoutData(1, -1));
		container.add(new FieldLabel(landmark, "Landmark"), new VerticalLayoutData(1, -1));

		save = new TextButton("Save");
		save.setEnabled(false);
		// container.add(save);
	}

	public void setSaveEnabled(boolean enabled) {
		save.setEnabled(enabled);
		addressType.setEnabled(enabled);
		address.setEnabled(enabled);
		if (!enabled) {

			addressType.setValue("");
			address.setValue("");
		}
	}

	public HasSelectHandlers getSaveButton() {
		return save;
	}

	public Widget asWidget() {
		return panel;
	}
}