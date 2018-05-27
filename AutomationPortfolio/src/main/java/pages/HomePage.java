package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.ExcelUtil;
import junit.framework.Assert;
import pages.CurrentMortgage.TestData;

public class HomePage {
	
	WebDriver driver;
	final String EXPECTED_ADDRESS_ERROR ="Please enter the missing information.";// Constant variable is uppercase
	
	public static class TestData {
		public static String dataSheetName = "HomePage";
		public static int addressCol = 0;
		public static int address2Col = 1;
		public static int cityCol = 2;
		public static int stateCol=3;
		public static int zipcodeCol= 4;
	}
	
	@FindBy(xpath="//*[@name='address']")
    public WebElement address;
	
	@FindBy(xpath="//*[@data-qatp='address-error']/p[1]")
    public WebElement address_error;
	
	@FindBy(xpath="//*[@name='address2']")
	public WebElement address2;
	
	@FindBy (xpath ="//*[@name='city']")
	public WebElement city;
	
	@FindBy(xpath="//*[@name='state']")
	public WebElement state;
		
	@FindBy(xpath="//*[@name='zipCode']")
	public WebElement zipcode;
	
	@FindBy(xpath="//*[@type='submit']")
	public WebElement saveAndContinue;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		ExcelUtil.readSheet(TestData.dataSheetName);
	}
	
	public HomeInfoPage2 submit(int testDataRow) throws InterruptedException {
		 return submit(ExcelUtil.getValue(testDataRow, TestData.addressCol),
				ExcelUtil.getValue(testDataRow, TestData.address2Col),
				ExcelUtil.getValue(testDataRow, TestData.cityCol),
				ExcelUtil.getValue(testDataRow, TestData.stateCol),
				ExcelUtil.getValue(testDataRow, TestData.zipcodeCol));
			
	}
	
	public HomeInfoPage2 submit(String inputAddress,String inputAddress2,String inputCity,
								String inputState,String inputZipcode) {
		formEntry(inputAddress, inputAddress2, inputCity, inputState, inputZipcode);
		return new HomeInfoPage2(driver);
		
	}
	
	public void invalidSubmit(int testDataRow) throws InterruptedException {
		invalidSubmit(ExcelUtil.getValue(testDataRow, TestData.addressCol),
					ExcelUtil.getValue(testDataRow, TestData.address2Col),
					ExcelUtil.getValue(testDataRow, TestData.cityCol),
					ExcelUtil.getValue(testDataRow, TestData.stateCol),
					ExcelUtil.getValue(testDataRow, TestData.zipcodeCol));
			
	}

	
	public void invalidSubmit(String inputAddress,String inputAddress2,String inputCity,
			String inputState,String inputZipcode) 
	{
		formEntry(inputAddress, inputAddress2, inputCity, inputState, inputZipcode);		
		String actual=address_error.getText();
		System.out.println("actual = " + actual);
		Assert.assertEquals(EXPECTED_ADDRESS_ERROR, actual);		
	}

	private void formEntry(String inputAddress, String inputAddress2, String inputCity, String inputState,
			String inputZipcode) {
		clearForm();
		address.sendKeys(inputAddress);
		address2.sendKeys(inputAddress2);
		city.sendKeys(inputCity);
		Select s= new Select (state);
		s.selectByVisibleText(inputState);
		zipcode.sendKeys(inputZipcode);
		saveAndContinue.click();
	}

	private void clearForm() {
		address.clear();
		address2.clear();
		city.clear();
		zipcode.clear();
	}
	
}
