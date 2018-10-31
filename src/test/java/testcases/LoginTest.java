package testcases;
import org.testng.annotations.Test;
	import commonActions.TestTemplate;
import dataproviders.LoginDataProviders;

public class LoginTest extends TestTemplate{
	
	public LoginTest(){
		LoginDataProviders.sheetName="loginScenarios";
	}

	@Test
	public void emptyLoginCredentials() {
		login.emptyLoginCredentials();
	}
		
   @Test(dataProvider = "onlyLoginId", dataProviderClass = LoginDataProviders.class)
	 public void onlyLoginId(String scenario, String emailID, String pwd) {
		login.onlyLoginId(emailID);
	}
					
	@Test(dataProvider = "onlyPassword", dataProviderClass = LoginDataProviders.class)
	public void onlyPassword(String scenario, String emailID, String pwd) {
	    login.onlyPassword(pwd);
	}
						
	@Test(dataProvider = "invalidLoginId", dataProviderClass=LoginDataProviders.class)
	public void invalidLoginId(String scenario, String emailID, String pwd) {
		login.invalidLoginId(emailID, pwd);
	}
								
	@Test(dataProvider = "invalidPassword", dataProviderClass=LoginDataProviders.class)
	public void invalidPassword(String scenario, String emailID, String pwd) {
		login.invalidPassword(emailID, pwd);
	}

	@Test(dataProvider = "validLogin", dataProviderClass=LoginDataProviders.class)
	public void validLogin(String scenario, String emailID, String pwd) {
			login.validLogin(emailID, pwd);
}	
	@Test
	public void loginPageTitle(){
		login.getLoginPageTitle();
	}

	@Test
	public void employerLoginLandingPageTest(){
		login.employerLogin();
		login.logout();
	}
	
	@Test
	public void brokerLoginLandingPageTest(){
		login.brokerLogin();
		login.logout();
	}
	
	@Test
	public void employeeLoginLandingPageTest(){
		login.employeeLogin();
		login.logout();
	}
}
