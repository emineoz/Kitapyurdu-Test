package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    By addToCardBottom = By.xpath("//*[@id=\"button-cart\"]");
    By NumberOfBasket=By.id("//*[@id=\"cart-items-text\"]");
    By goToCard=By.id("js-cart");


    public void addToBasket(){
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        click(addToCardBottom,10);
    }

    public String NumberOfProducts(){

        return webDriver.findElement(NumberOfBasket).getText();
    }

    public BasketPage goToBasket() {
        click(goToCard, 10);
        return new BasketPage(webDriver);
    }
}