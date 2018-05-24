package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ExcelUtil;

public class CurrentMortgage {
	WebDriver driver;
	
	public static class TestData {
		public static String dataSheetName = "CurrentMortgage";
		public static int cashTakeOutCol = 2;
		public static int currMortPymtCol = 3;
		public static int propTaxOrInsCol = 4;
		public static int currentPaymentCol=5;
		public static int homeValueCol= 6;
		public static int currentZipcodeCol=7;
		public static int vaEligibleCol=8;
		public static int currVACol=9;
		public static int everVACol=10;
		
	}
	
	@FindBy(xpath = "//*[contains(@data-qatp,'cash-out-input')]")
	public WebElement cashOut;
	
	@FindBy(xpath = "//*[contains(@data-qatp,'curr-mtg-pay-input')]")
	public WebElement currMortPymt;

	@FindBy(xpath = "//*[contains(@data-qatp,'tax-ins-incl')]")
	public List<WebElement> propTaxOrIns;

	@FindBy(xpath = "//*[contains(@data-qatp,'curr-mtg-bal-input')]")
	public WebElement currentPayment;

	@FindBy(xpath = "//*[contains(@data-qatp,'home-value-input')]")
	public WebElement homeValue;

	@FindBy(xpath = "//*[contains(@data-qatp,'current-zipcode-input')]")
	public WebElement currentZipcode;

	@FindBy(xpath = "//*[contains(@data-qatp,'vaeligible')]")
	public List<WebElement> vaEligible;

	@FindBy(xpath = "//*[contains(@data-qatp,'currVA')]")
	public List<WebElement> currVA;

	@FindBy(xpath = "//*[contains(@data-qatp,'everVA')]")
	public List<WebElement> everVA;

	@FindBy(xpath = "//*[@type='submit']")
	public WebElement saveContinue;
	

	public CurrentMortgage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		ExcelUtil.readSheet(TestData.dataSheetName);
	}

	private void clearForm() {
		cashOut.clear();
		currMortPymt.clear();
		currentPayment.clear();
		homeValue.clear();
		currentZipcode.clear();
	}

	public HomePage submit(int testDataRow) throws InterruptedException {
		return submit(ExcelUtil.getValue(testDataRow, TestData.cashTakeOutCol),
				ExcelUtil.getValue(testDataRow, TestData.currMortPymtCol),
				ExcelUtil.getValue(testDataRow, TestData.propTaxOrInsCol),
				ExcelUtil.getValue(testDataRow, TestData.currentPaymentCol),
				ExcelUtil.getValue(testDataRow, TestData.homeValueCol),
				ExcelUtil.getValue(testDataRow, TestData.currentZipcodeCol),
				ExcelUtil.getValue(testDataRow, TestData.vaEligibleCol),
				ExcelUtil.getValue(testDataRow, TestData.currVACol),
				ExcelUtil.getValue(testDataRow, TestData.everVACol));
	}
	
	
	public HomePage submit(String cashOutVal, String currMortPymtVal, String propTaxOrInsVal,
			String currentPaymentVal, String homeValueVal, String currentZipcodeVal, String vaEligibleVal,
			String currVAVal, String everVAVal ) throws InterruptedException 
	{
		clearForm();  //clears form else data keeps appending in each textbox
		cashOut.sendKeys(cashOutVal);
		currMortPymt.sendKeys(currMortPymtVal);
		
		radioSelection(propTaxOrIns, propTaxOrInsVal);
		
		currentPayment.sendKeys(currentPaymentVal);
		homeValue.sendKeys(homeValueVal);
		currentZipcode.sendKeys(currentZipcodeVal);
				
		radioSelection(vaEligible, vaEligibleVal);
		
		if (vaEligibleVal.equalsIgnoreCase("YES")) {
			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfAllElements(currVA)); 
			radioSelection(currVA, currVAVal);
				if(currVAVal.equalsIgnoreCase("No")) {
					wait.until(ExpectedConditions.visibilityOfAllElements(everVA)); 
					radioSelection(everVA, everVAVal);
				}
			
		}
		saveContinue.click();
		return new HomePage(driver);
	}

	
	
	public void radioSelection(List<WebElement> radio, String testData) {		
		int radioCount= radio.size();
		for(int i=0;i<radioCount;i++) {
			String radioText= radio.get(i).getText();
			System.out.println("radio label = " + radio.get(i).getText());
			if(radioText.equalsIgnoreCase(testData)) {
				radio.get(i).click();
			}
		}

	}
	
	//code for this functional validation
	//What is your current mortgage balance?
	//Please enter a loan amount up to $3,000,000.

}
