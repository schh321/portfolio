package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ExcelUtil;

public class LoginPage {

	public static class TestData{
		public static String dataSheetName = "LoginPage";
		public static int userNameCol = 2;
		public static int passwordCol = 3;
	}
	
	final String pageTitle = "Rocket Account";
	
	WebDriver driver;
	
	By priorityLevel = By.xpath("/html/body/div[1]/section/div/div/header/h2");

	@FindBy(xpath=  ".//*[@name='username']")
	public WebElement username;

	@FindBy(xpath = ".//*[@ name='password']")
	public WebElement password;

	@FindBy(xpath = ".//*[@type='submit']")
	public WebElement signin;

	public LoginPage(WebDriver driver) {
		System.out.println("LoginPage() - Enter");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ExcelUtil.readSheet(TestData.dataSheetName);
		System.out.println("LoginPage() - Exit");
		
	}

	public boolean VerifyPageTitle() {
		return driver.getTitle().equalsIgnoreCase(pageTitle);
	}
	
	public PriorityPage login(int testDataRow) {
		return login(ExcelUtil.getValue(testDataRow, TestData.userNameCol), ExcelUtil.getValue(testDataRow, TestData.passwordCol));
	}

	public PriorityPage login(String inputUserName, String inputPassword) {
		System.out.println("login()");
		
		username.sendKeys(inputUserName);
		password.sendKeys(inputPassword);
		signin.click();

		/*WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(priorityLevel));*/

		return new PriorityPage(driver);

	}

}