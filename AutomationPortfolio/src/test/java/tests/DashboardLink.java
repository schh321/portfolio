package tests;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DashboardLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		/*driver.get("https://www.ebay.com/");
		WebElement footer = driver.findElement(By.xpath(".//*[@id=\'glbfooter']"));
		int countFooter = footer.findElements(By.tagName("a")).size();
		System.out.println(countFooter);

		WebElement buy = driver.findElement(By.linkText("Buy"));

		List<WebElement> list = buy.findElements(By.tagName("a"));
		int countBuy = list.size();
		for (int i = 0; i < countBuy; i++) {
			System.out.print(list.get(i).getText());
		}
		WebElement about = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[4]/ul"));
		List<WebElement> count = about.findElements(By.tagName("a"));
		for (int i = 0; i < count.size(); i++) {
			System.out.println(count.get(i).getText());
			if (count.get(i).getText().contains("Policies")){
				count.get(i).click();*/
				
		
		driver.get("https://www.facebook.com/");
	WebElement femaleButton=driver.findElement(By.xpath(".//*[@id='u_0_9']"));
	
		boolean status= femaleButton .isDisplayed();
		System.out.println("Male radio button is Displayed >>"+status);
		boolean status1=femaleButton.isSelected();
		System.out.println("femal button is selected "+ status1);
		femaleButton.click();
		boolean status2=femaleButton.isSelected();
		System.out.println("femal button is selected "+ status2);
		WebElement malebutton= driver.findElement(By.xpath(".//*[@id='u_0_a']"));
		boolean status4= malebutton.isEnabled();
		System.out.println("male button is enabled "+ status4);
		
		/*
		
		String expectedVal = "";
		List<WebElement> links = driver.findElements("ammmm");
		Set<String> windows = null;
		String mainHandle = driver.getWindowHandle();
		for(int i=0; i<links.size();i++)
		{
			WebElement li = links.get(i);
			li.click();
			if(li.getText().equals("Java")) {
				expectedVal = "Java value for Beginners";
			}
			if(li.getText().equals("SQL")) {
				expectedVal = "Java value for Beginners";
			}if(li.getText().equals("Perl")) {
				expectedVal = "Java value for Beginners";
			}if(li.getText().equals("Link")) {
				expectedVal = "Java value for Beginners";
			}
			windows = driver.getWindowHandles();
			for(int j=0; j<windows.size();j++) {
				if (windows.get(j). not equals mainhandle) {
					driver.switchTo(child);
					WebElement actual = driver.findElement("tile xpath");
					if(actual.getAttribute("value").contentEquals(expectedVal)) {
						///this means ur link worked.... else print link broken....
					}
					driver.close();
						
				}
			}
			
			
			
			//
			List<WebElement> links = driver.findElements("ammmm");
			for(int i=0; i<links.size();i++)
			{
				String url = links.get(i).getAttribute("href");
				URL x =new URL(url);
				HttpURLConnection  siteurl = (HttpURLConnection) x.openConnection();
				siteurl.connect();
				if (siteurl.getResponseCode() >= 400) {
					""site link broken"
				}
			}
			*/
		}
		

	}

