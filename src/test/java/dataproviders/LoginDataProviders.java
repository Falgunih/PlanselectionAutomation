/**
 * 
 */
package dataproviders;

import org.testng.annotations.DataProvider;

import commonActions.TestDataFunctions;

/**
 * @author GS-0985
 *
 */
public class LoginDataProviders {

	public static String sheetName;
	static TestDataFunctions data = new TestDataFunctions();
	static String testDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\test-input.xlsx";
	
	@DataProvider(name="onlyLoginId")
		public static Object[][] onlyLoginId(){
		return data.readRow(testDataFile, sheetName, "onlyLoginId");
  }	
	
	@DataProvider(name="onlyPassword")
	public static Object[][] onlyPassword(){
		return data.readRow(testDataFile, sheetName, "onlyPassword");
  }	
	
	@DataProvider(name="invalidLoginId")
	public static Object[][] invalidLoginId(){
		return data.readRow(testDataFile, sheetName, "invalidLoginId");
  }	
	
	@DataProvider(name="invalidPassword")
	public static Object[][] invalidPassword(){
		return data.readRow(testDataFile, sheetName, "invalidPassword");
  }	

	@DataProvider(name="validLogin")
	public static Object[][] validLogin(){
		return data.readRow(testDataFile, sheetName, "validLogin");
  }	
}
