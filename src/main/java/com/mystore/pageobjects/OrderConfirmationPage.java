package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class OrderConfirmationPage extends Base {

	@FindBy(xpath = "//strong[contains(text(),'complete')]")
	WebElement confirmMsg;

	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public String validateConfirmMsg() {
		String message = confirmMsg.getText();
		return message;
	}
}
