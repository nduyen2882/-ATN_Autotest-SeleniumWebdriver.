package ClassTest;

import ClassPage.EditArgumentPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditArgumentTest extends BaseTest {
    LoginPage LoginPg;
    EditArgumentPage EditArgPg;

    @Test
    public void EditArgFullField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        EditArgPg = new EditArgumentPage(driver);
        EditArgPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditArgPg.url_ListArg);
        String topicBefore = EditArgPg.ValueTopic(); /* Lấy giá trị của trường topic trước khi sửa */
        String nameBefore = EditArgPg.ValueName(); /* Lấy giá trị của trường name trước khi sửa */
        EditArgPg.CLickIconEdit();
        EditArgPg.edit_topic(1);
        EditArgPg.edit_name("FDII");
        EditArgPg.ClickBtnUpdate();
        driver.get(EditArgPg.url_ListArg);
        String topicAfter = EditArgPg.ValueTopic();
        String nameAfter = EditArgPg.ValueName();
        Assert.assertNotEquals(topicAfter, topicBefore);
        Assert.assertNotEquals(nameAfter, nameBefore);
    }

    @Test
    public void EditArgAField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        EditArgPg = new EditArgumentPage(driver);
        EditArgPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditArgPg.url_ListArg);
        String nameBefore = EditArgPg.ValueName(); /* Lấy giá trị của trường name trước khi sửa */
        EditArgPg.CLickIconEdit();
        EditArgPg.edit_name("ngành nghề buôn bán");
        EditArgPg.ClickBtnUpdate();
        driver.get(EditArgPg.url_ListArg);
        String nameAfter = EditArgPg.ValueName();
        Assert.assertNotEquals(nameAfter, nameBefore);
    }
}
