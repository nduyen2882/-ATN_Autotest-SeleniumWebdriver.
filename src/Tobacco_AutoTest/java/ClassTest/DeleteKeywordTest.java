package ClassTest;

import ClassPage.DeleteKeywordPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteKeywordTest extends BaseTest{
    LoginPage LoginPg;
    DeleteKeywordPage DeleteKeyPg;

    @Test
    public void DeleteWithIconDelete(){
        LoginPg = new LoginPage(driver);
        DeleteKeyPg = new DeleteKeywordPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteKeyPg.url_ListKey);
        int Key_before = DeleteKeyPg.CountKey();
        DeleteKeyPg.DeleteKeyWithIcon(2);
        driver.get(DeleteKeyPg.url_ListKey);
        int Key_after = DeleteKeyPg.CountKey();
        Assert.assertNotEquals(Key_after, Key_before);
    }

    @Test
    public void DeleteWithViewScreen(){
        LoginPg = new LoginPage(driver);
        DeleteKeyPg = new DeleteKeywordPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteKeyPg.url_ListKey);
        int Key_before = DeleteKeyPg.CountKey();
        DeleteKeyPg.DeleteKeyWithBtn(2);
        driver.get(DeleteKeyPg.url_ListKey);
        int Key_after = DeleteKeyPg.CountKey();
        Assert.assertNotEquals(Key_after, Key_before);
    }
}
