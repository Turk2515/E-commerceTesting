@regression
Feature: login to the site
  Scenario: login to the site
    Given open the site
    When enter email to login
    And enter password to login
    And press login
    And go to my account
    And change password
    Then ensure password is changed