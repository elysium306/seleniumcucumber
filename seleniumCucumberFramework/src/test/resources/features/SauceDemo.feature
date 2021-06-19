@Regression
Feature: Sauce Demo login tests

@SauceValidLogin
Scenario: Login Valid test 
 Given I am on the login page
 When I enter username "standard_user" and password "secret_sauce"
 And I click on the login button
 Then I should be in the home page
 And There should be 6 items in the home page


Scenario: login Invalid test
Given
 When
 Then