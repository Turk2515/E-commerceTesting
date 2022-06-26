@regression
Feature: login to the site
  Background: open the browser
    Given open the site
  Scenario: login to the site
    When enter email to login
    When enter password to login
    When press login
    Then test validation of login