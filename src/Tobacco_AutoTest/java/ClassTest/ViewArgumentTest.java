package ClassTest;

import ClassPage.LoginPage;
import ClassPage.ViewArgumentPage;
import ClassPage.ViewKeywordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewArgumentTest extends BaseTest {
    LoginPage LoginPg;
    ViewArgumentPage ViewArgumentPg;

    @Test
    public void ViewDetailArgument(){
        LoginPg = new LoginPage(driver);
        ViewArgumentPg = new ViewArgumentPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ViewArgumentPg.url_ListArg);
        Assert.assertTrue(ViewArgumentPg.ViewDetailArg(1));
    }
}
