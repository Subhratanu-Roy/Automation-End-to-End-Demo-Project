package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utilities.ExcelLibrary;

public class DataProviders {

	ExcelLibrary excelLibrary;

	public DataProviders() throws Exception {

		excelLibrary = new ExcelLibrary();
	}

	@Test(dataProvider = "emailIDs")
	void test1(String email) {
		System.out.println(email);
	}

	@DataProvider(name = "credentials")
	public Object[][] getEmailData() {

		int rowcount = excelLibrary.getRowCount("credentials");
		int colcount = excelLibrary.getColumnCount("credentials");
		Object[][] data = new Object[rowcount - 1][colcount];
		for (int row = 2; row <= rowcount; row++) {
			for (int col = 1; col <= colcount; col++) {
				data[row - 2][col - 1] = excelLibrary.getCellData("credentials", row, col);
			}
		}

		return data;
	}

	@DataProvider(name = "emailIDs")
	public Object[] getEmails() {
		int rowcount = excelLibrary.getRowCount("Email IDs");
		Object[] data = new Object[rowcount - 1];
		for (int row = 2; row <= rowcount; row++) {
			data[row - 2] = excelLibrary.getCellData("Email IDs", row, "Email");
		}
		return data;
	}

	@DataProvider(name = "productname")
	public Object[] getProduct() {

		int rowcount = excelLibrary.getRowCount("Search Product");

		Object[] product = new Object[rowcount - 1];
		for (int row = 2; row <= rowcount; row++) {
			product[row - 2] = excelLibrary.getCellData("Search Product", row, "Product");
		}

		return product;

	}

	@DataProvider(name = "orderdetails")
	public Object[][] getOrderDetails() {

		int rowcount = excelLibrary.getRowCount("Order Detials");
		int colcount = excelLibrary.getColumnCount("Order Detials");
		Object[][] product = new Object[rowcount - 1][colcount];

		for (int row = 2; row <= rowcount; row++) {
			for (int col = 1; col <= colcount; col++) {
				product[row - 2][col - 1] = excelLibrary.getCellData("Order Detials", row, col);
			}
		}

		return product;
	}
}
