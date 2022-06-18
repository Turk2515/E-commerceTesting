@regression
Feature: select different categories
  Scenario: search by product category
    Given open site
    When press on category
    And enter sub-category
    Then last page of category search
