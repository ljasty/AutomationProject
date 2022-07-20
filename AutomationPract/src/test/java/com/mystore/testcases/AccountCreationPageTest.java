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
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass {
	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void CreateAccountPageTest() {
		Log.startTestCase("Verify CreateAccountPageTest ");
		indexpage=new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountCreationPage=loginpage.createNewAccount("abdcefqw@gmail.com");
		boolean acp=accountCreationPage.validateAccountCreatPage();
		AssertJUnit.assertTrue(acp);
		Log.endTestCase("CreateAccountPageTest");
	}

}
