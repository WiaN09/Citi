Feature: This feature allows the user to shop from the app

  Background:
    Given App is open
    When  User selects the value from dropdown
    |Country|Australia|
    And User enters the detail
    |Name|Jennifer|
    And User selects a value
  	|Gender|Female|  
    And User clicks on "ShopButton"
    Then User navigates to the "Products" page

   Scenario: User adds products to the cart
    Given User is on products page
    When User adds products to the cart
    |Products|jordan_9|
    And User clicks on "CartButton"
    Then User navigates to the "Cart" page

