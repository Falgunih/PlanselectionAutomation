package pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.PageTemplate;
import commonActions.TestDataFunctions;

public class EmployerGroupManagementPage extends PageTemplate {
    String loginPageTitle = "DZee Solutions Login";
    HashMap<String, By> pageLocators ;
    static String pageLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\EmployerGroupManagementPage.properties";
	
    public EmployerGroupManagementPage(BrowserActions b){
 super(b, pageLocatorsPath);
    }

    public void emptyEmployerData(){
    	goToEmployerGroupManagementTab();
    	browse.threadSleepWait(2000);
		browse.jScriptClick(pageLocators.get("saveEmployer"));
		employerDataErrorMessages();
		emailZipErrorMessages();
		openAddEmployerPage();
	}

    public void onlyEmployerOrganizationFullName(String organization){
    	browse.type(pageLocators.get("organizationName"), organization);
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("selfFundedErrorMessage"));
		browse.assertObject(pageLocators.get("assignedNameRequiredMessage"));
		browse.assertObject(pageLocators.get("passwordAssignedRequiredMessage"));
    	emailZipErrorMessages();
    	openAddEmployerPage();
    }
    
    public void onlySelfFundedSelection(){
    	browse.click(pageLocators.get("selfFundedPlansYes"));
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("fullNameRequiredMessage"));
    	browse.assertObject(pageLocators.get("assignedNameRequiredMessage"));
		browse.assertObject(pageLocators.get("passwordAssignedRequiredMessage"));
		emailZipErrorMessages();
		openAddEmployerPage();
    }
    
    public void onlyAssignedName(String assignedName){
    	browse.type(pageLocators.get("addEmployerAssignedName"), assignedName);
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("fullNameRequiredMessage"));
       	browse.assertObject(pageLocators.get("selfFundedErrorMessage"));
    	browse.assertObject(pageLocators.get("passwordAssignedRequiredMessage"));
    	emailZipErrorMessages();
    	openAddEmployerPage();
    }
    
    public void onlyEmployerPassword(String password){
    	browse.type(pageLocators.get("employerPassword"), password);
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
		browse.assertObject(pageLocators.get("fullNameRequiredMessage"));
		browse.assertObject(pageLocators.get("selfFundedErrorMessage"));
		browse.assertObject(pageLocators.get("assignedNameRequiredMessage"));
		emailZipErrorMessages();
		openAddEmployerPage();
    }
    
    public void onlyEmployerEmail(String email){
    	browse.type(pageLocators.get("employerEmail"), email);
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
    	employerDataErrorMessages();
    	browse.assertObject(pageLocators.get("zipCodeRequiredMessage"));
    	openAddEmployerPage();
    }
    
    public void onlyZipCode(String zip){
    	browse.type(pageLocators.get("zipCode"), zip);
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
    	employerDataErrorMessages();
    	browse.assertObject(pageLocators.get("emailIdRequiredMessage"));
    	openAddEmployerPage();
    }
    
    public void highSinglePremium(String singlePremium, String familyPremium){
    	browse.type(pageLocators.get("fixedSinglePremium"), singlePremium);
    	browse.type(pageLocators.get("fixedFamilyPremium"), familyPremium);
    	premiumErrorMessages();
    	openAddEmployerPage();
    }
    
    public void lowFamilyPremium(String singlePremium, String familyPremium){
    	browse.type(pageLocators.get("fixedSinglePremium"), singlePremium);
    	browse.type(pageLocators.get("fixedFamilyPremium"), familyPremium);
    	premiumErrorMessages();
    	openAddEmployerPage();
    }

	public void premiumErrorMessages() {
		browse.assertObject(pageLocators.get("highSinglePremiumMessage"));
    	browse.assertObject(pageLocators.get("lowFamilPremiumMessage"));
	}
    
    public void invalidSingleFSAContribution(String singleFSA){
    	browse.type(pageLocators.get("fixedSingleFSA"), singleFSA);
    	browse.click(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("FSAError"));
    	openAddEmployerPage();
    }
    
    public void invalidFamilyFSAContribution(String familyFSA){
    	browse.type(pageLocators.get("fixedFamilyFSA"), familyFSA);
    	browse.click(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("FSAError"));
    	openAddEmployerPage();
    }
    
    public void invalidSingleHSAContribution(String singleHSA){
    	browse.type(pageLocators.get("fixedSingleHSA"), singleHSA);
    	browse.click(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("singleHSAError"));
    	openAddEmployerPage();
    }
    
    public void invalidFamilyHSAContribution(String familyHSA){
    	browse.type(pageLocators.get("fixedFamilyHSA"), familyHSA);
    	browse.click(pageLocators.get("saveEmployer"));
    	browse.assertObject(pageLocators.get("familyHSAError"));
    	openAddEmployerPage();
    }
    
    public void addNewEmployer(String organization, String assignedName, String password, String email, String zip, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
    	browse.threadSleepWait(1000);
    	browse.type(pageLocators.get("organizationName"), organization);
    	browse.click(pageLocators.get("selfFundedPlansYes"));
    	browse.type(pageLocators.get("addEmployerAssignedName"), assignedName);
    	browse.type(pageLocators.get("employerPassword"), password);
    	browse.type(pageLocators.get("employerEmail"), email);
    	browse.type(pageLocators.get("zipCode"), zip);
    	browse.type(pageLocators.get("fixedSingleFSA"), singleFSA);
    	browse.type(pageLocators.get("fixedFamilyFSA"), familyFSA);
    	browse.type(pageLocators.get("fixedSingleHSA"), singleHSA);
    	browse.type(pageLocators.get("fixedFamilyHSA"), familyHSA);
    	browse.jScriptClick(pageLocators.get("saveEmployer"));
    }
    
    public void addNewEmployerGroup(String organization, String assignedName, String password, String email, String zip, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
    	addNewEmployer(organization, assignedName, password, email, zip, singleFSA, familyFSA, singleHSA, familyHSA);
    	browse.loadingSymbolState(pageLocators.get("loadingSymbol"), 8);
    	By employer = By.xpath("//dd[@class=\"ng-binding\"][.='"+assignedName+"')]");
    	browse.threadSleepWait(2000);
    	browse.assertObject(employer);
    	openAddEmployerPage();
    	}
    
    public void addEmployerWithExistingId(String organization, String assignedName, String password, String email, String zip, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
    	//browse.click(pageLocators.get("addEmployer"));
    	//browse.threadSleepWait(2000);
    	addNewEmployer(organization, assignedName, password, email, zip, singleFSA, familyFSA, singleHSA, familyHSA);
    	browse.loadingSymbolState(pageLocators.get("loadingSymbol"), 8);
    	browse.assertObject(pageLocators.get("emailIdExistsMessage"));
    	browse.threadSleepWait(2000);
    }
       	
	public void employerDataErrorMessages() {
		browse.assertObject(pageLocators.get("fullNameRequiredMessage"));
		browse.assertObject(pageLocators.get("selfFundedErrorMessage"));
		browse.assertObject(pageLocators.get("assignedNameRequiredMessage"));
		browse.assertObject(pageLocators.get("passwordAssignedRequiredMessage"));
	}
    
	public void emailZipErrorMessages() {
		browse.assertObject(pageLocators.get("emailIdRequiredMessage"));
		browse.assertObject(pageLocators.get("zipCodeRequiredMessage"));
	}
		
	public void openAddEmployerPage() {
		browse.refreshpage();
    	browse.click(pageLocators.get("addEmployer"));
    	browse.threadSleepWait(5000);
	}
	
    public void goToEmployerGroupManagementTab(){
    	browse.click(pageLocators.get("employerGroupManagementTab"));
    	browse.threadSleepWait(200);
    	browse.click(pageLocators.get("addEmployer"));
    }
}
