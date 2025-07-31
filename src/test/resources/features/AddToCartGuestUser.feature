@Web
Feature: Add To Cart Functionality For Guest User

  Background:
    Given user opens website
    Then verify user is on homepage

  Scenario: Verify guest user can add product to cart
    When user search for a product "search.product.name.first"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.first"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available

  Scenario: Verify guest user can add and remove product from cart
    When user search for a product "search.product.name.first"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.first"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available
    When user click on remove button of added product and confirms the dialog to remove
    Then verify bag is empty with message "There is nothing in your bag. Let's add some items."

  Scenario: Verify user can not place order without login
    When user search for a product "search.product.name.second"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.second"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available
    When user click on place order button
    Then verify user is on login page

  Scenario: Verifying adding multiple products to cart
    When user search for a product "search.product.name.first"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.first"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    And user search for a product "search.product.name.second"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.second"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    When user click on bag icon
    Then verify user is on bag page
    And verify item count in bag is 2

  Scenario: Verify updating the product quantity
    When user search for a product "search.product.name.first"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.first"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available
    When user update the product quantity to 3
    Then verify product quantity is updated to 3
    And verify bag reflects updated total price