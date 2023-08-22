package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class IndexPage extends Base {

	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(id = "search_query_top")
	WebElement searchProductBox;

	@FindBy(name = "submit_search")
	WebElement searchBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;

	public IndexPage() {

		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignin() {

		new WebDriverWait(getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(signInBtn));
		ActionDrivers.click(getDriver(), signInBtn);
		return new LoginPage();

	}

	public boolean validateLogo() {
		return ActionDrivers.isDisplayed(getDriver(), logo);
	}

	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();

		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) {

		ActionDrivers.type(searchProductBox, productName);
		ActionDrivers.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}

}
