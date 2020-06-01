Feature: Test Login and Profile App 

Scenario: Login into an app
Given I'm at the homescreen
When I have opened the app
And I fill out the login details
And I press the Login button
Then I fill out the profile details
And I press Save
And My details are stored
