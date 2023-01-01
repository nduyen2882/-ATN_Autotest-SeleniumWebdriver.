package ClassTest;
import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListNewsTest extends BaseTest{
    LoginPage LoginPg;
    ListNewsPage ListNewsPg;

    @Test
    public void ShowListNews(){
        LoginPg = new LoginPage(driver);
        ListNewsPg = new ListNewsPage(driver);

        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ListNewsPg.url_ListNews);
        Assert.assertEquals(ListNewsPg.isTitleNews(), "News");
        Assert.assertTrue(ListNewsPg.isShowListNews());
    }
}
