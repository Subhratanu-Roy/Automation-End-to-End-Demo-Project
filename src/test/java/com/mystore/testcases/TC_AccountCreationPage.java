package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class TC_AccountCreationPage extends Base {

	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}

	@Test(dataProvider = "emailIDs", dataProviderClass = DataProviders.class, groups = {"Sanity"})
	public void validateCreateAccountTest(String email) {

		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignin();
		accountCreationPage = loginPage.createNewAccount(email);
		boolean res = accountCreationPage.validateFormTile();
		Assert.assertTrue(res);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
