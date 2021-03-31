package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GetMail extends BasePage {

    private String mailUrl = "https://10minutemail.net/?lang=tr";
    private By mailText = By.id("fe_text");

    public GetMail(WebDriver driver){
        super(driver);
    }

    public String getMail(){

        driver.get(mailUrl);
        return driver.findElement(mailText).getAttribute("value");
    }
}
