package com.Project.StepDefs;

import com.Project.Pages.PageObjects;
import com.Project.Utilities.Environment;
import com.Project.Utilities.PageBase;
import com.Project.Utilities.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef extends PageBase {

	PageObjects po = new PageObjects();

	@Given("Driver is initialized")
	public void driver_is_initialized() throws Exception {
		WebDriverUtils.initializeDriver();
		WebDriverUtils.maximizeBrowser();
	}

	@When("User passes application URL")
	public void user_passes_application_url() throws Exception {
		WebDriverUtils.openURL(Environment.ReadExcelData("Common", 2, 1));
	}

	@Then("Webpage navigates to the mentioned URL")
	public void webpage_navigates_to_the_mentioned_url() throws Exception {
		po.compareURL();
	}

	@Given("User inserted the keyword")
	public void user_inserted_the_keyword() throws Exception {
		po.sendKeywordToGoole();
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() throws Exception {
		po.clickOnSearchButton();
	}

	@Then("URL changes")
	public void url_changes() throws Exception {
		po.validateURLchange();
	}

}
