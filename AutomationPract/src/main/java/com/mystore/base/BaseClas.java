package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClas {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeTest
	public void loadConfig()
	{
		try
		{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("//Users/lakshmi/eclipse-workspace/AutomationPract/Configuration/config.properties");
		prop.load(fis);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		}catch(IOException e) {
		e.printStackTrace();
		}
	}
	
	public static void launchApp()
	{
		
	/*	String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			  WebDriverManager.chromiumdriver().setup();
			  driver= new ChromeDriver();
			
		       }else if(browserName.equals("firefox")) {
					  WebDriverManager.firefoxdriver().setup();
					  driver= new FirefoxDriver();
	  }
		driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	    //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	     
	     // driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
		  // driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
	     
		  
		   driver.get(prop.getProperty("url"));
	
	     
	} */
		{
			
			String browserName=prop.getProperty("browser");
			if(browserName.equals("chrome")) {
				  WebDriverManager.chromiumdriver().setup();
				  driver= new ChromeDriver();
				
			       }else if(browserName.equals("firefox")) {
						  WebDriverManager.firefoxdriver().setup();
						  driver= new FirefoxDriver();
		  }
			driver.manage().window().maximize();
		     driver.manage().deleteAllCookies();
		    //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		    //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		     
		     // driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), TimeUnit.SECONDS);
			  // driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
		     
		     
		   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  
			   driver.get(prop.getProperty("url"));
		
		     
		}
		
	}
}



