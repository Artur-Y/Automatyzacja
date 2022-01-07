Feature: Add new address to existing user account

  Scenario Outline: Add new address to existing user account on  https://mystore-testlab.coderslab.pl
    Given Open page https://mystore-testlab.coderslab.pl in browser
    And Button Sign In on the homepage click
    And Fill existing user's email and password
    And Button Sign In on the authorization page click
    When Button Addresses click
    And Url of opened page is https://mystore-testlab.coderslab.pl/index.php?controller=addresses
    And Button Create new address click
    And Form fill by <Alias>, <Address>, <City>, <Zip_Postal_Code>, <Country>, <Phone>
    And Button Save click
    Then New address created correctly <Alias>, <Address>, <City>, <Zip_Postal_Code>, <Country>, <Phone>
    And Delete new address
    And Deleted address not present
    Examples:
      | Alias |  | Address  |  | City   |  | Zip_Postal_Code |  | Country        |  | Phone     |
      | Inc   |  | Address1 |  | London |  | 00111           |  | United Kingdom |  | 744444444 |