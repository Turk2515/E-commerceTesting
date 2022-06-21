@regression
Feature: registration into the website
  Scenario: registration with valid data
    When enter gender
    When enter valid first name
    And enter valid last name
    And enter Birthday date
    And enter email to register
    And enter company name
    And enter password to register
    And confirm password
    Then confirm data