Feature: Add new address to existing user account

  Scenario Outline: Add new address to existing user account on  https://mystore-testlab.coderslab.pl
    Given Opened page https://mystore-testlab.coderslab.pl in browser
    And Button Sign In on the homepage clicked
    And Filled existing user's email and password
    And Button Sign In on the authorization page clicked
    When Button Addresses clicked
    And Button Create new address clicked
    And Form filled by <Alias>, <Address>, <City>, <Zip_Postal_Code>, <Country>, <Phone>
    And Button Save clicked
    Then New address created correctly <Alias>, <Address>, <City>, <Zip_Postal_Code>, <Country>, <Phone>
    And Delete new address
    And Deleted address not present
    Examples:
      | Alias |  | Address  |  | City   |  | Zip_Postal_Code |  | Country        |  | Phone     |
      | Inc   |  | Address1 |  | London |  | 00111           |  | United Kingdom |  | 744444444 |