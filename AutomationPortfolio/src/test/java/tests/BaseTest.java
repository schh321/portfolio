package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CurrentMortgage;
import pages.HomeInfoPage2;
import pages.HomePage;
import pages.LoginPage;
import pages.PriorityPage;

public class BaseTest {
	
	WebDriver driver;
	
	int testDataLoginRowNum = 1;
	int testDataPriorityNum = 1;
	int testDataCurrMortRowNum = 3;
	int testDataHomePageRowNum = 1;
	PriorityPage priorityObj;
	CurrentMortgage  currentMortgageObj;
	HomePage homepageObj;
	HomeInfoPage2 homeInfoPage2obj ;
  
	public BaseTest() {
		super();
	}

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://rocketaccount.com/#/sign-in");
	}
	
	public void Login(){
		
		System.out.println("Login():");
		LoginPage lp = new LoginPage(driver);
		
		priorityObj = lp.login(testDataLoginRowNum);
		System.out.println("Login():end");

	}
	
	public void initialize() {
		launchBrowser();
		Login();
		
	}
	
	public void close() {
		driver.close();
	}
	
}