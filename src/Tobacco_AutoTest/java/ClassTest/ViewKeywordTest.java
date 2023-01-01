package ClassTest;

import ClassPage.LoginPage;
import ClassPage.ViewKeywordPage;
import ClassPage.ViewNewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewKeywordTest extends BaseTest {
    LoginPage LoginPg;
    ViewKeywordPage ViewKeywordPg;

    @Test
    public void ViewDetailKeyword(){
        LoginPg = new LoginPage(driver);
        ViewKeywordPg = new ViewKeywordPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ViewKeywordPg.url_ListKeyword);
        Assert.assertTrue(ViewKeywordPg.ViewDetailKeyword(1));
    }
}
