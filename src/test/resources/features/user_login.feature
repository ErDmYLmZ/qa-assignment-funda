@SmokeTest
Feature: User Login is available

  Scenario Outline: User Login
    When User clicks on "Inloggen" (Login)
    And User enters valid email "<email>" and password "<password>"
    And User clicks the login button
    Then A success message or account dashboard is displayed # Superficial success check

    Examples:
      | email             | password      |
      | testuser@funda.nl | validpassword |
