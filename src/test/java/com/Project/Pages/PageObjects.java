package com.Project.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.Project.Utilities.Environment;
import com.Project.Utilities.PageBase;
import com.Project.Utilities.WebDriverUtils;

public class PageObjects extends PageBase {

	By searchBoxGoogle = By.xpath("//input[@title='Search']");
	By searchButtonGoogle = By.xpath("//div[2]/form/div[2]/div[1]/div[3]/center/input[@value='Google Search']");

	public void sendKeywordToGoole() throws Exception {
		WebDriverUtils.inputValue(searchBoxGoogle, Environment.ReadExcelData("Common", 6, 1));
	}

	public void compareURL() throws Exception {
		Assert.assertTrue(
				WebDriverUtils.compareText(WebDriverUtils.getCurrentURL(), Environment.ReadExcelData("Common", 2, 1)));
	}

	public void clickOnSearchButton() throws Exception {
		WebDriverUtils.ClickAction(searchButtonGoogle);
	}

	public void validateURLchange() throws Exception {
		Assert.assertEquals(Environment.ReadExcelData("Common", 2, 1), WebDriverUtils.getCurrentURL());
		WebDriverUtils.quitDriver();
	}

}
