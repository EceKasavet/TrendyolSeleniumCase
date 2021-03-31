import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.GetMail;
import pages.HomePage;
import pages.MemberLoginPage;
import user.UserPage;

public class MemberLoginTest extends BaseTest {

   @Test
    public void successfulSignUp(){

        GetMail getMail = new GetMail(driver);
        UserPage user = new UserPage();
        user.setEmail(getMail.getMail());
        MemberLoginPage memberLoginPage = new MemberLoginPage(driver);
        memberLoginPage.goToLoginPage();
        HomePage homePage = memberLoginPage.signUp(user.getEmail(), user.getPassword());
        String actualText =  homePage.getAccountText();
        String expectedText = "Hesabım";
        Assert.assertEquals(actualText, expectedText);
    }
}
