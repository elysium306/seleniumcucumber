Feature: Amazon login
  User should be able to login and logout using Amazon login feature

  Scenario: As a user, I should be directed to login page on click of the sign in button
    Given I am on the amazon homepage
    Then Sign in button is displayed
    When I click on signin button
    Then I should be directed to login page

  Scenario: As a user, I should not be directed to password field when I provide invalid user email
    Given I am on the amazon signin page
    When I enter invalid user email "jon.dow@gmail.com"
    And I clicked on continue button
    Then An error message "There was a problem" should display
    But The password field should not display
