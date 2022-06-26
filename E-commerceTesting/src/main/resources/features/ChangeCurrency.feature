@regression
Feature: change currency to euro
  Background: open the browser
    Given open the site
  Scenario: change currency
    When change currency
    Then ensure that euro is selected