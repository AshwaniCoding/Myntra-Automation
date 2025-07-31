@Web
Feature: Add To Cart Functionality For Registered User

  Background:
    Given user opens website
    Then verify user is on homepage
    When user login through cookies
    Then verify user is logged in

  Scenario: Verify registered user can add product to cart
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

  Scenario: Verify registered user can add and remove product from cart
    When user search for a product "search.product.name.third"
    Then verify user is on product listing page
    When user click on first product
    Then verify user is on product page
    When user select the size as "search.product.size.third"
    And user click on add to bag button
    Then verify bag quantity increases by 1
    When user click on bag icon
    Then verify user is on bag page
    And verify item added to cart is available
    When user click on remove button of added product and confirms the dialog to remove
    Then verify added item is removed from bag