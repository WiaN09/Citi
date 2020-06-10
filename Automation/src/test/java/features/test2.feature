Feature: This feature allows the user to shop from the app

  Background:
    Given App is open
    
    Scenario Outline:
    	When User selects the value from "dropdown" with "<Country>"
    	And User enters the "Name" with "<Nameofperson>"
    	And User selects a "<Gender>"
    	And User clicks on "ShopButton"
    	Then User navigates to the "Products" page
    	And User adds products to the cart
    	|Products|jordan_1|all_star|jordan_9| 
    	And User clicks on "CartButton"
    	And User navigates to the "Cart" page
    	Given User is on the Cart Page
    	And User clicks on "Checkbox"
    	When User clicks on "Visit_to_the_website"
    	Then User is taken to Google Homepage
    	And User enters the "Search" with "<url>"
    	And User clicks on "The_Internet"
    	Examples:
    	| Country    | Nameofperson    | Gender | Products    | url                                             |
    	| Australia  | Jennifer        | Female | jordan_1    | http://the-internet.herokuapp.com/ \n    |
		| India      | alex            | Male   | jordan_9    | http://the-internet.herokuapp.com/ \n    |
