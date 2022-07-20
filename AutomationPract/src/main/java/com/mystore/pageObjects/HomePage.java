package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy (xpath="//span[text()='Order history and details']")
	WebElement Orderhistory;
	
	Action action=new Action();
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean validateMyWishList() {
	 return	action.isDisplayed(getDriver(), myWishList);
	}

	public boolean validateOrderHistory() {
		return action.isDisplayed(getDriver(), Orderhistory);
	}
	
	public String getCurrentUrl()
	{
	String homepageUrl=	getDriver().getCurrentUrl();
	return homepageUrl;
	}
}
