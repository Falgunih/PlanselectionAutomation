package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonActions.TestTemplate;
import dataproviders.MyProfileDataProviders;

public class MyProfileTest extends TestTemplate {
	
	public MyProfileTest(){
		MyProfileDataProviders.sheetName = "myProfile";
	}
	
	@BeforeClass
	public void login(){
		login.brokerLogin();
	}

	/*@Test(priority=0) 	
	public void previousButtonFunctionality(){
		profile.previousButtonFunctionality();
	} */
	
	@Test(priority=1)
	public void emptyMyProfile(){
		profile.emptyMyProfile();
	}

	 @Test(dataProvider="onlyEmployeeId", dataProviderClass=MyProfileDataProviders.class,priority=2)
	public void onlyEmployeeId(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyEmployeeId(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	}

	@Test(dataProvider="onlyAnnualIncome", dataProviderClass=MyProfileDataProviders.class, priority=3)
	public void onlyAnnualIncome(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyAnnualIncome(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	}
		 
	@Test(dataProvider="onlyZipCode", dataProviderClass=MyProfileDataProviders.class, priority=4)
	public void onlyZipCode(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyZipCode(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	 }
	    
	@Test(dataProvider="onlyEmailId", dataProviderClass=MyProfileDataProviders.class, priority=5)
	public void onlyEmailId(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyEmailId(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	}
	    
	@Test(dataProvider="onlyPrimaryName", dataProviderClass=MyProfileDataProviders.class, priority=6)
	public void onlyPrimaryName(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyPrimaryName(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	    }
	    
	@Test(dataProvider="onlyDOB", dataProviderClass=MyProfileDataProviders.class, priority=7)
	public void onlyDOB(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyDOB(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	    }
	    
	@Test(dataProvider="onlyHealthProfile", dataProviderClass=MyProfileDataProviders.class, priority=8)
	public void onlyHealthProfile(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.onlyHealthProfile(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	    }
	    
	@Test(dataProvider="shortEnrollmentYear", dataProviderClass=MyProfileDataProviders.class, priority=9)
	public void shortEnrollmentYear(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.shortEnrollmentYear(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
		}

	@Test(dataProvider="invalidZipCode", dataProviderClass=MyProfileDataProviders.class, priority=10)
	public void invalidZipCode(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.invalidZipCode(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
		}
		
	@Test(dataProvider="invalidDOB", dataProviderClass=MyProfileDataProviders.class, priority=11)
	public void invalidDOB(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.invalidDOB(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	    }
	    
	@Test(dataProvider="invalidEmail", dataProviderClass=MyProfileDataProviders.class, priority=12)
	public void invalidEmail(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.invalidEmail(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
		}
		
	@Test(dataProvider="invalidPhoneNumber", dataProviderClass=MyProfileDataProviders.class, priority=13)
	public void invalidPhoneNumber(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.invalidPhoneNumber(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	}
		
	@Test(dataProvider="invalidPrimaryAge", dataProviderClass=MyProfileDataProviders.class, priority=14)
	public void invalidPrimaryAge(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
	profile.invalidPrimaryAge(scenario, id, year, children,  income, currentZip, number, email, primary, dob, health);
	}
	
	@Test(dataProvider="noPrivatePlan", dataProviderClass=MyProfileDataProviders.class,priority=15)
	public void noPrivatePlan(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){
		profile.noPrivatePlan(scenario, id, year, children, income, currentZip, number, email, primary, dob, health);
	}
	
	@Test(dataProvider="optForPrivatePlan", dataProviderClass=MyProfileDataProviders.class,priority=16)
	public void optForPrivatePlan(String scenario, String id, String year, String children,  String income, String currentZip, 
			String number, String email,  String primary, String dob, String health){	
		profile.optForPrivatePlan(scenario, id, year, children, income, currentZip, number, email, primary, dob, health);
	}
	
}
