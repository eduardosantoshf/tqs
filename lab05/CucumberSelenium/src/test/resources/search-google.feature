Feature: Search in Google

  Scenario: Seek for Selenium-Jupiter documentation
    When I navigate to "https://google.com"
    And I type "BlazeDemo"
    And I press Enter
    And I should enter the BlazeDemo website and register my flight