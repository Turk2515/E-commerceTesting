@regression
Feature: select different categories
  Background: open the browser
    Given open the site
  Scenario: search by product category
    When press on category
    And enter sub-category
    Then last page of category search
