package pages;
import java.util.HashMap;
import org.openqa.selenium.By;
import commonActions.BrowserActions;
import commonActions.ObjectMap;

public class HomePage {
    
    BrowserActions browse;
    ObjectMap objMap;
    HashMap<String, By> employeeListLocators = new HashMap<String, By>();
    String employeeListLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\HomePage.properties";
    
    public HomePage(BrowserActions b){
    	browse = b;
    	objMap = new ObjectMap(employeeListLocatorsPath);
    	employeeListLocators();
    }
    
    public void employeeListLocators(){
    	employeeListLocators = objMap.getLocator();
	}
    
    public void addEmployeeButton(){
    	homePageElementsScenarios(employeeListLocators.get("addEmployee"), employeeListLocators.get("myProfileHeader"), employeeListLocators.get("homeIcon"));
    }
      
    public void planAdministrationButton(){
    	homePageElementsScenarios(employeeListLocators.get("planAdministration"), employeeListLocators.get("viewPlansTab"), employeeListLocators.get("homeIcon"));
    }
    
    public void accessFirstPlan(){
    	homePageElementsScenarios(employeeListLocators.get("firstPlan"), employeeListLocators.get("myProfileHeader"), employeeListLocators.get("homeIcon"));
    }
    
    public void editEmployee(){
    	homePageElementsScenarios(employeeListLocators.get("editEmployee"), employeeListLocators.get("myProfileHeader"), employeeListLocators.get("homeIcon"));
    	browse.click(employeeListLocators.get("primaryTobaccoYes"));
    	browse.click(employeeListLocators.get("showMeMyHealthPlans"));
    	browse.threadSleepWait(1500);
    	browse.assertObject(employeeListLocators.get("recommendedPlansTab"));
    }
    
    public void goToHomeFromLogo(){	
       	browse.click(employeeListLocators.get("logo"));
       	browse.assertObject(employeeListLocators.get("homePageHeader"));
    }

	public void homePageElementsScenarios(By by1, By by2, By by3) {
		browse.click(by1);
    	browse.assertObject(by2);
    	browse.threadSleepWait(500);
       	browse.click(by3);
	}
	
	public void deleteEmployeePopUp(){
		browse.click(employeeListLocators.get("deleteEmployee"));
		browse.assertObject(employeeListLocators.get("deleteEmployeePopUp"));
	}
    
	public void deleteEmployeeOptions(){
		deleteEmployeePopUp();
		browse.click(employeeListLocators.get("deleteEmployeeCheckbox"));
		browse.assertObject(employeeListLocators.get("deleteEmployeeOk"));
	}
	
	public void cancelDeleteEmployee(){
		deleteEmployeeOptions();
		browse.click(employeeListLocators.get("deleteEmployeeCancel"));
		browse.assertObject(employeeListLocators.get("employeeListHeader"));
	}
	
	public void closeDeleteEmployeePopUp(){
		deleteEmployeePopUp();
		browse.click(employeeListLocators.get("closeDeleteEmployee"));
		browse.assertObject(employeeListLocators.get("employeeListHeader"));
	}
	
	public void homePageTestScenarios(){
		browse.click(employeeListLocators.get("homeButton"));
		browse.assertObject(employeeListLocators.get("currentLoginId"));
		//homePageFunctionality();
		cancelDeleteEmployee();
		closeDeleteEmployeePopUp();
	}
	
	public void goToChangePasswordPage(){
		browse.threadSleepWait(2000);
		browse.jScriptClick(employeeListLocators.get("settingsIcon"));
		browse.jScriptClick(employeeListLocators.get("changePassword"));
	}
	
	public void emptyPasswords(){
		browse.click(employeeListLocators.get("submitButton"));
		browse.assertObject(employeeListLocators.get("oldPasswordErrorMessage"));
		browse.assertObject(employeeListLocators.get("newPasswordErrorMessage"));
		browse.assertObject(employeeListLocators.get("confirmPasswordErrorMessage"));
	}
	
	public void incorrectOldPassword(String oldPass, String newPass, String confirmPass){
		passwordValidation(oldPass, newPass, confirmPass, employeeListLocators.get("incorrectOldPassword"));
	}

	public void incorrectNewPassword(String oldPass, String newPass, String confirmPass){
		passwordValidation(oldPass, newPass, confirmPass, employeeListLocators.get("passwordShouldMatch"));
	}
	
	public void incorrectConfirmPassword(String oldPass, String newPass, String confirmPass){
		passwordValidation(oldPass, newPass, confirmPass, employeeListLocators.get("passwordShouldMatch"));
	}
	
   public void changePassword(String oldPass, String newPass, String confirmPass){
	   passwordValidation(oldPass, newPass, confirmPass, employeeListLocators.get("passwordChanged"));
	}
   
   public void newPasswordHelp(){
	   browse.waitForPageToLoad(3);
	   goToChangePasswordPage();
	   browse.click(employeeListLocators.get("newPasswordHelp"));
	   browse.assertObject(employeeListLocators.get("passwordRule"));
	   browse.pressEscKey();
   }
	
	public void passwordValidation(String oldPass, String newPass, String confirmPass, By by) {
		browse.type(employeeListLocators.get("oldPassword"), oldPass);
		browse.type(employeeListLocators.get("newPassword"), newPass);
		browse.type(employeeListLocators.get("confirmPassword"), confirmPass);
		browse.click(employeeListLocators.get("submitButton"));
		browse.assertObject(by);
		browse.refreshpage();
	}
	
	/*public void deletePlanFunctionality(){
		cancelDeleteEmployee();
		closeDeleteEmployeePopUp();
	}*/
}
