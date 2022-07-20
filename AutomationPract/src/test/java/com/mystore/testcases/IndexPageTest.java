package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;
import com.mystore.pageObjects.IndexPage;

public class IndexPageTest extends BaseClass{
	IndexPage indexpage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(groups="Smoke")
	
	public void verifyLogo ()throws Throwable{
	    indexpage=new IndexPage();
		boolean result=indexpage.validateLogo();
		AssertJUnit.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		
		String actualTitle=indexpage.getMyStoreTitle();
		AssertJUnit.assertEquals(actualTitle, "My Store");
	}
	
	
	
	

}
