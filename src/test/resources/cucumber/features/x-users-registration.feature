Feature: Registrating set number of users
  Scenario: Create account for set number of users
    Given An open browser with user registration page
    When User account is being created 2 times
    Then Quit browser