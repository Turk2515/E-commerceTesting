@regression
Feature: create successful order
  Scenario: make an order successfully
    Given open the site
    When press on search bar
    And select product and color
    And select size
    And press on add to cart
    And go to cart
    And enter billing address
    And select shipping address
    And select payment method
    And confirm order
    Then success order