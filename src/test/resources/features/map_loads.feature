@SmokeTest
Feature: Displaying Map

  Scenario: Map Loads
    Given User opens the Funda homepage
    When User clicks the Zoek_op_kaart button
    Then The map is displayed
