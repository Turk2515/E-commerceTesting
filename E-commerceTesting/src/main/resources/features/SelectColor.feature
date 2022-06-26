@regression
Feature: select color
  Background: open the browser
    Given open the site
  Scenario: select color
    When press on search bar
    And select product and color
    Then ensure the search is valid