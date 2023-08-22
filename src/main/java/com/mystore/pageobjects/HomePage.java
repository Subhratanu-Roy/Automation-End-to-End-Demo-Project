package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class HomePage extends Base {

	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;

	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement wishlist;

	public HomePage() {

		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateOrderHistory() {
		return ActionDrivers.isDisplayed(getDriver(), orderHistory);
	}

	public boolean validateWishList() {
		return ActionDrivers.isDisplayed(getDriver(), wishlist);
	}
	
	public String getCurrentUrl() {
		String currUrl = getDriver().getCurrentUrl();
		return currUrl;
	}
	
	

}
