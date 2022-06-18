@regression
Feature: search product
  Scenario: search product
    Given open site
    When press on search bar
    Then ensure the search is valid