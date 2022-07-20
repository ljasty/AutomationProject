package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;
import com.mystore.dataProvider.DataProviders;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
LoginPage loginpage;
IndexPage indexpage;
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
@Test(dataProvider = "credentials", dataProviderClass=DataProviders.class,groups={"Smoke","sanity"})

public void loginTest( String uname,String pswd)
{
	Log.startTestCase("loginTest");
	indexpage=new IndexPage();
	Log.info("User is going to click sign in");
	loginpage=indexpage.clickOnSignIn();
	Log.info("Enter Usename and password");
   //homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	homepage=loginpage.login(uname,pswd);
   String actualUrl =homepage.getCurrentUrl();
   String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
   Log.info("Verfying if the url");
     AssertJUnit.assertEquals(actualUrl, expectedUrl);
     Log.info("Login is Sucess");
     Log.endTestCase("LoginTest");
}
	

}
