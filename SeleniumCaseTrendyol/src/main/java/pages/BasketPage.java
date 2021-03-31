package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasketPage extends BasePage {
    private By proNumber=By.className("visible");
    private By productInfo=By.className("pb-item");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void productNumber(){
        String expected="1";
        String actual= driver.findElement((proNumber)).getText();
        Assert.assertEquals(actual,expected);

    }

    public void ProductInfo(){
        driver.findElement(productInfo).getText();
        System.out.println(productInfo);
    }
}
