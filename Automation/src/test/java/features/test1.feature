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
    And User adds products to the cart
    |Products|jordan_1|all_star|jordan_9| 
    And User clicks on "CartButton"
    And User navigates to the "Cart" page
    
    Scenario: Final shopping page
    Given User is on the Cart Page
    And User clicks on "Checkbox"
    When User clicks on "Visit_to_the_website"
    Then User is taken to Google Homepage
    And User enters the detail
    |Search|http://the-internet.herokuapp.com/ \n|
    And User clicks on "The_Internet"
    

