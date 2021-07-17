@Regression
Feature: update the existing stock trade entries
  user wants to use this template for my feature file
	@updateTrade
  Scenario: User updates the trade log with valid information
    Given User is on the Homepage after sign in
    When user clicks on update
    Then user should see trade update form
    When user enters the following trade details
    And user clicks on save
    Then the update is displayed in the trade table