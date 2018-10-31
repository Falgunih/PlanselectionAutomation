/**
 * 
 */
package testcases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonActions.TestTemplate;
import dataproviders.EmployerGroupManagementDataProviders;

/**
 * @author GS-0985
 *
 */
public class AssignPlansTest extends TestTemplate {

	public AssignPlansTest(){
		EmployerGroupManagementDataProviders.sheetName="empGrp";
	}
	
	@BeforeClass
    public void loginUsingBroker(){
    	login.brokerLogin();
    }

	@Test(dataProvider = "addNewEmployer", dataProviderClass=EmployerGroupManagementDataProviders.class)
	public void assignHealthcarePlans(String scenario, String organization, String assignedName, String password, String email, String zip,String singlePremium, String familyPremium, String singleFSA, String familyFSA, String singleHSA, String familyHSA){
		assign.assignHealthcarePlansToEmpGrp(assignedName);
	}
}
