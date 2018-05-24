package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pratice1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    //driver.get("https://www.amazon.com/Luciana-American-Girl-Year-2018/dp/1338186485");
		// driver.findElement(By.xpath(ByxpathExpression))
		/* driver.findElement(By.xpath("//*[@name='username']")).sendKeys("suman_libra80@yahoo.com");
	   	driver.findElement(By.xpath("//*[@name='password']")).sendKeys("test1234");
	   	driver.findElement(By.xpath("//*[type='submit']")).click();*/
		/* Select select= new Select(driver.findElement(By.xpath("//*[@name='birthday_month']")));
	    //select.selectByIndex(3);
	    select.deselectByVisibleText("Oct");*/
	    
		/*WebElement moveToElement= driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]"));;
	     Actions act = new Actions(driver);
	     act.moveToElement(moveToElement).build().perform()*/
	    
		// driver.get("https://www.rocketmortgage.com/?logout=timeout");
		/* WebElement element = driver.findElement(By.xpath("//*[@name='email']"));
	    Actions act= new Actions(driver);
	    act.moveToElement(element).doubleClick().build().perform();*/
		/* TakesScreenshot ts= ((TakesScreenshot )driver);
	    File source =ts.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(source,new File(".//ScreenShot"));
	    System.out.println("source");*/
	        
    
	    //@parameters("browser")
	    /* public void setUp (String browser) {
	    	if (browser.equalsIgnoreCase("firefox")) {
	    		driver= new FirefoxDriver();
	    	}
	    	else if(browser.equalsIgnoreCase("chrome")){
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
	    	driver= new ChromeDriver();
	    	}
	    	else if (browser.equalsIgnoreCase("edge")) {
	    		System.setProperty("webdriver.chrome.driver","C:\\Users\\NikhilAditi\\.m2\\chromedriver.exe");
	    		driver= new EdgeDriver();
	    		}
	    	else {
	    		System.out.println("browser is not correct");
	    	}
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	}*/
    
	    //Arraylist
		// ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
	    
		/* List<String> obj = new ArrayList<String>();
	    	obj.add("suman");
	    	obj.add("poddar");
	   	// System.out.println(obj);
	    for(int i=0;i<obj.size();i++) {
	    	System.out.println(obj.get(i));
	    }
	    obj.remove(0);
	    System.out.println("obj:"+obj.size());*/
	    
	    
		/*List<Integer> list1 = new ArrayList<Integer>();
	    list1.add(3);
	    list1.add(7);
	    System.out.println(list1.size());
	    for(int i=0;i<list1.size();i++) {
	    	System.out.println(list1.get(i));
	    }*/
	    //fibnoc stories---
    
		int fib1=0;
	    int fib2=1;
	    int fib3;
	    System.out.println(fib1);
	    System.out.println(fib2);
	    for(int i=0;i<8;i++) {
	     fib3=fib2+fib2;
	     System.out.println(fib3);
	    fib1=fib2;
	    fib2=fib3;
	    }
	    //even or add'
	  /*Scanner sc= new Scanner(System.in);
	    	int i = sc.nextInt();
	   for (int x=0;x<i;x++) {
		   System.out.println(x);
	   }
		if (i==0) {
			 System.out.println(i+" is even number");
		   }
			   else {
				   System.out.println(i +" is odd number");
			   }
		   
	   }*/
	      int i=9;
	      for(int x=0;x<i;x++) {
	    	  System.out.println(x);
	    	 }
	      if (i%2==0) {
	    	  System.out.println(i+" is even number");
	      }
	      else {
	    	  System.out.println(i+" is odd number");
	      }
	      
	      
	     // factorial
	  	Scanner sc = new Scanner (System.in);
		System.out.println("Enter a number...");
		int x = sc.nextInt();
	
		i=5;
		System.out.println("++i = " + ++i);
		
		i=5;
		System.out.println("i++ = " + i++);
		
		/*
		int fact = 1;
		for (int a = 1; a < x; ++ a)
			fact = fact * a;
		
	
		}*/
	}	
}
