	@DummyTest1
Feature: Feature ID 001 : Go to Selenium Easy website
				 click InputForm dropdown and select Simple form damo


  Scenario: Go to Selenium Easy website
    Given user launch chrome browser and navigate to URL 
    When  user close PopUp
    And user click on "Input Forms" 
    And  select "Simple Form Demo" from dropdown
    Then Simple form damo page is open
    When single input form demo text is displayed as "Single Input Field"
    And user enters single input text "Selenium Practice"
    And user click on Get Massage button
    Then Text massage will display as "Selenium Practice"   
#  Scenario: Multiple Input field
    Given Multiple input form demo text is displayed as "Two Input Fields"
		When user enters two integer values as "84" and "16"
		And click on Get Total button
		Then sum of two numbers will be displayed
		And user Close the Browser
		
		
		
		Scenario Outline: Go to Selenium Easy website
    Given user launch chrome browser and navigate to URL 
    When  user close PopUp
    And user click on "Input Forms" 
    And  select "Simple Form Demo" from dropdown
    Then Simple form damo page is open
    When single input form demo text is displayed as "Single Input Field"
    And user enters single input text "<SingleInput>"
    And user click on Get Massage button
    Then Text massage will display as "<VerifyResult>"
    Given Multiple input form demo text is displayed as "Two Input Fields"
		When user enters two integer values as "<FirstNumber>" and "<SecondNumber>"
		And click on Get Total button
		Then sum of two numbers "<FirstNumber>" and "<SecondNumber>" will be displayed
		And user Close the Browser
   
    Examples:
        
        |SingleInput|VerifyResult|FirstNumber|SecondNumber|
        |India|India|78|23|
        |Austrelia|Austrelia|10|20|
        |USA|USA|64|83|
        |Chaina|Chaina|64|34|
        
        