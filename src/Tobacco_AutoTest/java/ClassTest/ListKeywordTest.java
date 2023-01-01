package ClassTest;

import ClassPage.*;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListKeywordTest extends BaseTest{
    LoginPage LoginPg;
    ListKeywordPage ListKeywordPg;

    @Test
    public void ShowListKey() {
        LoginPg = new LoginPage(driver);
        ListKeywordPg = new ListKeywordPage(driver);

        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ListKeywordPg.url_ListKey);
        Assert.assertEquals(ListKeywordPg.isTitleKeyword(), "Keywords");
        Assert.assertTrue(ListKeywordPg.isShowListKeyword());
    }
}
