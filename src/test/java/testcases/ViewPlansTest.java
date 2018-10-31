package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonActions.TestTemplate;
import pages.ViewPlansPage;

public class ViewPlansTest extends TestTemplate {

	ViewPlansPage view;
	
	@BeforeClass
	public void beforeSuit(){
		view = new ViewPlansPage(browse);
	}
	
	@Test
	public void testViewPlansTab(){
		view.employerGroupPlans();
	}
	
	@AfterClass
	public void stopViewPlansTest(){
		
	}
	
}
