package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class Dashboard extends BaseClass{
	
	@FindBy(xpath = "//img[@alt=\"ChannelBoost Logo\"]")
	WebElement Logo;
	@FindBy(xpath= "(//div[normalize-space()='Growth Programs'])[1]")
	WebElement GrowthPrograms;
	@FindBy(xpath="//div[text()='Affiliate Campaigns']")
	WebElement AffiliateCampaigns;
	
	
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	
	public void NavigateToCampaigns() throws InterruptedException {
		
		Actions act = new Actions(driver);
		act.moveToElement(Logo).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 300)");
//		Thread.sleep(2000);
		act.moveToElement(GrowthPrograms).click().perform();
		Thread.sleep(2000);
		act.scrollByAmount(0, 150);
		js.executeScript("window.scrollTo(0, 150)");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",AffiliateCampaigns );
		Thread.sleep(2000);
		act.moveToElement(AffiliateCampaigns).click().build().perform();

		
	}

}
