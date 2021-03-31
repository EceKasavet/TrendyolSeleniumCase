package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

import java.util.List;

public class HomePage extends BasePage {

    Actions actions;


    private By accountButtonBy = By.className("account-user");
    private By electronicMenuBy = By.xpath("//a[@href='/butik/liste/elektronik']");
    private By tvMenuBy = By.xpath("//a[@href='/tv-goruntu-ses-sistemleri-x-c104035']");
    private By componentListBy = By.className("component-list");


    //Senaryo supermarket - gıda seç
    private By supermarketMenuBy =By.xpath("//a[@href='/butik/liste/supermarket']");
    private By gıdaMenuBy=By.xpath("//a[@href='/kuru-gida-urunleri-x-c103970']");

    public HomePage(WebDriver driver){
        super(driver);
        actions = new Actions(driver);
    }

    public void checkTitle() {
        String expectedTitle="En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        String actualTitle=driver.getTitle();
        System.out.println("Actual Title is:" + actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    public String getAccountText() {
        return getText(accountButtonBy);
    }

    public SearchResultPage hoverElement(){
        moveToElement(electronicMenuBy);
        click(tvMenuBy,3);
        return new SearchResultPage(driver);
    }

    //2.senaryo
    public SearchResultPage selectHoverElement(){
        moveToElement(supermarketMenuBy);
        click(gıdaMenuBy,3);
        return new SearchResultPage(driver);
    }


    public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(componentListBy));
    }



}
