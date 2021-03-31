import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import user.UserPage;

public class TrendyolTest extends BaseTest{

    @Test
    public void searchTest() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        SearchResultPage searchResultPage= homePage.hoverElement();
        Thread.sleep(4000);
        BasketPage basketPage=new BasketPage(driver);
        searchResultPage.addToBasketFirstProduct();
        Thread.sleep(4000);
        String titleOne = searchResultPage.getFirstProductTitle();
        System.out.println("TitleOne :" +titleOne);
        String titleTwo = searchResultPage.getBasketTitle();
        System.out.println("TitleTwo : "+titleTwo);
        Assert.assertEquals(titleOne,titleTwo);
        searchResultPage.basketItem();
        basketPage.productNumber();
        Thread.sleep(4000);
        GetMail getMail = new GetMail(driver);
        UserPage user = new UserPage();
        user.setEmail(getMail.getMail());
        MemberLoginPage memberLoginPage = new MemberLoginPage(driver);
        memberLoginPage.goToLoginPage();
        homePage= memberLoginPage.signUp(user.getEmail(), user.getPassword());
        String actualText =  homePage.getAccountText();
        String expectedText = "Hesabım";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void searchTwoTest() throws InterruptedException {
        HomePage homePage=new HomePage(driver);
        SearchResultPage searchResultPage=homePage.selectHoverElement();
        searchResultPage.clickRadioButton();
        Thread.sleep(4000);
        searchResultPage.addBasketFirstProduct();
        Thread.sleep(6000);
        searchResultPage.basketItem();
        Thread.sleep(4000);

    }

}
