package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonActions.TestTemplate;
import pages.RecommendedPlans;

public class RecommendedPlansTest extends TestTemplate{
	RecommendedPlans recommend;
	
	@BeforeClass	
	public void beforeSuite(){
		recommend = new RecommendedPlans(browse);
		login.employerLogin();
	}
	
	@Test(priority=0)
	public void tellMeAboutPageTest(){
		recommend.tellMeAboutPage();
	}
	
	@Test(priority=1)
	public void whatCanIDoNextTest(){
		recommend.whatCanIDoNext();
	}
	
	@Test(priority=2)
	public void oopDetailsTest(){
		recommend.oopDetails();
	}
	
	@Test(priority=3)
	public void overrideHsaFsaContributionTest(){
		recommend.overrideHsaFsaContribution();
	}
	
	@Test(priority=4)
	public void customSupplementPlanPopupTest(){
		recommend.customSupplementPlanPopup();
	}
	
	@Test(priority=5)
	public void supplementPlanPdfTest(){
		recommend.supplementPlanPdf();
	}
	
	@Test(priority=6)
	public void planDetailsTest(){
		recommend.planDetails();
	}
	
    @Test(priority=7)
	public void planLiteratureTest(){
		recommend.planLiterature();
	}
	
	@Test(priority=8)
	public void findMyDoctorTest(){
		recommend.findMyDoctor();
	}
	
	@Test(priority=9)
	public void findMyRxTest(){
		recommend.findMyRx();
	}
	
	@Test(priority=10)
	public void enrollForPlanPopupTest(){
		recommend.enrollForPlanPopup();
	}
	
	@Test(priority=11)
	public void goToOopDistributionTest(){
		recommend.goToOopDistribution();
	}
	
	@Test(priority=12)
	public void goToFiveYearProjectionsTest(){
		recommend.goToFiveYearProjections();
	}
	
	@Test(priority=13)
	public void goToLifetimeProjectionsTest(){
		recommend.goToLifetimeProjections();
	}
	
	@Test(priority=14)
	public void informationLinkTest(){
		recommend.informationLink();
	}
	
	@Test(priority=15)
	public void dzeeScoreHelpTest(){
		recommend.dzeeScoreHelp();
	}
	
	@Test(priority=16)
	public void healthcareCostsHelpTest(){
		recommend.healthcareCostsHelp();
	}
	
	@Test(priority=17)
	public void hsaFsaHelpTest(){
		recommend.hsaFsaHelp();
	}
}

