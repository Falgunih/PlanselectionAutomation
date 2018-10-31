/**
 * 
 */
package pages;
import java.util.HashMap;
import org.openqa.selenium.By;
import commonActions.BrowserActions;
import commonActions.ObjectMap;
import commonActions.PageTemplate;
import commonActions.TestDataFunctions;

/**
 * @author GS-0985
 *
 */

public class AssignPlansPage extends PageTemplate {
	
	//BrowserActions browse;
	//ObjectMap objMap;
    //TestDataFunctions data = new TestDataFunctions();
   // HashMap<String, By> assignPlansLocators = new HashMap<String, By>() ;
    static String assignPlansLocatorsPath = System.getProperty("user.dir")+"\\src\\main\\java\\objectRepository\\AssignPlansPage.properties";
	
    public AssignPlansPage(BrowserActions b){
    	super(b, assignPlansLocatorsPath ); 
    }
    
  /*  public void assignPlansLocators(){
    	assignPlansLocators = objMap.getLocator();
    }
    */
    public void goToAssignPlansTab(){
    	System.out.println(pageLocators.get("assignPlansTab"));
    	//browse.threadSleepWait(5000);
    	browse.click(pageLocators.get("assignPlansTab"));
    	browse.threadSleepWait(3000);
    }
    
	public void assignHealthcarePlansToEmpGrp(String employer){
		goToAssignPlansTab();
		browse.selectJcfDropdownValue(pageLocators.get("selectEmployer"), employer);
		assignPlans();
	} 
	
	public void assignSupplementPlansToEmpGrp(){
		assignPlans();
	}
	
	public void assignPlans() {
		browse.click(pageLocators.get("selectAllPlans"));
		browse.click(pageLocators.get("clickToAssign"));
		browse.assertObject(pageLocators.get("planAssignmentMessage"));
		browse.threadSleepWait(2000);
		browse.pressEscKey();
	}
	
}
