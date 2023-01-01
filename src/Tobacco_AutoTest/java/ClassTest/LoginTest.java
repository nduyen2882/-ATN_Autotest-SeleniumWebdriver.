package ClassTest;

import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPg;
    @Test
    public void LoginWithAccount(){
        loginPg = new LoginPage(driver);
        loginPg.Login("local-user","Qazxsw@123");
        Assert.assertEquals(driver.getCurrentUrl(), url_Homepage);
    }

    @Test
    public void LoginWithBlankField(){
        loginPg = new LoginPage(driver);
        loginPg.Login("","");
        Assert.assertEquals(driver.getCurrentUrl(), url_Homepage);
    }

    @Test
    public void LoginWithUserName(){
        loginPg = new LoginPage(driver);
        loginPg.Login("local-user","123456");
        Assert.assertEquals(driver.getCurrentUrl(), url_Homepage);
    }

    @Test
    public void LoginWithPassword(){
        loginPg = new LoginPage(driver);
        loginPg.Login("ntduyen","Qazxsw@123");
        Assert.assertEquals(driver.getCurrentUrl(), url_Homepage);
    }
}
