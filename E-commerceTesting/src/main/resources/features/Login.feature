@regression
Feature: login to the site
  Scenario: login to the site
    Given open site to login
    When enter email to login
    And enter password to login
    Then press login