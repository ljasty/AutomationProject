package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;

public class OrderConformationPage extends BaseClass{
Action action= new Action();
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;
	
	public OrderConformationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}

}
