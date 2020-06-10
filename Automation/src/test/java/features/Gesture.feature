Feature: This feature allows the user to shop from the app

  Background:
    Given App is open
    When  User selects the value from dropdown
    |Country|Albania|
    And User enters the detail
    |Name|Vlad|
    And User selects a value
  	|Gender|Male|  
    And User clicks on "ShopButton"
    And User navigates to the "Products" page
    And User adds products to the cart
    |Products|jordan_1|    
    And User clicks on "CartButton"
    And User clicks on "Visit_to_the_website"
    Then User is taken to Google Homepage
    
	
	Scenario: Testing horizontal sliding
	Given The "Google_Homepage" is open
	When User enters the detail
    |Search|https://the-internet.herokuapp.com/horizontal_slider \n|
    And User clicks on "Horizontal_Slider"
	Then The "HorizontalSlider_window" is open
	And Slide "slider" to "3"