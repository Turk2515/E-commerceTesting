@regression
Feature: select color
  Scenario: select color
    Given open site
    When press on search bar
    And select product and color
    Then ensure the search is valid