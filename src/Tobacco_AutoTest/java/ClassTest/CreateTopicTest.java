package ClassTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import ClassPage.*;

public class CreateTopicTest extends BaseTest {
    LoginPage LoginPg;
    CreateTopicPage CreateTopicPg;

    @Test
    public void CreateTopicFullField(){
        LoginPg = new LoginPage(driver);
        CreateTopicPg = new CreateTopicPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateTopicPg.url_ListTopic);
        int topic_Bef = CreateTopicPg.CountTopic();
        driver.get(CreateTopicPg.url_Topic);
        CreateTopicPg.CreateTopic(
                "Thuế và buôn lậu",
                "Admin Local",
                "Actived"
        );
        driver.get(CreateTopicPg.url_ListTopic);
        int topic_Aft = CreateTopicPg.CountTopic();
        Assert.assertNotEquals(topic_Aft,topic_Bef);
    }

    @Test
    public void CreateTopicAField(){
        LoginPg = new LoginPage(driver);
        CreateTopicPg = new CreateTopicPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateTopicPg.url_ListTopic);
        int topic_Bef = CreateTopicPg.CountTopic();
        driver.get(CreateTopicPg.url_Topic);
        CreateTopicPg.CreateTopic("Thuế và buôn lậu","","");
        driver.get(CreateTopicPg.url_ListTopic);
        int topic_Aft = CreateTopicPg.CountTopic();
        Assert.assertEquals(topic_Aft,topic_Bef);
    }

    @Test
    public void CreateTopicBlankField(){
        LoginPg = new LoginPage(driver);
        CreateTopicPg = new CreateTopicPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateTopicPg.url_ListTopic);
        int topic_Bef = CreateTopicPg.CountTopic();
        driver.get(CreateTopicPg.url_Topic);
        CreateTopicPg.CreateTopic("","","");
        driver.get(CreateTopicPg.url_ListTopic);
        int topic_Aft = CreateTopicPg.CountTopic();
        Assert.assertEquals(topic_Aft,topic_Bef);
    }
}
