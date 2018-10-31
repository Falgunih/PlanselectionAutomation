package pages;

import java.util.Properties;

import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.TestDataFunctions;

public class SanitySuitePage {
	TestDataFunctions data = new TestDataFunctions();
	BrowserActions browse;
	ObjectMap objMap;
	Properties config = data.getPropertiesFileData();
	HCBLogin login;
	EmployerGroupManagementPage empgrp;
	
	public void addEmployer(){
	login.brokerLogin();
	
	}

}
