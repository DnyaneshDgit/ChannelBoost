package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;

	public static void Initialization() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://prm-beta.channelboost.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		ExtentSparkReporter spark = new ExtentSparkReporter("\"C:\\Users\\tntra\\eclipse-workspace\\ChannelBoost\\test-output\\extentReport.html\"");
//		ExtentReports extent = new ExtentReports();
//		extent.attachReporter(spark);

	}
	    
	
}
