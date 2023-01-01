package ClassTest;

import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListTopicsTest extends BaseTest{
    LoginPage LoginPg;
    ListTopicsPage ListTopicPg;

    @Test
    public void ShowListTopics(){
        LoginPg = new LoginPage(driver);
        ListTopicPg = new ListTopicsPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(ListTopicPg.url_ListTopics);
        Assert.assertEquals(ListTopicPg.isTitleTopics(), "Research topics");
        Assert.assertTrue(ListTopicPg.isShowListTopics());
    }
}




