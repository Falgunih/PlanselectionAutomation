package commonActions;

import org.testng.annotations.DataProvider;

public class TestDataProvider extends  TestDataFunctions{
	public static String sheetName;
	static TestDataFunctions data = new TestDataFunctions();
	static String testDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\test-input.xlsx";
	
	
	@DataProvider(name="noPrivatePlan")
	public static Object[][] noPrivatePlan(){
		return data.readRow(testDataFile, sheetName, "noPrivatePlan");
  }	

	@DataProvider(name="optForPrivatePlan")
	public static Object[][] optForPrivatePlan(){
		return data.readRow(testDataFile, sheetName, "optForPrivatePlan");
  }	
	
	@DataProvider(name="benefitConsumptions")
	public static Object[][] benefitConsumptions(){
		return data.readAllExcel(testDataFile, sheetName);
  }	
	
	@DataProvider(name="incorrectOldPassword")
	public static Object[][] incorrectOldPassword(){
		return data.readRow(testDataFile, sheetName, "incorrectOldPassword");
  }	
	
	@DataProvider(name="incorrectNewPassword")
	public static Object[][] incorrectNewPassword(){
		return data.readRow(testDataFile, sheetName, "incorrectNewPassword");
  }	
	
	@DataProvider(name="incorrectConfirmPassword")
	public static Object[][] incorrectConfirmPassword(){
		return data.readRow(testDataFile, sheetName, "incorrectConfirmPassword");
  }	
	
	@DataProvider(name="changePassword")
	public static Object[][] changePassword(){
		return data.readRow(testDataFile, sheetName, "changePassword");
  }
}
