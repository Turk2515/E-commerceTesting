@regression
Feature: add to cart
  Scenario: add to cart
    When enter email to login
    And enter password to login
    Then press login
    When press on search bar
    And select product and color
    And select size
    And press on add to cart
    Then ensure the product is added to cart