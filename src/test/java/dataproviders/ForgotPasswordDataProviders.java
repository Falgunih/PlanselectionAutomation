package dataproviders;

import org.testng.annotations.DataProvider;

import commonActions.TestDataFunctions;

public class ForgotPasswordDataProviders {

	public static String sheetName;
	static TestDataFunctions data = new TestDataFunctions();
	static String testDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\test-input.xlsx";
	
	@DataProvider(name="invalidPasswordEmail")
	public static Object[][] invalidPasswordEmail(){
		return data.readRow(testDataFile, sheetName, "invalidPasswordEmail");
  }	
	
	@DataProvider(name="validMail")
	public static Object[][] validMail(){
		return data.readRow(testDataFile, sheetName, "validMail");
  }	
}
