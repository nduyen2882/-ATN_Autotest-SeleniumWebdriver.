package ClassTest;

import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListArgumentTest extends BaseTest{
    LoginPage LoginPg;
    ListArgumentPage ListArgumentPg;

    @Test ()
    public void ShowListArguments(){
        LoginPg = new LoginPage(driver);
        ListArgumentPg = new ListArgumentPage(driver);

        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ListArgumentPg.url_ListArgument);
        Assert.assertEquals(ListArgumentPg.isTitleArgument(), "Arguments");
        Assert.assertTrue(ListArgumentPg.isShowListArgument());
    }
}
