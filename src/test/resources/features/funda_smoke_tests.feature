Feature: Buy and Rent Search Available

  Background: User is on Funda Homepage
    Given User opens the Funda homepage
    Then The Funda logo is displayed
    And The search bar is present

  Scenario Outline: Buy Search Available
    When User enters "<city>" in the search bar
    And User selects "Koop" as a search type
    And User clicks the search button
    Then Search results page for "<city>" (buying) is displayed
    Examples:
      | city      |
      | Amsterdam |

  Scenario Outline: Rent Search Available
    When User enters "<city>" in the search bar
    And User selects "Huur" (Rent) as a search type
    And User clicks the search button
    Then Search results page for "<city>" (renting) is displayed
    Examples:
      | city      |
      | Amsterdam |

Feature: User Login is available

  Scenario Outline: User Login
    When User clicks on "Inloggen" (Login)
    And User enters valid email "<email>" and password "<password>"
    And User clicks the login button
    Then A success message or account dashboard is displayed # Superficial success check

    Examples:
      | email             | password      |
      | testuser@funda.nl | validpassword |

Feature: Displaying Map

  Scenario: Map Loads
    Given User is on the Funda homepage
    When User clicks the "Zoek op kaart" (Search on Map) button
    Then The map is displayed # Check if the map element is present

Feature: Searching for a Real Estate Agent

  Scenario: Agent Search Loads
    Given User is on the Funda homepage
    When User clicks on the "Zoek een NVM-makelaar" button
    Then The agent search page is displayed # Check if the page loads