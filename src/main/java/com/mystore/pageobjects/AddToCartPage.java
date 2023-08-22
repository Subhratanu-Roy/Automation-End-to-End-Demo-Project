package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class AddToCartPage extends Base {

	@FindBy(id = "quantity_wanted")
	WebElement quantity;

	@FindBy(id = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(css = "div[class*='layer_cart_product'] h2")
	WebElement addToCartMsg;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedTocheckOutBtn;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuanity(String qty) {
		ActionDrivers.type(quantity, qty);
	}

	public void selectSize(String sz) {
		ActionDrivers.selectByVisibleText(size, sz);
	}

	public void clickOnAddToCart() {
		ActionDrivers.click(getDriver(), addToCartBtn);
	}

	public boolean validateAddToCart() {
		ActionDrivers.explicitWait(getDriver(), 20, addToCartMsg);

		return ActionDrivers.isDisplayed(getDriver(), addToCartMsg);
	}

	public OrderPage clickOnProceesToCheckOut() {
		ActionDrivers.explicitWait(getDriver(), 10, proceedTocheckOutBtn);
		ActionDrivers.click(getDriver(), proceedTocheckOutBtn);
		return new OrderPage();
	}
}
