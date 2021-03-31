package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private By emailBy = By.id("login-email");
    private By passwordBy = By.id("login-password-input");
    private By submitBy = By.className("submit");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(User user) {
        sendKeys(emailBy, user.getEmail());
        sendKeys(passwordBy, user.getPassword());
        click(submitBy, 5);

        HomePage homePage = new HomePage(driver);
        homePage.waitForLoad();

        return homePage; }
}