package com.Project.Utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class PageBase {

	public WebDriver driver;

	public ExtentReports extent;

	public static ExtentTest scenarioDef;

	public static ExtentTest feature;

	public static String reportLoction = System.getProperty("user.dir");
	
}
