Feature: Checkout Step One feature
  Background: User login into Sauce Demo and some products added to the cart
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then I order products "Sauce Labs Backpack"
    Then I order products "Sauce Labs Bike Light"
    And I click on the cart button
    And I click on checkout button

    #Test 3 verifica que exista un control si no se llenan los datos del Checkout
  @Rune
  Scenario: Verify error message when fields are empty
    And Set the name with ""
    And Set the lastname with ""
    And Set the Postal Code with ""
    And Click on Continue Button
    Then The error message "Error: First Name is required" should be displayed
