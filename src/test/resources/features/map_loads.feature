@SmokeTest
Feature: Displaying Map

  Scenario: Map Loads
    Given User opens the Funda homepage
    When User clicks the "Zoek op kaart" (Search on Map) button
    Then The map is displayed # Check if the map element is present
