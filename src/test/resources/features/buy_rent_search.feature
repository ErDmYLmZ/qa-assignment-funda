@SmokeTest
Feature: Buy and Rent Search Available

  Background: User is on Funda Homepage
    Given User opens the Funda homepage
    Then The Funda logo is displayed
    And The search bar is present

  Scenario Outline: Buy Search Available
    And User selects Koop as a search type for buying
    When User enters "<city>" in the search bar and starts searching
    Then Search results page for "<city>" is displayed
    Examples:
      | city  |
      | city0 |
      | city1 |
      | city2 |
      | city3 |

  Scenario Outline: Rent Search Available
    And User selects Huur as a search type for renting
    When User enters "<city>" in the search bar and starts searching
    Then Search results page for "<city>" is displayed
    Examples:
      | city  |
      | city0 |
      | city1 |
      | city2 |
      | city3 |