@DummyTest
Feature: Feature ID 003 : verify check box functionality on Selenium Easy website


Background:
 		Given user launch chrome browser and navigate to URL
    When  user close PopUp
    
  Scenario: Go to check box module and select Single and multiple check boxes
    Given user navigate to home page
    And click on DropDown TopUp "Input Forms" and select "Checkbox Demo"
    And header of Check box demo page is displayed
    When single input form Title text is displayed as "Single Checkbox Demo" 
    And  user clicks single checkbox and selected check box text will be "Success - Check box is checked"
    When Multiple check box title text is displayed as "Multiple Checkbox Demo" 
    Then select multiple check box "Option 2" and "Option 4"
		And user Close the Browser