package pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.PageTemplate;
import commonActions.TestDataFunctions;

public class ContactDzeePage extends PageTemplate {
    static String contactDzeeLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\ContactDzeePage.properties";
	
    public ContactDzeePage(BrowserActions b){
    	super(b, contactDzeeLocatorsPath);
    }

    public void emptyContactDetails(){
    	browse.click(pageLocators.get("sendButton"));
    }
    
    
}
