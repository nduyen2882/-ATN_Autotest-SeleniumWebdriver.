package ClassTest;
import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteTopicTest extends BaseTest{
    LoginPage LoginPg;
    DeleteTopicPage DeleteTopicPg;

    @Test
    public void DeleteWithIconDelete(){
        LoginPg = new LoginPage(driver);
        DeleteTopicPg = new DeleteTopicPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteTopicPg.url_ListTopic);
        int topic_before = DeleteTopicPg.CountTopic();
        DeleteTopicPg.DeleteTopicWithIcon(2);
        driver.get(DeleteTopicPg.url_ListTopic);
        int topic_after = DeleteTopicPg.CountTopic();
        Assert.assertNotEquals(topic_after, topic_before);
    }

    @Test
    public void DeleteWithViewScreen(){
        LoginPg = new LoginPage(driver);
        DeleteTopicPg = new DeleteTopicPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(DeleteTopicPg.url_ListTopic);
        int topic_before = DeleteTopicPg.CountTopic();
        DeleteTopicPg.DeleteTopicWithView(1);
        driver.get(DeleteTopicPg.url_ListTopic);
        int topic_after = DeleteTopicPg.CountTopic();
        Assert.assertNotEquals(topic_after, topic_before);
    }
}
