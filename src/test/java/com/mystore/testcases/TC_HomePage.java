package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Base;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class TC_HomePage extends Base {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) {
		launchApp(browser);

	}

	@Test(groups = {"Smoke"})
	public void wishListTest() {
		log.startTest("WishList Test");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignin();
		System.out.println("Uername: " + uname + " and password " + pword);
		log.info("Usrename and Password: "+ uname + pword);
		homePage = loginPage.login(uname, pword);
		Boolean res = homePage.validateWishList();
		Assert.assertTrue(res);
		log.endTest("WishList Test");

	}

	@Test(groups = {"Smoke"})
	public void orderHistoryTest() {
		log.startTest("OrderHistory Test");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignin();
		System.out.println("Uername: " + uname + " and password " + pword);
		log.info("Usrename and Password: "+ uname + pword);
		homePage = loginPage.login(uname, pword);
		Boolean res = homePage.validateOrderHistory();
		Assert.assertTrue(res);
		log.endTest("OrderHistory Test");
	}

	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
