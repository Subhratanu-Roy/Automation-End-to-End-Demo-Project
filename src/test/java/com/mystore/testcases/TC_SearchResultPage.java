package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class TC_SearchResultPage extends Base {
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}

	@Test(groups = {"Smoke"}, dataProvider = "productname", dataProviderClass = DataProviders.class)
	public void validateProductAvailability(String productname) {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productname);

		boolean res = searchResultPage.validateProductAvailability();
		Assert.assertTrue(res);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
