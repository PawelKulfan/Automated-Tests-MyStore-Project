Feature: Overall purchase process (choose product, add to cart, checkout, payment)
  Scenario: Registered user purchases product and checkout's
    Given An open browser with logged user
    When User adds parametrized product with size: XL and quantity: 3 to cart and checkout
    Then Shipping address confirmed, shipping and payment method chosen, order confirmed, prt scr of order confirmation done
    And Order is marked as awaiting check payment and payment value is same as in order summary