
Feature: Login and Logout functionality
Description: This feature verifies the login and logout functionality


Scenario: Verify the Login functionality
Given I launch the Chrome Browser
Given I navigate the application url
Given I enter the "admin" in username text field
Given I enter the "manager" in password text field
Given I click on login button
Given I find the Home Page
Given I minimize the flyout window

Scenario: Verify the Logout functionality
Given I find the Home Page
Given I click on Logout link
Given I find the login page

