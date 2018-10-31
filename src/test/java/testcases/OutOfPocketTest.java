package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commonActions.TestTemplate;
import pages.OutOfPocketPage;

public class OutOfPocketTest extends TestTemplate{

	OutOfPocketPage oop;
	
	@BeforeClass
	public void oopInstance(){
		oop = new OutOfPocketPage(browse);
		login.employeeLogin();
		oop.goToOopTab();
	}
	
	/*@BeforeTest
	public void loginAndGoToOopTab(){
		login.employeeLogin();
		oop.goToOopTab();
	}
	*/
	@Test
	public void goToRecommendedPlansTabTest(){
		oop.goToRecommendedPlansTab();
	}
	
	@Test
	public void oopDistributionGraphTest(){
		oop.oopDistributionGraph();
	}
	
	/*@Test
	public void removeSelectionFromGraphTest(){
		oop.removeSelectionFromGraph();
	}*/
	
	/*@AfterTest
	public void logoutAfterTest(){
		login.logout();
	}*/
}
