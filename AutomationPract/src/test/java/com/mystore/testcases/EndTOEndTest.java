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
import com.mystore.pageObjects.AddressPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.pageObjects.OrderConformationPage;
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.OrderSummerPage;
import com.mystore.pageObjects.PaymentPage;
import com.mystore.pageObjects.SearchResultPage;
import com.mystore.pageObjects.ShippingPage;


public class EndTOEndTest extends BaseClass {
	IndexPage indexpage;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummerPage ordersummary;
	OrderConformationPage orderConfirmationPage;

	
	
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
	
	public void endtoendTest() throws Throwable
	{
		indexpage=new IndexPage();	
		searchresultPage=indexpage.searchProduct("t-shirt");
		addToCartPage=searchresultPage.clickonproduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectsize("M");
		addToCartPage.clickOnAddCart();
		orderpage=addToCartPage.clickonProcedToCheckout();
		loginpage=orderpage.clickOnCheckOut();
		addresspage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"),addresspage);
		shippingpage=addresspage.clickOnCheckOut();
		shippingpage.checkTheTerms();
		paymentpage=shippingpage.clickOnProceedToCheckOut();
		ordersummary=paymentpage.clickOnPaymentMethod();
				
		orderConfirmationPage=ordersummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		AssertJUnit.assertEquals(actualMessage, expectedMsg);
		
	}
}
