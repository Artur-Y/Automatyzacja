

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
    Given Opened page https://mystore-testlab.coderslab.pl in browser
    And Button Sign In on the homepage clicked
    And Filled existing user's email and password
    And Button Sign In on the authorization page clicked
    And Click on the item "Hummingbird Printed Sweater"


    Examples:
