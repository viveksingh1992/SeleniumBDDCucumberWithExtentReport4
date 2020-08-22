Feature: To implement Extent Report

  Background: Open browser and run one test case
    Given Driver is initialized
    When User passes application URL
    Then Webpage navigates to the mentioned URL

  Scenario: Basic extent report implementation
    Given User inserted the keyword
    When User clicks on search button
    Then URL changes
