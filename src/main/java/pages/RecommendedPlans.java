package pages;
import java.util.HashMap;

import org.openqa.selenium.By;

import commonActions.BrowserActions;
import commonActions.ObjectMap;

public class RecommendedPlans {
	BrowserActions browse;
	ObjectMap objMap;
	String locatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\RecommendedPlansPage.properties";
	HashMap<String, By> recommendedPlansLocators = new HashMap<String, By>();
	
	public RecommendedPlans(BrowserActions b){
		browse = b;
		objMap = new ObjectMap(locatorsPath);
		recommendedPlansLocators();
	}
	
	public void recommendedPlansLocators(){
		recommendedPlansLocators = objMap.getLocator();
	}
	
	public void goToFirstEmployeeProfile(){
		browse.click(recommendedPlansLocators.get("firstEmployee"));
		browse.threadSleepWait(2000);
		browse.click(recommendedPlansLocators.get("recommendedPlansTab"));
/*		browse.click(recommendedPlansLocators.get("showMeMyHealthPlans"));
		if(browse.isElementPresent(recommendedPlansLocators.get("medicareEligibilityPopup"))){
		//if(browse.isElementDisplayed(recommendedPlansLocators.get("medicareEligibilityPopup"))){
			browse.click(recommendedPlansLocators.get("selectButton"));
		} else
		browse.loadingSymbolState(recommendedPlansLocators.get("loadingSymbol"), 5);*/
	}
	
	public void tellMeAboutPage(){
		goToFirstEmployeeProfile();
		browse.threadSleepWait(2000);
		browse.scrollUp();
		checkPopUpElements(recommendedPlansLocators.get("tellMeAboutThisPageButton"), recommendedPlansLocators.get("tellMeAboutPagePopUp"));
	}
	
	public void whatCanIDoNext(){
		checkPopUpElements(recommendedPlansLocators.get("whatCanIDoNextButton"), recommendedPlansLocators.get("whatCanIDoNextPopUp"));
	}
	
	public void oopDetails(){
		checkPopUpElements(recommendedPlansLocators.get("oopDetailsOfFirstPlan"), recommendedPlansLocators.get("oopDetailsPopUp"));
	}
	
	public void overrideHsaFsaContribution(){
		checkPopUpElements(recommendedPlansLocators.get("overrideContribution"), recommendedPlansLocators.get("overridePopUpTitle"));
	}
	
	public void invalidContribution(){
		browse.click(recommendedPlansLocators.get("overrideContribution"));
		browse.assertText(recommendedPlansLocators.get("customAmount"), "0");
	}
	public void customSupplementPlanPopup(){
		checkPopUpElements(recommendedPlansLocators.get("customSupplementPlan"), recommendedPlansLocators.get("customSupplementPlanPopUp"));
	}
	
	public void supplementPlanPdf(){
		browse.click(recommendedPlansLocators.get("supplementPlanPdfOfFirstPlan"));
		browse.checkNewTab();
	}
	
	public void enrollForPlanPopup(){
		checkProjectEnrollOptions(recommendedPlansLocators.get("enrollInFirstPlan"), recommendedPlansLocators.get("enrollPlanConfirmationPopUp"), recommendedPlansLocators.get("closePlanEnrollmentPopUp"));
	}
	
	public void goToOopDistribution(){
		checkProjectEnrollOptions(recommendedPlansLocators.get("oopFirstPlan"), recommendedPlansLocators.get("oopHeader"), recommendedPlansLocators.get("oopRecommendedPlansButton"));
	}
	
	public void goToFiveYearProjections(){
		checkProjectEnrollOptions(recommendedPlansLocators.get("fiveYearProjectionsOfFirstPlan"), recommendedPlansLocators.get("fiveYearProjectionsHeader"), recommendedPlansLocators.get("fiveYearRecommendedPlansButton"));
	}
	
	public void goToLifetimeProjections(){
		checkProjectEnrollOptions(recommendedPlansLocators.get("lifetimeProjectionsOfFirstPlan"), recommendedPlansLocators.get("lifetimeProjections"), recommendedPlansLocators.get("lifetimeRecommendedPlansButton"));
	}

	public void planDetails(){
		browse.click(recommendedPlansLocators.get("planOptionsOfFirstPlan"));
		checkPopUpElements(recommendedPlansLocators.get("planDetailsOfFirstPlan"), recommendedPlansLocators.get("planDetailsPopUp"));
	}
	
	public void planLiterature(){
		checkPlanOptions(recommendedPlansLocators.get("planLiteratureOfFirstPlan"));
	}
	
	public void findMyDoctor(){
		checkPlanOptions(recommendedPlansLocators.get("findMyDoctorOfFirstPlan"));
	}
	
	public void findMyRx(){
		checkPlanOptions(recommendedPlansLocators.get("findMyRxOfFirstPlan"));
	}

	public void informationLink(){
		browse.click(recommendedPlansLocators.get("informationProvidedLink"));
		browse.assertObject(recommendedPlansLocators.get("myProfileTitle"));
		browse.click(recommendedPlansLocators.get("recommendedPlansTab"));
	}
	
	public void dzeeScoreHelp(){
		checkPopUpElements(recommendedPlansLocators.get("dzeeScoreHelp"), recommendedPlansLocators.get("dzeeScorePopup"));
	}
	
	public void healthcareCostsHelp(){
		checkPopUpElements(recommendedPlansLocators.get("healthcareCostsHelp"), recommendedPlansLocators.get("healthcareCostsPopup"));
	}
	
	public void hsaFsaHelp(){
		checkPopUpElements(recommendedPlansLocators.get("hsaFsaHelp"), recommendedPlansLocators.get("hssaFsaPopup"));
	}

	
	public void checkPlanOptions(By by) {
		browse.click(recommendedPlansLocators.get("planOptionsOfFirstPlan"));
		browse.threadSleepWait(1000);
		browse.jScriptClick(by);
		browse.threadSleepWait(5000);
		browse.checkNewTab();
	}

	public void checkProjectEnrollOptions(By by1, By by2, By by3) {
		browse.jScriptClick(recommendedPlansLocators.get("firstPlanProjectionsEnroll"));
		browse.jScriptClick(by1); 
		browse.assertObject(by2);
		browse.threadSleepWait(2000);
		browse.jScriptClick(by3);
		browse.threadSleepWait(4000);
	}
	
	public void checkPopUpElements(By by1, By by2) {
		browse.jScriptClick(by1);
		browse.assertObject(by2);
		browse.pressEscKey();
		browse.threadSleepWait(500);
	}
}
