package com.mystore.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.base.Base;

public class Listeners extends ExtentManager implements ITestListener {

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, result.getMethod().getMethodName() + " is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = "";
		extentTest.get().log(Status.FAIL, result.getMethod().getMethodName() + " is failed");
		extentTest.get().fail(result.getThrowable());
		try {
			screenshotPath = ActionDrivers.getScreenshot(Base.getDriver(), result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}

		extentTest.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, result.getMethod().getMethodName() + " is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
