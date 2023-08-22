package com.mystore.testcases;


import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Base;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utilities.Log;

public class TC_IndexPage extends Base {

	IndexPage indexPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
	}

	@Test(groups = { "Smoke" })
	public void validateLogo() {
		log.startTest("Validate logo");
		indexPage = new IndexPage();
		log.info("Index page is opened");
		Boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		log.info("Test pass");
		log.endTest("Validate logo");

	}

	@Test(groups = { "Smoke" })
	public void validateTitle() {
		log.startTest("Validate title");
		indexPage = new IndexPage();
		String expTitle = "My Store";
		log.info("Index page is opened");
		String actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(expTitle, actTitle);
		log.info("Test pass");
		log.endTest("Validate title");
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

}
