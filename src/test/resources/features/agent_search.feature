@SmokeTest
Feature: Searching for a Real Estate Agent

  Scenario: Agent Search Loads
    Given User opens the Funda homepage
    When User clicks on the Zoek_een_NVM_makelaar button
    Then The agent search page is displayed