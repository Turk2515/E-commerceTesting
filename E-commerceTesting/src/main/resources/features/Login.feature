@regression
Feature: login to the site
  Scenario: login to the site
    When enter email to login
    And enter password to login
    And press login
    Then test validation of login