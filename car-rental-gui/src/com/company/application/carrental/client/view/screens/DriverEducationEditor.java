package com.company.application.carrental.client.view.screens;

import com.company.application.carrental.client.model.vo.DriverEducation;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent.HasSelectHandlers;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DriverEducationEditor implements IsWidget, Editor<DriverEducation> {

	private FormPanel panel;
	private VerticalLayoutContainer container;

	private TextField educationType;
	private TextField yearofPassing;
	private TextField university;
	private TextField school_college;
	private TextField remarks;

	private TextButton save;

	public DriverEducationEditor() {
		panel = new FormPanel();
		panel.setLabelWidth(75);

		container = new VerticalLayoutContainer();
		panel.setWidget(container);

		educationType = new TextField();
		yearofPassing = new TextField();
		university = new TextField();
		school_college = new TextField();
		remarks = new TextField();

		container.add(new FieldLabel(educationType, "Education Type"), new VerticalLayoutData(.5, -1));
		container.add(new FieldLabel(yearofPassing, "Year of Passing"), new VerticalLayoutData(.3, -1));
		container.add(new FieldLabel(university, "University"), new VerticalLayoutData(.7, -1));
		container.add(new FieldLabel(school_college, "School/College"), new VerticalLayoutData(.7, -1));
		container.add(new FieldLabel(remarks, "Remarks"), new VerticalLayoutData(1, -1));

		save = new TextButton("Save");
		save.setEnabled(false);
		// container.add(save);
	}

	public void setSaveEnabled(boolean enabled) {
		save.setEnabled(enabled);
		educationType.setEnabled(enabled);
		yearofPassing.setEnabled(enabled);
		if (!enabled) {

			educationType.setValue("");
			yearofPassing.setValue("");
		}
	}

	public HasSelectHandlers getSaveButton() {
		return save;
	}

	public Widget asWidget() {
		return panel;
	}
}