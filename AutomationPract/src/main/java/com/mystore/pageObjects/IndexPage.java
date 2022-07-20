package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	
	public IndexPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	Action action= new Action();
	
	public LoginPage clickOnSignIn()
	{   action.fluentWait(getDriver(), signInBtn, 15);
	 	action.click(getDriver(), signInBtn);
	 	return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
	String myStoreTitle=getDriver().getTitle();
	return myStoreTitle;
	}

	public SearchResultPage searchProduct(String product)
	
	{
		action.type(searchProductBox, product);
		action.click(getDriver(),searchBtn);
		return new SearchResultPage();
		
	}
}
