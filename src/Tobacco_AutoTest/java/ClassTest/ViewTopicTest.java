package ClassTest;
import ClassPage.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewTopicTest extends BaseTest {
    LoginPage LoginPg;
    ViewTopicPage ViewTopicPg;

    @Test
    public void ViewDetailTopic(){
        LoginPg = new LoginPage(driver);
        ViewTopicPg = new ViewTopicPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ViewTopicPg.url_ListTopic);
        Assert.assertTrue(ViewTopicPg.ViewDetailTopic(1));
    }
}
