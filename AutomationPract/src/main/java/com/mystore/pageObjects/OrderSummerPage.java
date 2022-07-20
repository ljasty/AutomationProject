package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;


public class OrderSummerPage  extends BaseClass{
	
Action action= new Action();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummerPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConformationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(getDriver(), confirmOrderBtn);
		return new OrderConformationPage();
	}
	

}
