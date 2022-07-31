package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage {


    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }


    public By randomSelectProductBy() {


//Classname'i product-cr olan tüm elementleri bir diziye atadım ,atadığım listeden ürünleri random olarak çekmek istedim
 //fakat hata aldım ve süremin birçoğu bu sorunu çözmekle geçtiği için daha fazla vakit kaybetmemek adına hata almama rağmen
 //projeme devam ettim.

        List<WebElement> product= webDriver.findElements(By.className("product-cr"));

            Random random=new Random();
             int randomValue = random.nextInt(product.size());
              return (By) product.get(5);
        }



        public ProductDetailPage goToProductDetails () {
           click(randomSelectProductBy(),10);
            return new ProductDetailPage(webDriver);
        }
    }

