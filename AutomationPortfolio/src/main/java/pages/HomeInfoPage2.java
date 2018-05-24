package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.ExcelUtil;
import pages.HomePage.TestData;

public class HomeInfoPage2 {
  
	WebDriver driver;

  
  public HomeInfoPage2(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		ExcelUtil.readSheet(TestData.dataSheetName);
	}
 


}

