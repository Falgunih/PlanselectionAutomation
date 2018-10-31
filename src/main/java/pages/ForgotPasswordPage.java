package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.PageTemplate;
import commonActions.TestDataFunctions;

public class ForgotPasswordPage extends PageTemplate {
/*
	BrowserActions browse;
	ObjectMap objMap;
    TestDataFunctions data = new TestDataFunctions();
    String loginPageTitle = "DZee Solutions Login";
    HashMap<String, By>pageLocators ;*/
    String forgotPasswordTitle = "Forgot Password";
    static String pageLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\ForgotPasswordPage.properties";
	
    public ForgotPasswordPage(BrowserActions b){
	super(b, pageLocatorsPath);
	}

	public void emptyForgotPasswordEmail(){
		browse.click(pageLocators.get("sendButton"));
		browse.assertObject(pageLocators.get("emptyEmailMessage"));	
	}
	
	public void getForgotPasswordPageTitle(){
		goToForgotPasswordPage();
		browse.getPageTitle(forgotPasswordTitle);
	}
	
	public void invalidForgotPasswordEmail(String emailID){
		browse.type(pageLocators.get("forgotPasswordEmail"), emailID);
		browse.click(pageLocators.get("sendButton"));
		browse.assertObject(pageLocators.get("invalidEmailMessage"));
		browse.threadSleepWait(1000);
	}
	
	public void validForgotPasswordEmail(String emailID){
		browse.type(pageLocators.get("forgotPasswordEmail"), emailID);
		browse.click(pageLocators.get("sendButton"));
		browse.threadSleepWait(500);
		browse.assertObject(pageLocators.get("mailSentMessage"));
		browse.threadSleepWait(2000);
		browse.click(pageLocators.get("forgotPasswordCancelButton"));
		browse.assertObject(pageLocators.get("loginForm"));
		browse.threadSleepWait(500);	
	}
	
	public void goToForgotPasswordPage() {
				browse.click(pageLocators.get("forgotPasswordLink"));
				browse.waitForElementToBeVisible(pageLocators.get("enterEmailAddress"));
			}
}
