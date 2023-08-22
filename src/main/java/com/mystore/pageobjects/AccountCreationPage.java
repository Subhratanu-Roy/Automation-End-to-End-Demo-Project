package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class AccountCreationPage extends Base {

	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	public AccountCreationPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	public boolean validateFormTile() {
		
		return ActionDrivers.isDisplayed(getDriver(), formTitle);
		
	}
	
	
}
