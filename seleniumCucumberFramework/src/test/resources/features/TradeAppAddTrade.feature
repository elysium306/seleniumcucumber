Feature: Add Trade
  User is able to add delete edit his trade logs
  
  Scenario: As a user, I should be able to log my trade
    Given I am on the app log in page
    When I enter valid username "helil" and password "SuperHelil123!"
    And I click on signin button
    Then I should be in the trade homepage
    When I click on Add Trade button
    Then I should be on Save Trade Form
    When I select "Buy to Open" and enter symble "TSLA" entrydate "06/01/2021" entryprice "590" exitdate "06/10/2021" exitprice "600"
    And I click save button 
    Then the trade is displayed in the trade table