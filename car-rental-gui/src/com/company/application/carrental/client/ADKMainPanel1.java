package com.company.application.carrental.client;

import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.toolbar.SeparatorToolItem;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

/**
 * December 2008
 * 
 * @author A_jouve MainPanel class : contains the specific part of an ADK
 *         Application
 */
public class ADKMainPanel1 extends BorderLayoutContainer {

	private static final String ID_DISPLAY_PANEL = "displayPanel";
	private static final String ID_CENTER_PANEL = "centerPanel";
	private static final String ID_WEST_PANEL = "westPanel";
	private static final String ID_EAST_PANEL = "eastPanel";
	private static final String ID_SOUTH_PANEL = "southPanel";

	private ContentPanel displayPanel;
	private ContentPanel westPanel;
	private ContentPanel eastPanel;
	private ContentPanel southPanel;
	private ContentPanel centerPanel;
	private ToolBar toolBar;

	/**
	 * ADKMainPanel : default CenterPanel + optional West, East, South and North
	 * Panel
	 */
	public ADKMainPanel1(String id) {

		setId(id);

		setBorders(false);

		displayPanel = new ContentPanel();
		setCenterWidget(displayPanel);
	}

	/**
	 * Add a ToolBar to the centerPanel
	 */
	public void addToolBar() {

		toolBar = new ToolBar();
		toolBar.setHeight(31);
		// toolBar.setAutoWidth(true);
		centerPanel = new ContentPanel();
		// centerPanel.setScrollMode(Scroll.AUTO);
		displayPanel.add(toolBar);
		displayPanel.add(centerPanel);
	}

	// /**
	// * Add a textfield item to the ToolBar
	// */
	// public void addTextFieldItem(String id, String label,
	// SelectionListener<ComponentEvent> listener) {
	// LabelToolItem labelItem = new LabelToolItem(label);
	// toolBar.add(labelItem);
	// TextField<String> text = new TextField<String>();
	// toolBar.add(text);
	// }

	// /**
	// * Add an action button to the ToolBar
	// *
	// * @param information
	// * @param listener
	// */
	// public void addIconItem(String id, String information, String icon,
	// SelectionListener<IconButtonEvent> listener) {
	// IconButton iconButton = new IconButton(icon);
	// iconButton.setToolTip(information);
	// iconButton.addSelectionListener(listener);
	// iconButton.setId(id);
	// toolBar.add(iconButton);
	// }

	// /**
	// * Add an action button to the ToolBar
	// *
	// * @param information
	// * @param listener
	// */
	// public void addButtonItem(String id, String label, String style,
	// SelectionListener<ButtonEvent> listener) {
	// Button button = new Button(label);
	// if (style != null) {
	// button.setIconStyle(style);
	// }
	// button.setId(id);
	// button.addSelectionListener(listener);
	// toolBar.add(button);
	// }

	/**
	 * addSeparator between items
	 */
	public void addSeparatorItem() {
		toolBar.add(new SeparatorToolItem());
	}

	/**
	 * Add a west panel to your application
	 */
	public void addWestPanel(String title) {
		addWestPanel(title, 200);
	}

	/**
	 * Add a west panel to your application
	 */
	public void addWestPanel(String title, Integer size) {

		westPanel = new ContentPanel();
		westPanel.setHeaderVisible(true);
		westPanel.setHeadingText(title);

		BorderLayoutData westData = new BorderLayoutData();
		westData.setSplit(true);
		westData.setCollapsible(true);
		westData.setMargins(new Margins(5));

		setWestWidget(westPanel, westData);
	}

	/**
	 * Add an east panel to your application
	 */
	public void addEastPanel(String title) {
		addEastPanel(title, 200);
	}

	/**
	 * Add an east panel to your application
	 */
	public void addEastPanel(String title, Integer size) {

		eastPanel = new ContentPanel();
		eastPanel.setHeaderVisible(true);
		eastPanel.setHeadingText(title);

		BorderLayoutData eastData = new BorderLayoutData();
		eastData.setSplit(true);
		eastData.setCollapsible(true);
		eastData.setMargins(new Margins(5));

		setEastWidget(eastPanel, eastData);
	}

	/**
	 * Add a south panel to your application
	 */
	public void addSouthPanel(String title) {
		addSouthPanel(title, 100);
	}

	/**
	 * Add a south panel to your application
	 */
	public void addSouthPanel(String title, Integer size) {

		southPanel = new ContentPanel();
		southPanel.setHeaderVisible(true);
		southPanel.setHeadingText(title);

		BorderLayoutData southData = new BorderLayoutData();
		southData.setSplit(true);
		southData.setCollapsible(true);
		southData.setFloatable(true);
		southData.setMargins(new Margins(0, 5, 5, 5));

		setSouthWidget(southPanel, southData);
	}

	/**
	 * @return CenterPanel
	 */
	public ContentPanel getCenterPanel() {

		if (centerPanel == null) {
			return displayPanel;
		}
		return centerPanel;
	}

	/**
	 * @return WestPanel
	 */
	public ContentPanel getWestPanel() {
		return westPanel;
	}

	/**
	 * @return EastPanel
	 */
	public ContentPanel getEastPanel() {
		return eastPanel;
	}

	/**
	 * @return SouthPanel
	 */
	public ContentPanel getSouthPanel() {
		return southPanel;
	}

	/**
	 * Display the ADKMainPanel
	 */
	public void display() {
		this.display();
	}

	/**
	 * @return toolbar : the top toolbar of the main panel
	 */
	public ToolBar getToolBar() {
		return toolBar;
	}

	// public void addCMItem(String buttonLockadminId, String
	// buttonLockadminLabel, ADKConfigManager configMgrObj) {
	// toolBar.add(configMgrObj);
	// }

	// /**
	// * Add a Log out item with a listener to the menu bar
	// *
	// * @param id
	// * : button id
	// * @param label
	// * : button label
	// * @param urlRedirection
	// * : specify the url after the log out process
	// */
	// public void addLogOutButton(String id, String label, String
	// urlRedirection) {
	// ADKLogOut logOut = new ADKLogOut(id, label, urlRedirection);
	// toolBar.add(new FillToolItem());
	// toolBar.add(logOut);
	// }
	//
	// /**
	// * Add a Log out item with a listener to the menu bar
	// *
	// * @param id
	// * : button id
	// * @param label
	// * : button label
	// * @param listener
	// * : listener called (a listener which disconnect the user is
	// * already implemented)
	// */
	// public void addLogOutButton(String id, String label,
	// ADKButtonListener listener) {
	// ADKLogOut logOut = new ADKLogOut(id, label, listener);
	// toolBar.add(new FillToolItem());
	// toolBar.add(logOut);
	// }
	//
	// /**
	// * Add a Log out item which will close the application
	// *
	// * @param id
	// * : button id
	// * @param label
	// * : button label
	// * @param appToClose
	// * : appToClose
	// */
	// public void addLogOutButton(String id, String label,
	// ADKApplication appToClose) {
	// ADKLogOut logOut = new ADKLogOut(id, label, appToClose);
	// toolBar.add(new FillToolItem());
	// toolBar.add(logOut);
	// }

}
