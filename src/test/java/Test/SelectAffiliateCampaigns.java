package Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.Dashboard;
import Pages.LoginPage;

public class SelectAffiliateCampaigns extends BaseClass{
	
	LoginPage lp;
	Dashboard db;
	
	@BeforeMethod
	public void SelectAffiliateCampaigns() throws IOException {
		Initialization();
		lp = new LoginPage();
		lp.loginToTheApplication();
		db = new Dashboard();
	}
	@Test
	public void navigateCapaigns() throws InterruptedException {
		db.NavigateToCampaigns();
	}

}

