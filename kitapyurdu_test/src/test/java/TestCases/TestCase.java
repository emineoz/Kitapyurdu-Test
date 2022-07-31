package TestCases;

import Pages.*;
import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase extends BaseTest {


    HomePage homePage;

    ProductDetailPage productDetailPage;
    BasketPage basketPage = new BasketPage(webDriver);


    String title = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
     String number="1";
     String updateMessage="Sepetiniz güncelleniyor!";
     String expectedEmptyMessage="Sepetinizdeki ürünleri görmek için üye girişi yapmanız gerekmektedir.";

    @Test
    @Order(1)
    public void kitapyurdutest() throws InterruptedException, IOException {

        HomePage homePage = new HomePage(webDriver);
        String webDriverTitle = homePage.getHomePageTitle();
        Log4j.info("Title: " + webDriverTitle);
        assertEquals("Titles did not match", webDriverTitle, title);
        Log4j.info("Titles did match");

    }

    @Test
    @Order(2)
    public void search_a_product() throws InterruptedException {
        HomePage homePage = new HomePage(webDriver);
        Log4j.info("The word 'roman' is entered in the search box.");
        SearchResultPage searchResultPage = homePage.search("roman");
        searchResultPage.scrollToPage("750");
        searchResultPage.goToProductDetails();

    }

     @Test
     @Order(3)
     public void add_product_to_cart() {
        Log4j.info("The selected product is added to the basket.");
        productDetailPage.addToBasket();
        String productNUmber= productDetailPage.NumberOfProducts();
        assertEquals("numbers did not match",number,productNUmber );
        Log4j.info("Go To Basket Page");
        productDetailPage.goToBasket();
    }
    @Test
    @Order(4)
    public void increaseProduct() throws InterruptedException {
        Log4j.info("The number of products has been increased");
        basketPage.increaseProcut();
        basketPage.update();
    }

    @Test
    @Order(5)
    public void updateMessage(){
        String message=basketPage.updateMessage();
        assertEquals("Basket message update did not match",updateMessage,message);
    }
    @Test
    @Order(6)
    public void BasketMessage(){
        String emptyMessage=basketPage.deleteItem();
        assertEquals("Basket is empty messages did not match",expectedEmptyMessage,emptyMessage);

    }

}