package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class PaymentPage extends Base {

	@FindBy(css = ".bankwire")
	WebElement payByBankwire;

	@FindBy(css = ".cheque")
	WebElement payByCheck;

	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderSummaryPage clickOnPayByBankWire() {

		ActionDrivers.click(getDriver(), payByBankwire);
		return new OrderSummaryPage();
	}

	public OrderSummaryPage clickOnPayByBCheck() {

		ActionDrivers.click(getDriver(), payByCheck);
		return new OrderSummaryPage();
	}
}
