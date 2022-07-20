package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClas;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{
@FindBy(id="quantity_wanted")
WebElement quantity;

@FindBy(id="group_1")
WebElement size;

@FindBy(xpath="//span[text()='Add to cart']")
WebElement addtoCartbtn;

@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/h2/text()")

// //*[@id="layer_cart"]//h2/i
WebElement  addToCartMessage;


@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
WebElement proceedToCheckOutBtn;

public AddToCartPage () {
	PageFactory.initElements(getDriver(), this);
}

Action action= new Action();


public void enterQuantity(String number)
{
 action.type(quantity, number)	;
}

public void selectsize(String size1) {
action.selectByVisibleText(size1, size);
}

public void clickOnAddCart() {
	action.click(getDriver(), addtoCartbtn);
	
}
     public boolean validateAddtoCart()
	{
    	 action.fluentWait(getDriver(), addToCartMessage, 15);
	return	action.isDisplayed(getDriver(), addToCartMessage);
	}
    
     public OrderPage clickonProcedToCheckout()
     {
    	 action.fluentWait(getDriver(), proceedToCheckOutBtn, 15);
    action.JSClick(getDriver(), proceedToCheckOutBtn);	
    return new OrderPage();
}
}