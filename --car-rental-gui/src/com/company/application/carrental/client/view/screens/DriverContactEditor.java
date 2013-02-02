package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.model.vo.DriverContact;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DriverContactEditor implements IsWidget, Editor<DriverContact> {

	private FormPanel panel;
	private VerticalLayoutContainer container;

	TextField contactType;
	TextField contactNumber;
	Radio isPrimary;

	private TextButton save;

	public DriverContactEditor() {
		panel = new FormPanel();
		panel.setLabelWidth(50);

		container = new VerticalLayoutContainer();
		panel.setWidget(container);

		contactType = new TextField();
		// contactType.setEnabled(false);
		contactNumber = new TextField();
		// contactNumber.setEnabled(false);
		isPrimary = new Radio();

		container.add(new FieldLabel(contactType, "Contact Type"), new VerticalLayoutData(.5, -1));
		container.add(new FieldLabel(contactNumber, "Contact Number"), new VerticalLayoutData(1, -1));
		container.add(new FieldLabel(isPrimary, "Primary"), new VerticalLayoutData(1, -1));

		save = new TextButton("Save");
		save.setEnabled(false);
		// container.add(save);
	}

	public void setSaveEnabled(boolean enabled) {
		save.setEnabled(enabled);
		contactType.setEnabled(enabled);
		contactNumber.setEnabled(enabled);
		if (!enabled) {

			contactType.setValue("");
			contactNumber.setValue("");
		}
	}

	public HasSelectHandlers getSaveButton() {
		return save;
	}

	public Widget asWidget() {
		return panel;
	}

	public FormPanel getPanel() {
		return panel;
	}

	public void setPanel(FormPanel panel) {
		this.panel = panel;
	}
}