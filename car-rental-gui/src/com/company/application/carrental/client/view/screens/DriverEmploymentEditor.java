package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.model.vo.DriverEmploymentModelDto;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DriverEmploymentEditor implements IsWidget, Editor<DriverEmploymentModelDto> {

	private FormPanel panel;
	private VerticalLayoutContainer container;

	private TextField employmentType;
	private DateField beginDate;
	private DateField endDate;
	private TextField employerName;
	private TextField companyName;
	private TextField employerAddress;
	private TextField employerContactNo;
	private TextField reasonForLeaving;
	private TextField salary;
	private CheckBox referenceAllowed;

	private TextButton save;

	public DriverEmploymentEditor() {
		panel = new FormPanel();
		panel.setLabelWidth(60);

		container = new VerticalLayoutContainer();
		panel.setWidget(container);

		employmentType = new TextField();
		beginDate = new DateField();
		endDate = new DateField();
		employerName = new TextField();
		companyName = new TextField();
		employerAddress = new TextField();
		employerContactNo = new TextField();
		reasonForLeaving = new TextField();
		salary = new TextField();
		referenceAllowed = new CheckBox();

		container.add(new FieldLabel(employmentType, "Employment Type"), new VerticalLayoutData(.5, -1));
		container.add(new FieldLabel(beginDate, "Begin Date"), new VerticalLayoutData(.2, -1));
		container.add(new FieldLabel(endDate, "End Date"), new VerticalLayoutData(.2, -1));
		container.add(new FieldLabel(employerName, "Employer Name"), new VerticalLayoutData(.7, -1));
		container.add(new FieldLabel(companyName, "Company Name"), new VerticalLayoutData(.7, -1));
		container.add(new FieldLabel(employerAddress, "Employer Address"), new VerticalLayoutData(1, -1));
		container.add(new FieldLabel(employerContactNo, "Employer Contact"), new VerticalLayoutData(.4, -1));
		container.add(new FieldLabel(reasonForLeaving, "Reason For Leaving"), new VerticalLayoutData(1, -1));
		container.add(new FieldLabel(salary, "Salary"), new VerticalLayoutData(.4, -1));
		container.add(new FieldLabel(referenceAllowed, "Reference Allowed"), new VerticalLayoutData(1, -1));

		save = new TextButton("Save");
		save.setEnabled(false);
		// container.add(save);
	}

	public void setSaveEnabled(boolean enabled) {
		save.setEnabled(enabled);
		employmentType.setEnabled(enabled);
		beginDate.setEnabled(enabled);
		if (!enabled) {

			employmentType.setValue("");
			// beginDate.setValue("");
		}
	}

	public HasSelectHandlers getSaveButton() {
		return save;
	}

	public Widget asWidget() {
		return panel;
	}
}