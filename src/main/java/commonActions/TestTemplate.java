package commonActions;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import pages.AssignPlansPage;
import pages.DummyPage;
import pages.EmployerGroupManagementPage;
import pages.ForgotPasswordPage;
import pages.HCBLogin;
import pages.MyProfilePage;


public class TestTemplate extends ExtentReportsUtility{
	protected BrowserActions browse;
	protected HCBLogin login;
	protected ForgotPasswordPage fpwd;
	protected EmployerGroupManagementPage emp;
	protected MyProfilePage profile;
	protected AssignPlansPage assign;
	protected DummyPage dummy;
	protected TestDataProvider testData;
	protected TestDataFunctions data;
	public ITestResult result;
	
	/** This method runs pre-requisites for test case execution. 
	 */
	@BeforeClass
	public void beforeClass() {
		browse = new BrowserActions();
		testData = new TestDataProvider();
		data = new TestDataFunctions();
		Properties config = data.getPropertiesFileData();
 		login = new HCBLogin(browse);
 		fpwd = new ForgotPasswordPage(browse);
 		emp = new EmployerGroupManagementPage(browse);
 		profile = new MyProfilePage(browse);
 		dummy = new DummyPage(browse);
 		assign = new AssignPlansPage(browse);
 		browse.openBrowserInstance();
 		browse.goToUrl(config.getProperty("environment"));	
}

	@BeforeMethod
	public void getCurrentTestMethodName(Method method){
		Log.info("----------------Starting test case: " +method.getName()+" ----------------------------------------");
	}

	@AfterMethod
	public void endTestCase(Method method){
		Log.info("-------------------------------- Ended " +method.getName()+" test case ---------------------------");
	}
	//@AfterClass
	@AfterTest
	 public void stopTest(){
		browse.quitDriver();
	 }
	 }