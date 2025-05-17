package Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@BeforeMethod
	public void loginChannelBoost() {
		Initialization();
		lp = new LoginPage();
		test = extent.createTest("Login Test");
	}

	@Test
	public void login() throws InterruptedException, IOException {
		lp.loginToTheApplication();
		test.info("Login successful with valid credentials.");

	}

}
