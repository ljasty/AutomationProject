package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;


public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//td[@class='cart_unit']")
		//	+ "/span/span")
	//td[@class='cart_unit']
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public OrderPage () {
		PageFactory.initElements(getDriver(), this);
	}

	Action action= new Action();
	
	public double getUnitPrice() {
	
	String unitPrice1=	unitPrice.getText();
	String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
	double finalUnitPrice=Double.parseDouble(unit);
	return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	public LoginPage clickOnCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		action.fluentWait(getDriver(), proceedToCheckOut, 20);
		return new LoginPage();
	}
	

}
