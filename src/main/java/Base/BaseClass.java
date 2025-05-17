package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setUpExtent() {
	    ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extentReport.html");
	    extent = new ExtentReports();
	    extent.attachReporter(spark);
	}

	public static void Initialization() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://prm-beta.channelboost.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

	}

	@AfterMethod
	public void tearDownReport(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE) {
	        test.fail(result.getThrowable());
	    } else if (result.getStatus() == ITestResult.SUCCESS) {
	        test.pass("Test passed");
	    } else {
	        test.skip("Test skipped: " + result.getThrowable());
	    }

	    if (driver != null) {
	        driver.quit();
	    }
	}

	@AfterSuite
	public void tearDownExtent() {
	    if (extent != null) {
	        extent.flush();
	    }
	}
	
}
