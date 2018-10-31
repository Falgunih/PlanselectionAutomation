/**
 * 
 */
package pages;

import commonActions.BrowserActions;

/**
 * @author GS-0985 Mayuri Wavhal
 *
 */
public class PlanRecommendSanity {

	BrowserActions browse;
	public PlanRecommendSanity(BrowserActions b){
		browse = b;
	}
	EmployerGroupManagementPage empgrp = new EmployerGroupManagementPage(browse);
	
	public void addEmployerGroup(String organization, String assignedName, String password, String email, String zip, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		empgrp.addNewEmployerGroup(organization, assignedName, password, email, zip, singleFSA, familyFSA, singleHSA, familyHSA);
	}
	
	
}
