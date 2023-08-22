package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class AddressPage extends Base {

	@FindBy(xpath = "//span[text()=\"Proceed to checkout\"]")
	WebElement proceedTochkOutBtn;

	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnCheckout() {

		ActionDrivers.click(getDriver(), proceedTochkOutBtn);
		return new ShippingPage();
	}

}
