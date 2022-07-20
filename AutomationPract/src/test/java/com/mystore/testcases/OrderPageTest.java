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
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass {

	IndexPage indexpage;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;
	

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
@Test(groups="Regression")
	 public  void addToCartPageTest() throws Exception
	{
		 indexpage=new IndexPage();	
			searchresultPage=indexpage.searchProduct("t-shirt");
			addToCartPage=searchresultPage.clickonproduct();
			addToCartPage.enterQuantity("2");
			addToCartPage.selectsize("M");
			addToCartPage.clickOnAddCart();
			orderpage=addToCartPage.clickonProcedToCheckout();
			double unitprice=orderpage.getUnitPrice();
			double totalPrice=orderpage.getTotalPrice();
			
			double totalExpectedPrice=(unitprice*2)+2;
			AssertJUnit.assertEquals(totalPrice, totalExpectedPrice);
			
			
	}
}

