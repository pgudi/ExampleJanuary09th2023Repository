@sanity
Feature: Login and Logout functionality New
Description: This feature verifies the login and logout functionality

Scenario Outline: Verify the Login functionality
Given I launch the Chrome Browser
And I navigate the application url
When I enter the "<username>" in username text field
And I enter the "<password>" in password text field
And I click on login button
Then I find the Home Page
And I minimize the flyout window
Given I find the Home Page
When I click on Logout link
Then I find the login page

Examples:
|username|password|
|admin|manager|
|admin|manager|
|admin|manager|

