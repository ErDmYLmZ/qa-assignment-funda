@SmokeTest
Feature: User Login is available

  Scenario Outline: User Login
    Given User opens the Funda homepage
    When User clicks on Inloggen button
    And User enters valid email "<email>" and password "<password>"
    And User clicks the login button
    Then User logs in successfully

    Examples:
      | email  | password  |
      | email1 | password1 |
      | email2 | password2 |


