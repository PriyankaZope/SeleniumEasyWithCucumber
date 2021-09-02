@DummyTest2
Feature: Feature ID 005 : In order to verify topup menu of Demo Home page is displayed

  # Background:
  #  Given user launch chrome browser and navigate to URL
  #  When user close PopUp
  Scenario: Verify topup menu
    Given user is on the Demo home page
    When verify header of demo home page
    Then verify the topup menu of demo home page
      | topUpMenu       |
      | Input Forms     |
      | Date pickers    |
      | Table           |
      | Progress Bars   |
      | Alerts & Modals |
      | List Box        |
      | Others          |

  # And close the browser
  
