package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    private By productTitleBy=By.xpath("//a[@href='/xiaomi-x-b101939']");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By addBasket=By.className("add-to-bs");


}
