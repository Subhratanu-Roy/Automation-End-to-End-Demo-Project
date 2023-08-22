package com.mystore.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class TC_EndToEnd2_CrossBrowserTest extends Base {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	@Parameters("browser")
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@Test(groups = {"Regression"},dataProvider = "orderdetails", dataProviderClass = DataProviders.class )
	public void endToEndTest(String productName, String size, String qty, String x) {

		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuanity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceesToCheckOut();
		loginPage = orderPage.clickOnCheckout();
		addressPage = loginPage.login1(uname, pword);
		shippingPage = addressPage.clickOnCheckout();
		shippingPage.clickOnTerm();
		paymentPage = shippingPage.clickOnProceedToCheckOut();
		orderSummaryPage = paymentPage.clickOnPayByBankWire();
		orderConfirmationPage = orderSummaryPage.clickOnConfirmOrderBtn();
		String actMsg = orderConfirmationPage.validateConfirmMsg();
		String expMsg = "Your order on My Store is complete.";
		Assert.assertEquals(actMsg, expMsg);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
