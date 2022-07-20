package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
			
	WebElement productResult;

	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	Action action= new Action();
	public boolean isproductAvalible() {
		return action.isDisplayed(getDriver(), productResult);
	}
	public AddToCartPage clickonproduct()
	{
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
