package ClassTest;

import ClassPage.DeleteArgumentPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteArgumentTest extends BaseTest{
    LoginPage LoginPg;
    DeleteArgumentPage DeleteArgPg;

    @Test
    public void DeleteWithIconDelete(){
        LoginPg = new LoginPage(driver);
        DeleteArgPg = new DeleteArgumentPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteArgPg.url_ListArg);
        int Arg_before = DeleteArgPg.CountArg();
        DeleteArgPg.DeleteArgWithIcon(2);
        driver.get(DeleteArgPg.url_ListArg);
        int Arg_after = DeleteArgPg.CountArg();
        Assert.assertNotEquals(Arg_after, Arg_before);
    }

    @Test
    public void DeleteWithViewScreen(){
        LoginPg = new LoginPage(driver);
        DeleteArgPg = new DeleteArgumentPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteArgPg.url_ListArg);
        int Arg_before = DeleteArgPg.CountArg();
        DeleteArgPg.DeleteArgWithBtn(1);
        driver.get(DeleteArgPg.url_ListArg);
        int Arg_after = DeleteArgPg.CountArg();
        Assert.assertNotEquals(Arg_after, Arg_before);
    }
}
