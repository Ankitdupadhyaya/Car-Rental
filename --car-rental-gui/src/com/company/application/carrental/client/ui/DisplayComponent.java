package com.company.application.carrental.client.ui;

import com.extjs.gxt.ui.client.widget.Composite;

public class DisplayComponent {

	private Composite composite;
	private DisplayComponentDirection componentDirection;

	public DisplayComponent() {
		super();
	}

	public DisplayComponent(Composite composite, DisplayComponentDirection componentDirection) {
		super();
		this.composite = composite;
		this.componentDirection = componentDirection;
	}

	/**
	 * @return the composite
	 */
	public Composite getComposite() {
		return composite;
	}

	/**
	 * @param composite the composite to set
	 */
	public void setComposite(Composite composite) {
		this.composite = composite;
	}

	/**
	 * @return the componentDirection
	 */
	public DisplayComponentDirection getComponentDirection() {
		return componentDirection;
	}

	/**
	 * @param componentDirection the componentDirection to set
	 */
	public void setComponentDirection(DisplayComponentDirection componentDirection) {
		this.componentDirection = componentDirection;
	}
}