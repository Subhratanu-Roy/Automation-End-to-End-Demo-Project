/**
 * 
 */
package com.mystore.pageobjects;

/**
 * @author ADMIN
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class OrderPage extends Base{
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css = "[data-title='Unit price'] span span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;

	@FindBy(xpath="//span[text()=\"Proceed to checkout\"]")
	WebElement proceedToCheckoutBtn;
	
	public Double getUnitPrice() {
		
		String up = unitPrice.getText();
		Double dbl_up = Double.parseDouble(up.substring(1));
		
		return dbl_up;
	}
	
	public Double getTotalPrice() {
		String up = totalPrice.getText();
		Double dbl_up = Double.parseDouble(up.substring(1));
		
		return dbl_up;
	}
	
	public LoginPage clickOnCheckout() {
		
		ActionDrivers.click(getDriver(), proceedToCheckoutBtn);
		return new LoginPage();
	}

	
}
