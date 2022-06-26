@regression
Feature: select different tags
  Background: open the browser
    Given open the site
  Scenario: search by tag
    When press on category
    And select a tag
    Then ensure a tag is selected