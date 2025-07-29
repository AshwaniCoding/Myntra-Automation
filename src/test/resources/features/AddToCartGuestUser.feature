@Web
Feature: Add To Cart Functionality For Guest User

  Background:
    Given user opens website
    Then verify user is on homepage
    When user search for a product "search.product.name"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size"
    And user click on add to bag button
    Then verify bag quantity increases by 1

  Scenario: Verify guest user can add product to cart
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available

  Scenario: Verify guest user can add and remove product from cart
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available
    When user click on remove button and confirms the dialog to remove
    Then verify bag is empty with message "There is nothing in your bag. Let's add some items."

  Scenario: Verify user can not place order without login
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available
    When user click on place order button
    Then verify user is on login page
