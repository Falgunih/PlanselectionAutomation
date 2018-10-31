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
public class EmployerGroupManagementDataProviders {

	public static String sheetName;
	static TestDataFunctions data = new TestDataFunctions();
	static String testDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\test-input.xlsx";
	
	@DataProvider(name="onlyFieldsData")
	public static Object[][] onlyFieldsData(){
		return data.readRow(testDataFile, sheetName, "onlyFieldsData");
  }
/*	
	@DataProvider(name="onlyOrganizationName")
	public static Object[][] onlyOrganizationName(){
		return data.readRow(testDataFile, sheetName, "onlyOrganizationName");
  }
		
	@DataProvider(name="onlyEmployerAssignedName")
	public static Object[][] onlyEmployerAssignedName(){
		return data.readRow(testDataFile, sheetName, "onlyEmployerAssignedName");
	}
	
	@DataProvider(name="onlyEmployerPassword")
	public static Object[][] onlyEmployerPassword(){
		return data.readRow(testDataFile, sheetName, "onlyEmployerPassword");
	}

	@DataProvider(name="onlyEmployerEmailId")
	public static Object[][] onlyEmployerEmailId(){
		return data.readRow(testDataFile, sheetName, "onlyEmployerEmailId");
	}
	
	@DataProvider(name="onlyEmployerZipCode")
	public static Object[][] onlyEmployerZipCode(){
		return data.readRow(testDataFile, sheetName, "onlyZipCode");
	}
	*/
	
	@DataProvider(name="premiumData")
	public static Object[][] premiumData(){
		return data.readRow(testDataFile, sheetName, "premiumData");
	}
/*	
	@DataProvider(name="lowFamilyPremium")
	public static Object[][] lowFamilyPremium(){
		return data.readRow(testDataFile, sheetName, "lowFamilyPremium");
	}*/
	
	@DataProvider(name="invalidFsaHsaContribution")
	public static Object[][] invalidFsaHsaContribution(){
		return data.readRow(testDataFile, sheetName, "invalidFsaHsaContribution");
	}

	/*@DataProvider(name="invalidFamilyFSAContribution")
	public static Object[][] invalidFamilyFSAContribution(){
		return data.readRow(testDataFile, sheetName, "invalidFamilyFSAContribution");
	}
	
	@DataProvider(name="invalidSingleHSAContribution")
	public static Object[][] invalidSingleHSAContribution(){
		return data.readRow(testDataFile, sheetName, "invalidSingleHSAContribution");
	}

	@DataProvider(name="invalidFamilyHSAContribution")
	public static Object[][] invalidFamilyHSAContribution(){
		return data.readRow(testDataFile, sheetName, "invalidFamilyHSAContribution");
	}
	*/
	
	@DataProvider(name="addNewEmployer")
	public static Object[][] addNewEmployer(){
		return data.readRow(testDataFile, sheetName, "addNewEmployer");
	}
}
