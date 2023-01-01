package ClassTest;

import ClassPage.EditKeywordPage;
import ClassPage.EditKeywordPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditKeywordTest extends BaseTest {
    LoginPage LoginPg;
    EditKeywordPage EditKeyPg;

    @Test
    public void EditKeyFullField(){
        LoginPg = new LoginPage(driver);
        EditKeyPg = new EditKeywordPage(driver);
        EditKeyPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditKeyPg.url_ListKey);
        String topicBefore = EditKeyPg.ValueTopic(); /* Lấy giá trị của trường topic trước khi sửa */
        String nameBefore = EditKeyPg.ValueName(); /* Lấy giá trị của trường assign trước khi sửa */
        EditKeyPg.CLickIconEdit();
        EditKeyPg.edit_topic(1);
        EditKeyPg.edit_name("thuế tiêu thụ sp đường");
        EditKeyPg.ClickBtnUpdate();
        driver.get(EditKeyPg.url_ListKey);
        String topicAfter = EditKeyPg.ValueTopic();
        String nameAfter = EditKeyPg.ValueName();
        Assert.assertNotEquals(topicAfter, topicBefore);
        Assert.assertNotEquals(nameAfter, nameBefore);
    }

    @Test
    public void EditKeyAField(){
        LoginPg = new LoginPage(driver);
        EditKeyPg = new EditKeywordPage(driver);
        EditKeyPg.row = 1; /* Khai báo số thứ tự của bản ghi muốn sửa */
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(EditKeyPg.url_ListKey);
        String nameBefore = EditKeyPg.ValueName(); /* Lấy giá trị của trường assign trước khi sửa */
        EditKeyPg.CLickIconEdit();
        EditKeyPg.edit_name("thuế tiêu thụ đường");
        EditKeyPg.ClickBtnUpdate();
        driver.get(EditKeyPg.url_ListKey);
        String nameAfter = EditKeyPg.ValueName();
        Assert.assertNotEquals(nameAfter, nameBefore);
    }
}
