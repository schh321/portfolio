package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
      System.setProperty("webdriver.chrome.driver", "C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
      String parent=driver.getWindowHandle();
      driver.findElement(By.xpath("//*[@id=\'button1\']")).click();
      Set<String> handles= driver.getWindowHandles();
      System.out.println(handles);
      for(String  handle1:handles) {
    	  driver.switchTo().window(handle1);
    	}
      driver.close();
      driver.quit();
    		  
    }
      
      
      
      
	}


