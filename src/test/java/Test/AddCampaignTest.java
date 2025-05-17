package Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.AddCampaign;
import Pages.Dashboard;
import Pages.LoginPage;

public class AddCampaignTest extends BaseClass {

	LoginPage lp;
	Dashboard db;
	AddCampaign AdCamp;

	@BeforeMethod
	public void FillCampDetails() throws IOException, InterruptedException {
		Initialization();
		lp = new LoginPage();
		lp.loginToTheApplication();
		db = new Dashboard();
		db.NavigateToCampaigns();
		AdCamp = new AddCampaign();
	}

	@Test(priority = 1)
	public void FillCampDet() throws InterruptedException, IOException {
		test = extent.createTest("Add New Campaign");
		AdCamp.AddingCampaign();
		test.pass("Campaign added successfully.");
	}

	@Test(priority = 2)
	public void FailedTestCase() {
		test = extent.createTest("Negative Test - Mismatched Titles");
		AdCamp.failedTest();
		test.info("Checked assertion for mismatched campaign titles.");
	}

//	public static void tearDownExtentReport() {
//        if (extent != null) {
//            extent.flush();  // Flush report once after all tests are done
//        }
//    }

}
