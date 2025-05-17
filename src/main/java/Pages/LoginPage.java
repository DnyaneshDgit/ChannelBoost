package Pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement Email;
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Pass;
	@FindBy(xpath = "//button[@title=\"Login\"]")
	WebElement Login;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginToTheApplication() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Document\\Test Data.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		String mail = workbook.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
		Email.sendKeys(mail);
		String password = workbook.getSheet("sheet1").getRow(1).getCell(1).getStringCellValue();
		Pass.sendKeys(password);
		Login.click();

	}

}
