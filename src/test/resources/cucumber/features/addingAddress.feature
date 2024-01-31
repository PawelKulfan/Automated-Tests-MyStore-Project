Feature: Login and add first address

  Scenario Outline: User registers a new account and adds his address
    Given An open browser with new user created
    When User logins to his account and adds first address: <alias> <address> <city> <zip> <phone>
    Then First address added to user account with proper data: <address> <city> <zip> <phone>
    And User address deletion
    And Address deleted from user addresses

    Examples:
      | alias          | address       | city   | zip    | phone     |
      | MyFirstAddress | Mickiewicza | Warsaw | 02-032 | 321713871 |