package ClassTest;
import ClassPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditTopicTest extends BaseTest {
    LoginPage LoginPg;
    EditTopicPage EditTopicPg;

    @Test
    public void EditTopicFullField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        EditTopicPg = new EditTopicPage(driver);
        EditTopicPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditTopicPg.url_ListTopic);
        String topicBefore = EditTopicPg.ValueTopic(); /* Lấy giá trị của trường topic trước khi sửa */
        String assignBefore = EditTopicPg.ValueAssign(); /* Lấy giá trị của trường assign trước khi sửa */
        String workingBefore = EditTopicPg.ValueWorking(); /* Lấy giá trị của trường working trước khi sửa */
        EditTopicPg.CLickIconEdit();
        EditTopicPg.edit_topic(0);
        EditTopicPg.edit_assign(14);
        EditTopicPg.edit_working(1);
        EditTopicPg.ClickBtnUpdate();
        driver.get(EditTopicPg.url_ListTopic);
        String topicAfter = EditTopicPg.ValueTopic();
        String assignAfter = EditTopicPg.ValueAssign();
        String workingAfter = EditTopicPg.ValueWorking();
        Assert.assertNotEquals(topicAfter, topicBefore);
        Assert.assertNotEquals(assignAfter, assignBefore);
        Assert.assertNotEquals(workingAfter, workingBefore);
    }

    @Test
    public void EditTopicAField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        EditTopicPg = new EditTopicPage(driver);
        EditTopicPg.row = 2; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditTopicPg.url_ListTopic);
        String topicBefore = EditTopicPg.ValueTopic(); /* Lấy giá trị của trường topic trước khi sửa */
        String assignBefore = EditTopicPg.ValueAssign(); /* Lấy giá trị của trường assign trước khi sửa */
        String workingBefore = EditTopicPg.ValueWorking(); /* Lấy giá trị của trường working trước khi sửa */
        EditTopicPg.CLickIconEdit();
        EditTopicPg.edit_topic(0);
        EditTopicPg.ClickBtnUpdate();
        driver.get(EditTopicPg.url_ListTopic);
        String topicAfter = EditTopicPg.ValueTopic();
        String assignAfter = EditTopicPg.ValueAssign();
        String workingAfter = EditTopicPg.ValueWorking();
        Assert.assertNotEquals(topicAfter, topicBefore);
        Assert.assertEquals(assignAfter, assignBefore);
        Assert.assertEquals(workingAfter, workingBefore);
    }
}
