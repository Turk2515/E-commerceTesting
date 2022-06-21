@regression
Feature: select different tags
  Scenario: search by tag
    When press on category
    And select a tag
    Then ensure a tag is selected