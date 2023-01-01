package ClassTest;

import ClassPage.DeleteNewsPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNewsTest extends BaseTest{
    LoginPage LoginPg;
    DeleteNewsPage DeleteNewsPg;

    @Test
    public void DeleteWithIconDelete() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        DeleteNewsPg = new DeleteNewsPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteNewsPg.url_ListNews);
        Thread.sleep(3000);
        int News_before = DeleteNewsPg.CountNews();
        DeleteNewsPg.DeleteNewsWithIcon(4);
        driver.get(DeleteNewsPg.url_ListNews);
        int News_after = DeleteNewsPg.CountNews();
        Assert.assertNotEquals(News_after, News_before);
    }
}
