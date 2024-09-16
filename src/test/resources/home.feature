Feature: Home feature

  Background: User login into Sauce Demo
    Given I am in sauce demo web page
    When I set the user name text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button

    #Test 4: verificando que al darle click a los links de redes sociales funcionen correctamenet

    Scenario: Verify redirection to social media pages
      And I click on the "Twitter" link and verify redirection
      And I click on the "Facebook" link and verify redirection
      And I click on the "LinkedIn" link and verify redirection
    #Test 5: Verifica que al añadir productos el numero del icono de carrito incremente correctamente

    Scenario: Verify cart item count increments when products are added
      Then I order products "Sauce Labs Backpack"
      Then I order products "Sauce Labs Bike Light"
      Then The cart item count should be 2
