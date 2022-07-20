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
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.SearchResultPage;

public class AddtoCartPageTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
@Test(groups= {"Sanity","Regression"})
	 public  void addToCartPageTest()
	{
		 indexpage=new IndexPage();	
			searchresultPage=indexpage.searchProduct("t-shirt");
			addToCartPage=searchresultPage.clickonproduct();
			addToCartPage.enterQuantity("2");
			addToCartPage.selectsize("M");
			addToCartPage.clickOnAddCart();
			boolean result=addToCartPage.validateAddtoCart();
			AssertJUnit.assertTrue(result);
			
			
	}
}
