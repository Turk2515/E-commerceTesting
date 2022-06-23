@regression
Feature: change currency to euro
  Scenario: change currency
    Given open the site
    When change currency
    Then ensure that euro is selected