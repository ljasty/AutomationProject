package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;


public class LoginPage extends BaseClass{
    
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement  signin;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy (id="SubmitCreate")
	WebElement CreateNewAccountBtn;
	
	Action action=new Action();
	public LoginPage()
	{
		PageFactory.initElements(getDriver(),this);
	}
	
	public HomePage login(String uname,String pswd) {
		action.type(userName,uname);
		action.type(password, pswd);
		action.click(getDriver(), signin);
		return new HomePage();
	}
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(getDriver(), signin);
		Thread.sleep(1000);

		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		action.type(emailForNewAccount, newEmail);
		action.click(getDriver(), CreateNewAccountBtn);
		return new AccountCreationPage();
	}
}
