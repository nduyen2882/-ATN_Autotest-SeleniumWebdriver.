package ClassTest;

import ClassPage.LoginPage;
import ClassPage.ViewNewsPage;
import ClassPage.ViewTopicPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewNewsTest extends BaseTest {
    LoginPage LoginPg;
    ViewNewsPage ViewNewsPg;

    @Test
    public void ViewDetailNews(){
        LoginPg = new LoginPage(driver);
        ViewNewsPg = new ViewNewsPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ViewNewsPg.url_ListNews);
        Assert.assertTrue(ViewNewsPg.ViewDetailNews(1));
    }
}
