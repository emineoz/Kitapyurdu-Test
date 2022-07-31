package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

    WebElement numberLocater= webDriver.findElement(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[4]/form/input[1]"));
   WebElement updateLocater=webDriver.findElement(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[4]/form/i"));
    By updateMessage=By.xpath("//*[@id=\"swal2-title\"]");
    WebElement deleteLocater=webDriver.findElement(By.xpath("\"//*[@id=\\\"cart_module\\\"]/div[1]/table/tbody/tr/td[8]/a/i\""));
    By cardEmptyMessageLocater=By.xpath("//*[@id=\"cart_module\"]/div[1]");

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void increaseProcut() throws InterruptedException {
        numberLocater.click();
        Thread.sleep(5);
        numberLocater.clear();
        Thread.sleep(5);
        numberLocater.sendKeys("2");


    }
    public void update(){
        updateLocater.click();
    }

    public String updateMessage(){
        System.out.println("update message:" + getText(updateMessage));
        return webDriver.findElement(updateMessage).getText();

    }

    public String deleteItem(){
        deleteLocater.click();
        System.out.println("card is empty message:" + getText(cardEmptyMessageLocater));
        return webDriver.findElement(cardEmptyMessageLocater).getText();
    }





}
