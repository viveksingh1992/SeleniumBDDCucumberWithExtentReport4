package com.Project.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils extends customReportListener {

	public static WebDriver driver = null;
	static String currentURL = null;

	public static WebDriver initializeDriver() throws Exception {

		if (Environment.ReadExcelData("Common", 0, 1).toLowerCase().equals("chrome")) {

			try {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				step.log(Status.INFO, "Initializing Chrome Browser");
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return driver;
	}

	public static void maximizeBrowser() {
		if (driver != null) {
			driver.manage().window().maximize();
		} else {
			System.out.println("Driver is not initialized.");
		}
	}

	public static void openURL(String url) {
		if (driver != null) {
			driver.get(url);
		} else {
			System.out.println("No Browser open.");
		}
	}

	public static String getCurrentURL() {
		if (driver != null) {
			currentURL = driver.getCurrentUrl();
		} else {
			System.out.println("No Browser open.");
		}
		return currentURL;
	}

	public static boolean compareText(String actual, String expected) {
		boolean flag = false;
		try {

			if (actual.contentEquals(expected)) {
				System.out.println("Texts are equal.");
				flag = true;
			} else {
				System.out.println("Texts are not equal.");
			}

		} catch (Exception ex) {

		}
		return flag;

	}

	public static void inputValue(By by, String toInput) {
		if (driver.findElement(by).isDisplayed()) {
			driver.findElement(by).sendKeys(toInput);
		} else {
			System.out.println("Element Not Present.");
		}
	}

	public static void ClickAction(By by) throws Exception {
		try {
			if (driver.findElement(by).isDisplayed() || driver.findElement(by).isEnabled()) {
				driver.findElement(by).click();
			} else {
				System.out.println("Element is either not displaying or nor enabled.");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		} else {
			System.out.println("Driver Already Not Active.");
		}
	}

	public static String dateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		Date date = new Date();
		String dateTime = formatter.format(date);
		return dateTime;

	}
}
