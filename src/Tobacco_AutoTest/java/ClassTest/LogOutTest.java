package ClassTest;
import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{
    LoginPage LoginPg;
    LogOutPage LogoutPg;

    @Test
    public void LogOut(){
        LoginPg = new LoginPage(driver);
        LogoutPg = new LogOutPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        String currentUrl = driver.getCurrentUrl();
        LogoutPg.LogOut();
        Assert.assertEquals(driver.getCurrentUrl(), currentUrl);
    }
}
