@DummyTest
Feature: Feature ID 002 : Go to BootStrap Dropdown page and verify functionality
  
  
  Background:
 		Given user launch chrome browser and navigate to URL 
    When  user close PopUp
    
  Scenario: Open BootStrap alert
    Given user navigate to home page
    And click on DropDown "Alerts & Modals" and select "Bootstrap Alerts"
    When header of page is displayed
    And click on auto closable success massage button
    And verify alert auto closable success massage is displayed
    And click on Normal Success button
    And verify alert Normal Success massage is displayed
    And click Auto closable Warning button
    Then verify alert Auto closable Warning massage is displayed
		And user Close the Browser