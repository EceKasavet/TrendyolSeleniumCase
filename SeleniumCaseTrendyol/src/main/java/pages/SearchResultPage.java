package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class SearchResultPage extends BasePage {

    private By acceptBasket=By.className("goBasket");
    private By listTvElement=By.className("srch-prdcts-cntnr");
    private By addToBasket = By.className("add-to-basket-button");
    private By prdocutTitle = By.className("prdct-desc-cntnr-ttl");
    private By basket = By.className("account-basket");



    //2.Senaryo
    private By radioPriceBy=By.xpath("//a[@href='/sr?wc=103970&prc=10-20']");
    private By productListBy=By.className("srch-prdcts-cntnr");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasketFirstProduct(){
        List<WebElement> productList =  driver.findElements(addToBasket);
        productList.get(0).click();
    }

    public ProductPage addBasketProduct(){
        List<WebElement> productList =  driver.findElements(listTvElement);
        productList.get(0).click();
        return new ProductPage(driver);
    }

    public String getFirstProductTitle(){
        List<WebElement> list = driver.findElements(prdocutTitle);
        String title = list.get(0).getAttribute("title");
        return title;
    }

    public String getBasketTitle(){
        moveToElement(By.className("account-basket"));
        String basketTitle =driver.findElement(By.className("brand")).getAttribute("title");
        return basketTitle;
    }

    public void clickRadioButton(){
        click(radioPriceBy,2);
    }

    public void addBasketFirstProduct(){
        List<WebElement> productList =  driver.findElements(addToBasket);
        productList.get(0).click();

    }

    public BasketPage basketItem(){
        moveToElement(By.className("account-basket"));
        click(acceptBasket,2);
        return new BasketPage(driver);
    }

}
