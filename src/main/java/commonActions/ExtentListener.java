/*package commonActions;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentListener implements IResultListener {

    private ExtentReports reporter =  new ExtentReports(System.getProperty("user.dir")+"\\Report\\RegressionReport.html", true, DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE);
    private ExtentTest testReporter;

    @Override
    public void onTestStart(ITestResult result) {
        testReporter = reporter
        		   .startTest(result.getMethod().getMethodName(), "Some description")
                   .assignAuthor("Mayuri Wavhal")
        	       .assignCategory("Regression", "Functional");
        testReporter.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testReporter.log(LogStatus.PASS, "Test PASSED");
        reporter.endTest(testReporter);
        reporter.flush();
    }

    @Override
    public void onFinish(ITestContext context) {
        reporter.close();
    }

	@Override
	public void onTestFailure(ITestResult result) {
		  testReporter.log(LogStatus.INFO, result.getThrowable());
		  testReporter.log(LogStatus.FAIL, "Test FAILED");
	        reporter.endTest(testReporter);
	        reporter.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
}
*/