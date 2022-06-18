@regression
Feature: select different tags
  Scenario: search by tag
    Given open site
    When press on category
    And select a tag
    Then ensure a tag is selected