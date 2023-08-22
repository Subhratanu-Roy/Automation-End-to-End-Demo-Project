package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.actiondrivers.ActionDrivers;
import com.mystore.utilities.ExtentManager;
import com.mystore.utilities.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static Properties prop = new Properties();
	public static String uname;
	public static String pword;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static Log log = new Log();

	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() throws IOException {

		String path = System.getProperty("user.dir") + "\\Configuration\\Config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		System.out.println("Browser = " + prop.getProperty("browser"));
		uname = prop.getProperty("username");
		pword = prop.getProperty("password");
		ExtentManager.setReport();
	}

	public static WebDriver getDriver() {

		return driver.get();
	}

	public static void launchApp(String browser) {

		//String browser = prop.getProperty("browser");

		if (browser.toUpperCase().contains("CHROME")) {
			WebDriverManager.chromedriver().setup();
			System.out.println("Opening chrome browser");
			driver.set(new ChromeDriver());
		}

		if (browser.toUpperCase().contains("FIREFOX")) {

			WebDriverManager.firefoxdriver().setup();
			System.out.println("Opening firefox browser");
			driver.set(new FirefoxDriver());
		}
		if (browser.toUpperCase().contains("IE")) {
			WebDriverManager.iedriver().setup();
			System.out.println("Opening IE browser");
			driver.set(new InternetExplorerDriver());

		}
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	
	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void afterSuite(){
		ExtentManager.endReport();
	}
	

}
