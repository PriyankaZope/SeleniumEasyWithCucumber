@DummyTest
Feature: Feature ID 00 : verify RadioButton functionality on Selenium Easy website

 
 Background:
 		Given user launch chrome browser and navigate to URL
    When  user close PopUp
    
  Scenario: Go to check box module and select Single and multiple check boxes
    Given click on DropDown TopUp "Input Forms" and select "Checkbox Demo"
    And click on DropDown TopUp "Input Forms" and select "Radio Buttons Demo"
    And header of radio button demo page is displayed
    When user click on radio button
    And  user verify Result of RadioButton
		And user Close the Browser
