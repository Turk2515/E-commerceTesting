@regression
Feature: add to wishlist
  Background: open the browser
    Given open the site
  Scenario: add to wishlist
    When enter email to login
    And enter password to login
    Then press login
    When press on search bar
    And select product and color
    And select size
    And add product to wishlist
    Then ensure the product added to wishlist