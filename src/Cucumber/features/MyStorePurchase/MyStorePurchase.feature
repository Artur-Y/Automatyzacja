#wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
#wybierze rozmiar M (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
#wybierze 5 sztuk według parametru podanego w teście (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
#dodaj produkt do koszyka,
#przejdzie do opcji - checkout,
#potwierdzi address (możesz go dodać wcześniej ręcznie),
#wybierze metodę odbioru - PrestaShop "pick up in store",
#wybierze opcję płatności - Pay by Check,
#kliknie na "order with an obligation to pay",
#zrobi screenshot z potwierdzeniem zamówienia i kwotą.

Feature: Purchase the item

  Scenario Outline: Purchase the item on https://mystore-testlab.coderslab.pl
    Given Opened page https://mystore-testlab.coderslab.pl in browser1
    And Button Sign In on the homepage clicked1
    And Filled existing user's email and password1
    And Button Sign In on the authorization page clicked1
    And Clicked on the logo 'my store'1
    When Clicked on the item 'Hummingbird Printed Sweater'
    And Size M selected
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
      | quantity |
      | 5        |
