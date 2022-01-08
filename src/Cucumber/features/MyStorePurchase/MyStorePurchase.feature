Feature: Purchase the item

  Scenario Outline: Purchase the item on https://mystore-testlab.coderslab.pl
    Given Opened page https://mystore-testlab.coderslab.pl in browser
    And Button Sign In on the homepage clicked
    And Filled existing user's email and password
    And Button Sign In on the authorization page clicked
    And Clicked on the logo "my store"
    When Click on the item "Hummingbird Printed Sweater"
    And Check discount 20%
    And Size <size> select
    And Quantity <quantity> selected
    And Click button Add to card
    And Click button Proceed to checkout on pop-up window
    And Click button Proceed to checkout on page Shopping cart
    And Confirm address by clicking on button Continue
    And Chose shipping method PrestaShop "pick up in store"
    And Confirm shipping method by clicking on button Continue
    And Chose payment method Pay by Check
    And Check checkbox "I agree to the terms service"
    And Click button "Order with an obligation to pay"
    Then Create screenshot of confirmed order page
    And Click customer account button
    And Click "ORDER HISTORY AND DETAILS" button
    And Check "Invoice" status "Awaiting check payment" of order
    And Check "Total Price" value of order
    And Close browser

    Examples:
      | quantity |  | size |
      | 5        |  | M    |


