@regression
Feature: login to the site
  Scenario: login to the site
    Given open the site
    When enter email to login
    When enter password to login
    When press login
    Then test validation of login