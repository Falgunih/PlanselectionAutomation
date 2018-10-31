package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import commonActions.BrowserActions;
import commonActions.ObjectMap;

public class ViewPlansPage {
	BrowserActions browse;
	ObjectMap objMap;
	 HashMap<String, By> viewPlansLocators ;
	 String viewPlansPageLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\ViewPlansPage.properties";
	
public ViewPlansPage(BrowserActions b){
		browse = b;
		objMap = new ObjectMap(viewPlansPageLocatorsPath);
	}

public void viewPlansLocators(){
	viewPlansLocators = objMap.getLocator();
}

	public void employerGroupPlans(){
            browse.click(viewPlansLocators.get("employerGroupManagementTab"));
            browse.click(viewPlansLocators.get("viewFirstEmployerGroup"));
            String dropDownText = browse.getText(viewPlansLocators.get("editEmployerAssignedName"));
            browse.click(viewPlansLocators.get("viewPlansTab"));
            browse.selectJcfDropdownValue(viewPlansLocators.get("employerGroup"), dropDownText);
   	}
	
	public void employerGroupDropdown(){
		browse.click(viewPlansLocators.get("dropdownOpener"));
		browse.assertObject(viewPlansLocators.get("dropdownList"));
	}
	
	public void radioButtons(){
		browse.checkRadioButtonStatus(viewPlansLocators.get("healthcarePlans"));
		browse.click(viewPlansLocators.get("supplementPlans"));
		browse.checkRadioButtonStatus(viewPlansLocators.get("supplementPlans"));
	}
	
	public void employeeListButton(){
		browse.click(viewPlansLocators.get("employeeList"));
		browse.assertObject(viewPlansLocators.get("homePage"));
		browse.threadSleepWait(200);
		browse.click(viewPlansLocators.get("planAdministration"));
	}
	
	public void addEmployeeButton(){
		browse.click(viewPlansLocators.get("addEmployee"));
		browse.assertObject(viewPlansLocators.get("myProfilePage"));
		browse.click(viewPlansLocators.get("homeIcon"));
		browse.click(viewPlansLocators.get("planAdministration"));
	}
	
	public void premiumDeductibleLink(){
		browse.click(viewPlansLocators.get("premiumDeductibleLink"));
		browse.assertObject(viewPlansLocators.get("premiumDeductiblePopup"));
		browse.pressEscKey();
	}
	
	public void employerReadyForEnrollment(){
		browse.click(viewPlansLocators.get("readyForEnrollmentCheckbox"));
		browse.assertObject(viewPlansLocators.get("readyForEnrollmentPopup"));
		browse.pressEscKey();
	}
	
}
