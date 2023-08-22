package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class SearchResultPage extends Base {

	@FindBy(css = ".product_img_link img")
	WebElement productImg;

	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateProductAvailability() {

		return ActionDrivers.isDisplayed(getDriver(), productImg);

	}

	public AddToCartPage clickOnProduct() {

		ActionDrivers.click(getDriver(), productImg);
		return new AddToCartPage();
	}
}
