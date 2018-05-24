package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

public class VerifyLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		String actual="https://www.ebay.com/sch/ebayadvsearch";
		String s=driver.getTitle();
	
		System.out.println(driver.findElements(By.tagName("a")).size());
		for(int i=0;i<a*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver(); 
		    driver.manage().window().maximize();
		    //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		    int size = driver.findElements(By.tagName("iframe")).size();

		    for(int i=0; i<=size; i++){
			driver.switchTo().frame(i);
			int total=driver.findElements(By.xpath("html/body/a/img")).size();
			System.out.println(total);
		    driver.switchTo().defaultContent();
		
		
		
	}
	}
}


