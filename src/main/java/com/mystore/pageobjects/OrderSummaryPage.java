package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class OrderSummaryPage extends Base{

	@FindBy(xpath="//span[contains(text(),'confirm')]")
	WebElement confirmBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		ActionDrivers.click(getDriver(), confirmBtn);
		return new OrderConfirmationPage();
	}
}
