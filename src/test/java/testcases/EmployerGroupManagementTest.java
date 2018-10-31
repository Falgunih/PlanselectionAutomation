package testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonActions.TestDataProvider;
import commonActions.TestTemplate;
import dataproviders.EmployerGroupManagementDataProviders;

public class EmployerGroupManagementTest extends TestTemplate {
    public EmployerGroupManagementTest(){
		EmployerGroupManagementDataProviders.sheetName="empGrp";
	}
	
    @BeforeClass
    public void loginUsingBroker(){
    	login.brokerLogin();
    }
    
	@Test(priority=0)
	public void emptyEmployerData(){
		emp.emptyEmployerData();
	}
	
	@Test(priority=1, dataProvider = "onlyFieldsData", dataProviderClass=EmployerGroupManagementDataProviders.class )
	public void onlyEmployerOrganizationFullName(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.onlyEmployerOrganizationFullName(organization);
	}
		
	@Test(priority=2)
	public void onlySelfFundedPlans(){
		emp.onlySelfFundedSelection();
	}
	
	@Test(priority=3, dataProvider = "onlyFieldsData", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void onlyAssignedName(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.onlyAssignedName(assignedName);
	}
	
	@Test(priority=4, dataProvider = "onlyFieldsData", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void onlyEmployerPassword(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.onlyEmployerPassword(password);
	}
	
	@Test(priority=5, dataProvider = "onlyFieldsData", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void onlyEmployerEmailId(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.onlyEmployerEmail(email);
	}
	
	@Test(priority=6, dataProvider = "onlyFieldsData", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void onlyEmployerZipCode(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.onlyZipCode(zip);
	}
	
	/*
	@Test(priority=7, dataProvider = "premiumData", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void highSinglePremium(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.highSinglePremium(singlePremium, familyPremium);
	}
	
	@Test(priority=8, dataProvider = "premiumData", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void lowFamilyPremium(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.lowFamilyPremium(singlePremium, familyPremium);
	}
	
	@Test(priority=9, dataProvider = "invalidFsaHsaContribution", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void invalidSingleFSAContribution(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.invalidSingleFSAContribution(singleFSA);
	}
	
	@Test(priority=10, dataProvider = "invalidFsaHsaContribution", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void invalidFamilyFSAContribution(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.invalidFamilyFSAContribution(familyFSA);
	}
	
	@Test(priority=11, dataProvider = "invalidFsaHsaContribution", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void invalidSingleHSAContribution(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.invalidSingleHSAContribution(singleHSA);
	}
	
	@Test(priority=12, dataProvider = "invalidFsaHsaContribution", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void invalidFamilyHSAContribution(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.invalidFamilyHSAContribution(familyHSA);	
		}
	
	
   @Test(priority=13, dataProvider = "addNewEmployer", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void addNewEmployerGroup(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.addNewEmployerGroup(organization, assignedName, password, email, zip, singleFSA, familyFSA, singleHSA, familyHSA);
	}
	
	@Test(priority=14, dataProvider = "addNewEmployer", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void addEmployerWithExistingId(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		emp.addEmployerWithExistingId(organization, assignedName, password, email, zip, singleFSA, familyFSA, singleHSA, familyHSA);
	}*/
}
