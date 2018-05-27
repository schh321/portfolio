package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pages.CurrentMortgage;
import pages.HomeInfoPage2;
import pages.HomePage;
import pages.LoginPage;
import pages.PriorityPage;


public class HomePageValidationTest extends BaseTest {
		
	@Test
	public void submitApplication() throws InterruptedException {
		System.out.println("HomePageValidation: submitApplication");
		super.initialize();
		currentMortgageObj=	priorityObj.clickSave("lower-pay-btn");
		homepageObj=currentMortgageObj.submit(testDataCurrMortRowNum);
	    homepageObj.invalidSubmit("", "4433 victory blvd ", "WoodlandHills", "California", "91367");
	    //homepageObj.invalidSubmit(1);
   }
}