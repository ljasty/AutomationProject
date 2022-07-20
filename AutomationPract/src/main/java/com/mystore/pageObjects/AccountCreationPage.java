package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
public	AccountCreationPage ()
{
	PageFactory.initElements(getDriver(), this);;
}
Action action= new Action();

public boolean validateAccountCreatPage()
{
	return action.isDisplayed(getDriver(), formTitle);
}

}
