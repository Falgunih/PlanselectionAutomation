package pages;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.By;
import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.PageTemplate;
import commonActions.TestDataFunctions;

public class HCBLogin extends PageTemplate{
	/*BrowserActions browse;
	ObjectMap objMap;
    TestDataFunctions data = new TestDataFunctions();
    String loginPageTitle = "DZee Solutions Login";
    HashMap<String, By> loginLocators ;*/
	String loginPageTitle = "DZee Solutions Login";
    static String loginLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\LoginPage.properties";
	
  /*  public HCBLogin(BrowserActions b){
		browse = b;
		objMap = new ObjectMap(loginLocatorsPath);
		loginLocators();
	}*/

    public HCBLogin(BrowserActions b){
    	super(b, loginLocatorsPath);
    }
	/*public void loginLocators(){
	    loginLocators = objMap.getLocator();
	}
	*/
	public void emptyLoginCredentials(){
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("loginIdErrorMessage"));
		browse.assertObject(pageLocators.get("passwordErrorMessage"));
		browse.refreshpage();
	}
	
	public void onlyLoginId(String emailID){
		browse.type(pageLocators.get("email"), emailID);
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("passwordErrorMessage"));
		browse.refreshpage();
	}
	
	public void onlyPassword(String pwd){
		browse.type(pageLocators.get("password"), pwd);
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("loginIdErrorMessage"));	
		browse.refreshpage();
	}
	
	public void invalidLoginId(String emailID, String pwd){
		browse.type(pageLocators.get("email"), emailID);
		browse.type(pageLocators.get("password"), pwd);
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("invalidCredMessage"));
		browse.refreshpage();
	}
	
	public void invalidPassword(String emailID, String pwd){
		browse.type(pageLocators.get("email"), emailID);
		browse.type(pageLocators.get("password"), pwd);
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("invalidCredMessage"));
		browse.refreshpage();
	}
	
	public void validLogin(String emailID, String pwd){
		browse.type(pageLocators.get("email"), emailID);
		browse.type(pageLocators.get("password"), pwd);
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("planListingHeader"));
		logout();
	}

   public void getLoginPageTitle(){
		browse.getPageTitle(loginPageTitle);
	}
	
   public void goTohomePageFromLogo(){
	   browse.jScriptClick(pageLocators.get("dzeeLogo"));
	   browse.assertObject(pageLocators.get("loginForm"));
   }

   public void brokerLogin(){
		Properties config = data.getPropertiesFileData();
		browse.type(pageLocators.get("email"), config.getProperty("brokerEmail"));
		browse.type(pageLocators.get("password"), config.getProperty("brokerPassword"));
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("planListingHeader"));
	    browse.assertPresence(pageLocators.get("addEmployeeButton"));
	    browse.assertPresence(pageLocators.get("employeeListButton"));
	}
	
	public void employerLogin(){
		Properties config = data.getPropertiesFileData();
		browse.type(pageLocators.get("email"), config.getProperty("employerEmail"));
		browse.type(pageLocators.get("password"), config.getProperty("employerPassword"));
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("homePage"));
		browse.assertPresence(pageLocators.get("addEmployeeButton"));
	    browse.assertPresence(pageLocators.get("employeeListButton"));
	}
	
	public void employeeLogin(){
		Properties config = data.getPropertiesFileData();
		browse.type(pageLocators.get("email"), config.getProperty("employeeEmail"));
		browse.type(pageLocators.get("password"), config.getProperty("employeePassword"));
		browse.click(pageLocators.get("loginButton"));
		browse.assertObject(pageLocators.get("myProfileHeader"));
		browse.threadSleepWait(500);
		
	}
	
	public void logout(){
		browse.threadSleepWait(500);
		browse.jScriptClick(pageLocators.get("logoutButton"));
	}
}

