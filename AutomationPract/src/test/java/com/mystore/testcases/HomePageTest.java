package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
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
	
	public void wishListTest() {
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homepage.validateMyWishList();
		AssertJUnit.assertTrue(result);
		
	}
		
	@Test(groups="Smoke")
		public void orderHistoryDetailsTest() {
			indexpage=new IndexPage();
			loginpage=indexpage.clickOnSignIn();
			homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			boolean result=homepage.validateOrderHistory();
			AssertJUnit.assertTrue(result);
		
		
	}
	

}
