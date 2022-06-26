@regression
Feature: search product
  Background: open the browser
    Given open the site
  Scenario: search product
    When press on search bar
    Then ensure the search is valid