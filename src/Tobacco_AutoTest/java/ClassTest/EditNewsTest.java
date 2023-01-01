package ClassTest;

import ClassPage.EditNewsPage;
import ClassPage.EditNewsPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditNewsTest extends BaseTest {
    LoginPage LoginPg;
    EditNewsPage EditNewsPg;

    @Test
    public void EditNewsFullField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        EditNewsPg = new EditNewsPage(driver);
        EditNewsPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditNewsPg.url_ListNews);
        Thread.sleep(3000);
        EditNewsPg.EditNews(2);
    }
    @Test
    public void EditNewsAField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        EditNewsPg = new EditNewsPage(driver);
        EditNewsPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditNewsPg.url_ListNews);
        Thread.sleep(3000);
        EditNewsPg.EditNews(2);
    }
}
