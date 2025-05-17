package Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.BaseClass;

public class AddCampaign extends BaseClass{
	@FindBy(id="add-campaign-create-button")
	WebElement AddCampaignBtn;
	@FindBy(xpath="//input[@name='Campaign Title']")
	WebElement CampaignTitle;
	@FindBy(xpath="//div[@class=\"css-n1qm7a\"]")
	WebElement StartDate;
	@FindBy(xpath="//button[text()=\"29\"]")
	WebElement SelDate;
	@FindBy(xpath="(//div[@class=\" css-1xc3v61-indicatorContainer\"])[1]")
	WebElement Reward;
	@FindBy(xpath="(//div[@class=\" css-1xc3v61-indicatorContainer\"])[2]")
	WebElement PartnerProgram;
	@FindBy(xpath="(//div[@class=\" css-1xc3v61-indicatorContainer\"])[3]")
	WebElement PartnerType;
	@FindBy(xpath="(//div[@class=\" css-1xc3v61-indicatorContainer\"])[6]")
	WebElement Partner;
	@FindBy(xpath="//input[@name=\"Goal Title\"]")
	WebElement GoalTitle;
	@FindBy(xpath="(//div[@class=\" css-1xc3v61-indicatorContainer\"])[10]")
	WebElement Actions;
	@FindBy(xpath="//input[@name=\"Destination Link to Track\"]")
	WebElement desLink;
	@FindBy(xpath="//button[@title=\"Save\"]")
	WebElement save;
	@FindBy(xpath="//button[@title=\"Go live\"]")
	WebElement GoLive;
	@FindBy(xpath="(//p[@class=\"chakra-text css-nt2msz\"])[1]")
	WebElement formTitle;
	@FindBy(xpath="(//p[@class=\"chakra-text css-nt2msz\"])[2]")
	WebElement formTitle2;
	
	
	public AddCampaign() {
		PageFactory.initElements(driver, this);
	}
	
	public void AddingCampaign() throws IOException, InterruptedException {
		AddCampaignBtn.isDisplayed();
		AddCampaignBtn.click();
		CampaignTitle.isDisplayed();
		FileInputStream file = new FileInputStream("C:\\Document\\Test Data.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		String campTitle = workbook.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
		CampaignTitle.sendKeys(campTitle);
		StartDate.click();
		SelDate.click();
		Reward.click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		PartnerProgram.click();
		act.sendKeys(Keys.ENTER).perform();
		PartnerType.click();
		act.sendKeys(Keys.ENTER).perform();
		Partner.click();
		act.sendKeys(Keys.ENTER).perform();
		String GoalTi = workbook.getSheet("sheet1").getRow(1).getCell(3).getStringCellValue();
		GoalTitle.sendKeys(GoalTi);
		Actions.click();
		act.sendKeys(Keys.ENTER).perform();
		String DesL = workbook.getSheet("sheet1").getRow(1).getCell(4).getStringCellValue();
		desLink.sendKeys(DesL);
		save.click();
		Thread.sleep(3000);
	}
	
	public void failedTest() {
		AddCampaignBtn.click();
		String ActTitle = formTitle.getText();
		String ExpTitle = formTitle2.getText();
		Assert.assertEquals(ActTitle, ExpTitle);
	
	
	}
	
	
	
	

}
