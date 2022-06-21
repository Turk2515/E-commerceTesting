@regression
Feature: select different categories
  Scenario: search by product category
    When press on category
    And enter sub-category
    Then last page of category search
