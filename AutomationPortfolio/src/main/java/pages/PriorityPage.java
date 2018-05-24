package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.ExcelUtil;
import pages.LoginPage.TestData;

public class PriorityPage {

	public static class TestData {
		public static String dataSheetName = "PriorityPage";
		public static int priorityCol = 2;
	}

	WebDriver driver;
	final String pageUrl = "https://www.rocketmortgage.com/refinance/priority";
	By radiobutton = By.xpath("//*[contains(@data-qatp,'btn')]");

	@FindBy(xpath = "//*[contains(@data-qatp,'btn')]")
	public List<WebElement> priorityOptions;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement save;

	public PriorityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ExcelUtil.readSheet(TestData.dataSheetName);
	}	
	
	public CurrentMortgage clickSave(String testValue){
		//logic to find radio matching value and click
		//List<WebElement> priorityOptions = driver.findElements(By.xpath("//*[contains(@data-qatp,'btn')]"));
		
		System.out.println("clickSave - Enter");
		int count=priorityOptions.size();
		System.out.println("countsize=" + count);
		for(int i=0;i<count;i++) {
			System.out.println("radio label = " + priorityOptions.get(i).getText());
			if(priorityOptions.get(i).getText().equalsIgnoreCase(testValue)) {
				priorityOptions.get(i).click();
			}
		}
		save.click();
		return new CurrentMortgage(driver);
	}

	public CurrentMortgage clickSave(int testDataRow) {
		System.out.println("clickSave - Enter");
		String testvalue = ExcelUtil.getValue(testDataRow, TestData.priorityCol);
		return clickSave(testvalue);
	}

	public boolean VerifyPageTitle() {
		return driver.getCurrentUrl().contentEquals(pageUrl);
	}
}
