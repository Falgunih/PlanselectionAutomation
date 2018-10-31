package testcases;
import org.testng.annotations.Test;
import commonActions.TestTemplate;
import dataproviders.ForgotPasswordDataProviders;

public class ForgotPasswordTest extends TestTemplate {

	public ForgotPasswordTest(){
		ForgotPasswordDataProviders.sheetName="loginScenarios";
	}
	
   	@Test(priority=0)
	public void forgotPasswordTitle(){
		fpwd.getForgotPasswordPageTitle();
	}

    @Test(priority=1)
	 public void emptyPasswordEmail() {
		fpwd.emptyForgotPasswordEmail();
	}
    
	@Test(priority=2, dataProvider="invalidPasswordEmail", dataProviderClass=ForgotPasswordDataProviders.class)
	public void invalidPasswordEmail(String scenario, String emailID, String pwd) {
		fpwd.invalidForgotPasswordEmail(emailID);
	}

	@Test(priority=3, dataProvider = "validMail", dataProviderClass=ForgotPasswordDataProviders.class)
	public void validPasswordEmail(String scenario, String emailID, String pwd) {
		fpwd.validForgotPasswordEmail(emailID);
	}
}
