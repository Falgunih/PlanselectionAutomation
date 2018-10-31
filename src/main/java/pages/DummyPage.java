package pages;

import commonActions.BrowserActions;
import commonActions.PageTemplate;

public class DummyPage extends PageTemplate {
static String assignPlansLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\AssignPlansPage.properties";
	
public DummyPage(BrowserActions b){
		super(b, assignPlansLocatorsPath ); 
	}
	
	public void printLocator(){
		System.out.println(pageLocators.get("selectEmployer"));
	}
	
	
	
}
