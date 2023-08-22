package com.mystore.actiondrivers;

import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mystore.base.Base;

public class ActionDrivers extends Base {

	// method for checking if element is present
	public static boolean findElement(WebDriver driver, WebElement ele) {

		boolean flag = false;
		try {

			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {

			flag = false;
		} finally {

			if (flag) {

				System.out.println("Element found");
			}

			else
				System.out.println("Element not found");
		}

		return flag;
	}

	// method for scrolling
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	// method for clicking
	public static void click(WebDriver driver, WebElement ele) {

		/*
		 * Actions a = new Actions(driver); a.moveToElement(ele).click().perform();
		 */

		ele.click();

	}

	// method for typing
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag = true;

		} catch (Exception e) {

			System.out.println("Location not found");
			flag = false;
		} finally {

			if (flag) {
				System.out.println("Successfully typed = " + text);
			} else
				System.out.println("Unable to type value");
		}
		return flag;

	}

	// method for select by index
	public static boolean selectByIndex(WebElement ele, int index) {

		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByIndex(index);
			flag = true;

		} catch (Exception e) {

			flag = false;
		}

		finally {

			if (flag) {

				System.out.println("Option selected by index");
			}

			System.out.println("Option not selected by index");
		}
		return flag;

	}

	// method for select by value
	public static boolean selectByValue(WebElement ele, String value) {

		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByValue(value);
			flag = true;

		} catch (Exception e) {

			flag = false;
		}

		finally {

			if (flag) {

				System.out.println("Option selected by index");
			}

			System.out.println("Option not selected by index");
		}
		return flag;

	}

	// method for select by visible text
	public static boolean selectByVisibleText(WebElement ele, String text) {

		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(text);
			flag = true;

		} catch (Exception e) {

			flag = false;
		}

		finally {

			if (flag) {

				System.out.println("Option selected by visible text");
			}

			System.out.println("Option not selected by visible text");
		}
		return flag;

	}

	// method for clicking by javascript executor
	public static boolean jsClick(WebDriver driver, WebElement ele) {

		boolean flag = false;
		try {
			findElement(driver, ele);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			flag = true;
		} catch (Exception e) {

			flag = false;

		} finally {
			if (flag) {
				System.out.println("Click action is performed");

			} else {
				System.out.println("Click action is not performed");
			}
		}
		return flag;
	}

	// method to switch to frame by index
	public static boolean switchToFrameByIndex(WebDriver driver, int index) {

		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;

		} catch (Exception e) {

			flag = false;
		} finally {

			if (flag) {
				System.out.println("Switched to frame by index");
			} else
				System.out.println("Could not switched to frame");
		}

		return flag;
	}

	// method to switch to frame by id
	public static boolean switchToFrameById(WebDriver driver, String id) {

		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(id);
			flag = true;

		} catch (Exception e) {

			flag = false;
		} finally {

			if (flag) {
				System.out.println("Switched to frame by id");
			} else
				System.out.println("Could not switched to frame");
		}

		return flag;
	}

	// method to switch to frame by name
	public static boolean switchToFrameByName(WebDriver driver, String name) {

		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(name);
			flag = true;

		} catch (Exception e) {

			flag = false;
		} finally {

			if (flag) {
				System.out.println("Switched to frame by index");
			} else
				System.out.println("Could not switched to frame");
		}

		return flag;
	}

	// method switch to default frame
	public static boolean switchToDefaultFrame(WebDriver driver) {

		boolean flag = false;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().defaultContent();
			flag = true;
		} catch (Exception e) {

			flag = false;
		} finally {
			if (flag) {
				System.out.println("Switch to default frame");
			} else
				System.out.println("Can not switch to default frame");
		}
		return flag;
	}

	// method to mouse over a element

	public static boolean mouseOverElement(WebDriver driver, WebElement ele) {

		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {

			flag = false;
		} finally {
			if (flag) {
				System.out.println("Mouse over action is performed");
			} else
				System.out.println("Mouse over action is not performed");
		}

		return flag;
	}

	// method to drag and drop element
	public static boolean dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		boolean flag = false;

		try {
			new Actions(driver).dragAndDrop(source, target);
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {

			if (flag) {
				System.out.println("Drag and drop is performed");
			} else
				System.out.println("Drage and drop is not performed");
		}
		return flag;

	}

	public static boolean draggable(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(ele, x, y);
			Thread.sleep(5000);
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Drage and drop is perrformed");
			} else
				System.out.println("Drage and drop is not performed");
		}

		return flag;
	}

	// method to right click
	public static boolean rightClick(WebDriver driver, WebElement ele) {

		boolean flag = false;
		try {
			new Actions(driver).contextClick(ele).perform();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Right click is performed");
			} else
				System.out.println("Right click is not performed");
		}
		return flag;
	}

	// method to switch to window by title
	public static boolean switchToWindowByTitle(WebDriver driver, WebElement ele, String title, int count) {
		boolean flag = false;

		try {
			Set<String> windows = driver.getWindowHandles();
			String[] winarr = windows.toArray(new String[0]);

			driver.switchTo().window(winarr[count - 1]);

			String text = driver.getTitle();
			if (text.contains(title)) {

				flag = true;

			} else
				flag = false;
		} catch (Exception e) {
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Switched to window by title");
			} else
				System.out.println("Window with title is not selected");
		}
		return flag;

	}

	// method to get column count
	public static int getColumnCount(WebDriver driver) {

		int count;
		List<WebElement> columns = driver.findElements(By.tagName("td"));
		count = columns.size();
		System.out.println("Number of columns: " + count);
		for (WebElement column : columns) {
			System.out.println(column.getText());
		}

		return count;

	}

	// method to get row count
	public static int getRowCount(WebDriver driver) {
		int count;
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		count = rows.size() - 1;
		System.out.println("Number of rows: " + count);

		return count;
	}

	// method for implicit wait
	@SuppressWarnings("deprecation")
	public static void implicitWait(WebDriver driver, int timeout) {

		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	// method for explicit wait
	public static void explicitWait(WebDriver driver, int timeout, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	// method for page load timeout
	public static void pageLoadTimeout(WebDriver driver, int timeout) {
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}

	// method to get current time
	public static String getCurrentTime() {
		String time = new SimpleDateFormat("dd-MM-yyyy-hhmmss").format(new Date());
		System.out.println(time);
		return time;
	}

	// method to take screenshot
	public static String getScreenshot(WebDriver driver, String filename) throws IOException {
		String currentTime = new SimpleDateFormat("dd-MM-yyyy-hhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String ssPath = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + currentTime + ".png";

		FileUtils.copyFile(src, new File(ssPath));

		System.out.println("Screenshot path:" + ssPath);

		return ssPath;

	}

	// method isDisplayed
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {

		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("Element is displayed");
			} else
				System.out.println("Element is not displayed");
		} else
			System.out.println("Element not found");

		return flag;
	}

}
