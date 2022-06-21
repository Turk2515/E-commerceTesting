@regression
Feature: change currency to euro
  Scenario: change currency
    When change currency
    Then ensure that euro is selected