@SmokeTest
Feature: Searching for a Real Estate Agent

  Scenario: Agent Search Loads
    Given User opens the Funda homepage
    When User clicks on the "Zoek een NVM-makelaar" button
    Then The agent search page is displayed # Check if the page loads