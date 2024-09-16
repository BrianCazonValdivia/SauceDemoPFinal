package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeStep {

    HomePage homePage = new HomePage(DriverManager.getDriver().driver);


    @Then("I order products {string}")
    public void orderdSomeProducts(String producto) {
        homePage.addProductToCart(producto);
    }

    @When("I click on the cart button")
    public void iClickOnTheCartButton() {
        homePage.clickCartButton();
    }

    @And("I click on the {string} link and verify redirection")
    public void iClickOnSocialLinkAndVerifyRedirection(String socialNetwork) {
        homePage.clickOnSocialLinkAndVerify(socialNetwork);
    }

    @Then("The cart item count should be {int}")
    public void theCartItemCountShouldBe(int expectedCount) {
        int actualCount = homePage.getCartItemCount();
        Assert.assertEquals("El número de artículos en el carrito no es el esperado", expectedCount, actualCount);
    }


}
