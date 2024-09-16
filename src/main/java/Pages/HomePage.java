package Pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "shopping_cart_link")
    WebElement cartButton;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(linkText = "Twitter")
    WebElement twitterLink;

    @FindBy(linkText = "Facebook")
    WebElement facebookLink;

    @FindBy(linkText = "LinkedIn")
    WebElement linkedInLink;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart(String productName) {
        System.out.println(productName + "\n");
        String productId = "add-to-cart-" + productName.replace(" ", "-").toLowerCase();
        System.out.println(productId);
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(cartBadge));
    }


    public int getCartItemCount() {
        String itemCountText = cartBadge.getText();
        return Integer.parseInt(itemCountText);
    }

    public void clickCartButton() {cartButton.click();}

    public void clickOnSocialLinkAndVerify(String socialNetwork) {
        WebElement socialLink = null;
        String expectedUrl = "";

        // Seleccionar el enlace adecuado y la URL esperada según la red social
        switch(socialNetwork.toLowerCase()) {
            case "twitter":
                socialLink = twitterLink;
                expectedUrl = "x.com/saucelabs";  // URL de Twitter
                break;
            case "facebook":
                socialLink = facebookLink;
                expectedUrl = "facebook.com/saucelabs";  // URL de Facebook
                break;
            case "linkedin":
                socialLink = linkedInLink;
                expectedUrl = "linkedin.com/company/sauce-labs";  // URL de LinkedIn
                break;
        }
        socialLink.click();

        // Cambiar al contexto de la nueva pestaña que se abre
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));  // Cambia a la segunda pestaña

        // Verificar que la URL sea correcta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains(expectedUrl));

        // Cerrar la pestaña actual y volver a la pestaña original
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

}
