@regression
Feature: select color
  Scenario: select color
    When press on search bar
    And select product and color
    Then ensure the search is valid