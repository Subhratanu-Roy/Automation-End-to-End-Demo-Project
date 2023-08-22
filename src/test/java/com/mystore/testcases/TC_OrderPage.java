package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Base;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class TC_OrderPage extends Base {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	

	@Test(groups = {"Regression"}, dataProvider = "orderdetails", dataProviderClass = DataProviders.class )
	public void verifyTotalPrice(String productName, String size, String qty, String shippingPrice) {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		System.out.println("Add to cart page appears");
		addToCartPage.enterQuanity(qty);
		addToCartPage.selectSize(size);
		System.out.println("Select size "+ size);
		System.out.println("Select qty "+ qty);
		addToCartPage.clickOnAddToCart();
		System.out.println("Clicked on add to cart");
		orderPage = addToCartPage.clickOnProceesToCheckOut();
		System.out.println("Clicked on process to checkout");
		Double unitPrice = orderPage.getUnitPrice();
		System.out.println("Unit price: " + unitPrice);
		Double totalPrice = orderPage.getTotalPrice();
		System.out.println("Total price: " + totalPrice);
		Double totalExpectedPrice = unitPrice * Double.valueOf(qty) + Double.valueOf(shippingPrice);
		totalExpectedPrice = Double.valueOf(String.format("%.2f",totalExpectedPrice));
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
