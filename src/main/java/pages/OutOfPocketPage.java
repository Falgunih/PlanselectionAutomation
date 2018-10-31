package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import commonActions.BrowserActions;
import commonActions.ObjectMap;

public class OutOfPocketPage {
	BrowserActions browse;
	ObjectMap objMap;
	String oopLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\OutOfPocketPage.properties";
	HashMap<String,By> oopLocators = new HashMap<String, By>();
	
	public OutOfPocketPage(BrowserActions b){
		browse = b;
		objMap = new ObjectMap(oopLocatorsPath);
		oopLocators();
	}
	
	public void oopLocators(){
		oopLocators = objMap.getLocator();
	}
	
	public void goToOopTab(){
	browse.scrollUp();
	browse.threadSleepWait(1000);
	browse.jScriptClick(oopLocators.get("oopTab"));	
	}
	
	public void goToRecommendedPlansTab(){
		browse.click(oopLocators.get("recommendedPlansTabButton"));
		browse.assertObject(oopLocators.get("recommendedPlansTab"));
		browse.click(oopLocators.get("oopTab"));
		browse.threadSleepWait(1000);
	}
	
	public void oopDistributionGraph(){
		browse.assertObject(oopLocators.get("oopGraph"));
	}
	
	public void removeSelectionFromGraph(){
		browse.jScriptClick(oopLocators.get("drugAndPrescriptionsBox"));
		browse.assertObjectAbsence(oopLocators.get("drugAndPrescriptions"));
	}
	
	public void refreshOopDistribution(){
		browse.refreshpage();
		browse.threadSleepWait(4000);
		browse.loadingSymbolState(oopLocators.get("loadingSymbol"), 5);
		browse.assertObject(oopLocators.get("myProfileHeader"));
	}
}
