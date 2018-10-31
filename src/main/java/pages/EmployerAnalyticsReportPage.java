package pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.PageTemplate;

public class EmployerAnalyticsReportPage extends PageTemplate {

	static String pageLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\EmployerAnalyticsReportPage.properties";
	
	public EmployerAnalyticsReportPage(BrowserActions b){
		super(b, pageLocatorsPath);
	}
	
	public void blankEnrollmentYear(){
		browse.clearField(pageLocators.get("enrollmentYear"));
		browse.assertObject(pageLocators.get("blankEnrollmentYearMessage"));
	}
	
	
}
