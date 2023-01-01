package ClassTest;

import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateArgumentTest extends BaseTest{
    LoginPage LoginPg;
    CreateArgumentPage CreateArgumentPg;

    @Test
    public void CreateArgFullField(){
        LoginPg = new LoginPage(driver);
        CreateArgumentPg = new CreateArgumentPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateArgumentPg.url_ListArgument);
        int arg_before = CreateArgumentPg.CountArgument();
        driver.get(CreateArgumentPg.url_Argument);
        CreateArgumentPg.CreateArgument("Thuế và buôn lậu","FDI","27");
        driver.get(CreateArgumentPg.url_ListArgument);
        int arg_after = CreateArgumentPg.CountArgument();
        Assert.assertNotEquals(arg_after, arg_before);
    }

    @Test
    public void CreateArgAField(){
        LoginPg = new LoginPage(driver);
        CreateArgumentPg = new CreateArgumentPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateArgumentPg.url_ListArgument);
        int arg_before = CreateArgumentPg.CountArgument();
        driver.get(CreateArgumentPg.url_Argument);
        CreateArgumentPg.CreateArgument("","FDI","");
        driver.get(CreateArgumentPg.url_ListArgument);
        int arg_after = CreateArgumentPg.CountArgument();
        Assert.assertEquals(arg_after, arg_before);
    }

    @Test
    public void CreateArgBlankField(){
        LoginPg = new LoginPage(driver);
        CreateArgumentPg = new CreateArgumentPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateArgumentPg.url_ListArgument);
        int arg_before = CreateArgumentPg.CountArgument();
        driver.get(CreateArgumentPg.url_Argument);
        CreateArgumentPg.CreateArgument("","","");
        driver.get(CreateArgumentPg.url_ListArgument);
        int arg_after = CreateArgumentPg.CountArgument();
        Assert.assertEquals(arg_after, arg_before);
    }
}
