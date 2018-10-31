package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonActions.TestDataProvider;
import commonActions.TestTemplate;
import pages.BenefitConsumptionsPage;
import pages.RecommendedPlans;

public class BenefitConsumptionsTest extends TestTemplate {
	BenefitConsumptionsPage benefit;
	RecommendedPlans recommend;
	
	public BenefitConsumptionsTest(){
		TestDataProvider.sheetName="consumptions";
	}
	
	@BeforeClass
	public void createInstance(){
		recommend = new RecommendedPlans(browse);
		benefit = new BenefitConsumptionsPage(browse);
		login.employerLogin();
		recommend.goToFirstEmployeeProfile();
		benefit.goToBenefitConsumptionsTab();
	}
	
	@Test(priority=0, dataProvider = "benefitConsumptions", dataProviderClass=TestDataProvider.class)
	public void changeBenefitConsumptionsTest(String doctorVisits, String drugPrescriptions, String hospitalIn, String hospitalOut, String labsAndEquipments){
		benefit.changeBenefitConsumptions(doctorVisits, drugPrescriptions, hospitalIn, hospitalOut, labsAndEquipments);
	}
	
	@Test(priority=1)
	public void recalculateConsumptionPopupTest(){
		benefit.recalculateConsumptionPopup();
	}
	
	@Test(priority=2)
	public void verifyResetBenefitValueTest(){
		benefit.verifyResetBenefitValue();
	}

   }
