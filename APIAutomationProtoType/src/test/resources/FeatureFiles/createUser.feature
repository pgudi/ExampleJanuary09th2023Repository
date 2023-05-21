# Author:
# Feature Name:
# User Story Name:
# User Story Number:
# Description:
Feature: Create User Functionality
Scenario: Verify Create user funationlaity
Given i provide the endPoint
And I create httpRequest Object
And I create User Pojo Json request
When I post the Request
Then I get 201 status code
