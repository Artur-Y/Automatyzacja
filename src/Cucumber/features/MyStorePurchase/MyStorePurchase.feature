Feature: Purchase the item

  Scenario Outline: Purchase the item on https://mystore-testlab.coderslab.pl
    Given Opened page https://mystore-testlab.coderslab.pl in browser1
    And Button Sign In on the homepage clicked1
    And Filled existing user's email and password1
    And Button Sign In on the authorization page clicked1
    And Clicked on the logo 'my store'1
    When Clicked on the item 'Hummingbird Printed Sweater'
    And Check discount 20%
    And Size <size> select
    And Quantity <quantity> selected
    And Clicked button Add to card
    And Clicked button Proceed to checkout on pop-up window
    And Clicked button Proceed to checkout on page Shopping cart
    And Confirmed address by clicking on button Continue
    And Chosen shipping method PrestaShop "pick up in store"
    And Confirmed shipping method by clicking on button Continue
    And Chosen payment method Pay by Check
    And Checked checkbox "I agree to the terms service"
    And Clicked button "Order with an obligation to pay"
    Then Create screenshot of confirmed order page
#    And Close browser

    Examples:
      | quantity |  | size |
      | 5        |  | M    |
