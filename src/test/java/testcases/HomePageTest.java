package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonActions.TestDataProvider;
import commonActions.TestTemplate;
import pages.HomePage;

public class HomePageTest extends TestTemplate{
     HomePage home;
     
     @BeforeClass
     public void createInstance(){
    	 home = new HomePage(browse);
    	 login.employerLogin();
     }
     
     @Test(priority=0)
     public void newPasswordHelpTest(){
    	 home.newPasswordHelp();
     }
     
     @Test(priority=1)
     public void emptyPasswordsTest(){
    	 home.emptyPasswords();
     }
     
     @Test(dataProvider="incorrectOldPassword", dataProviderClass=TestDataProvider.class, priority=2)
     public void incorrectOldPasswordTest(String oldPass, String newPass, String confirmPass){
    	 home.incorrectOldPassword(oldPass, newPass, confirmPass);
     }
     
     @Test(dataProvider="incorrectNewPassword", dataProviderClass=TestDataProvider.class, priority=3)
     public void incorrectNewPasswordTest(String oldPass, String newPass, String confirmPass){
    	 home.incorrectNewPassword(oldPass, newPass, confirmPass);
     }
     
     @Test(dataProvider="incorrectConfirmPassword", dataProviderClass=TestDataProvider.class, priority=4)
     public void incorrectConfirmPasswordTest(String oldPass, String newPass, String confirmPass){
    	 home.incorrectConfirmPassword(oldPass, newPass, confirmPass);
     }
     
     @Test(dataProvider="changePassword", dataProviderClass=TestDataProvider.class, priority=5)
     public void changePasswordTest(String oldPass, String newPass, String confirmPass){
    	 home.changePassword(oldPass, newPass, confirmPass);
     }

	/*@Test
	public void deleteEmployeeTest(){
		home.deletePlanFunctionality();
	}
	*/		
}
