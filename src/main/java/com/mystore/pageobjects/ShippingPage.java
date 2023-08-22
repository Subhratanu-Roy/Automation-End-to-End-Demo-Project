package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class ShippingPage extends Base {

	@FindBy(id = "cgv")
	WebElement term;

	@FindBy(css = "button[name='processCarrier']")
	WebElement proceedToChkOutBtn;

	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void clickOnTerm() {
		ActionDrivers.click(getDriver(), term);
	}

	public PaymentPage clickOnProceedToCheckOut() {
		ActionDrivers.click(getDriver(), proceedToChkOutBtn);
		return new PaymentPage();

	}

}
