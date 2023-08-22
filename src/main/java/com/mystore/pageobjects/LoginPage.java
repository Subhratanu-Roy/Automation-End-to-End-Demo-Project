package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class LoginPage extends Base {

	@FindBy(id = "email")
	WebElement username;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	@FindBy(id = "email_create")
	WebElement emailForNewAccount;

	@FindBy(id = "SubmitCreate")
	WebElement createNewAccount;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);

	}

	public HomePage login(String uname, String pwrd) {

		new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(username));
		ActionDrivers.type(username, uname);
		ActionDrivers.type(password, pwrd);
		ActionDrivers.click(getDriver(), signInBtn);
		return new HomePage();
	}
	public AddressPage login1(String uname, String pwrd) {

		ActionDrivers.type(username, uname);
		ActionDrivers.type(password, pwrd);
		ActionDrivers.click(getDriver(), signInBtn);
		return new AddressPage();
	}

	public AccountCreationPage createNewAccount(String emailID) {

		ActionDrivers.type(emailForNewAccount, emailID);
		ActionDrivers.click(getDriver(), createNewAccount);
		return new AccountCreationPage();
	}

}
