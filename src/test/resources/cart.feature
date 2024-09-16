Feature: Cart feature
  Background: The infomration obout the carrito
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

  #Test 1 Carrito vacio
  Scenario: Check that the cart does not have to be empty
      When I click on the cart button
      Then The cart should no be empty

  #Test 2 de que todos los productos añadidos se muestren en tu carrito
  Scenario: Check the products added on the cart
    Then I order products "Sauce Labs Backpack"
    Then I order products "Sauce Labs Bike Light"
    Then Check the products name






