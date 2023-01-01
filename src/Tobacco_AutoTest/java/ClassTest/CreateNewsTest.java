package ClassTest;

import ClassPage.CreateArgumentPage;
import ClassPage.CreateNewsPage;
import ClassPage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewsTest extends BaseTest{
    LoginPage LoginPg;
    CreateNewsPage CreateNewsPg;

    @Test
    public void CreateNewsFullField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        CreateNewsPg = new CreateNewsPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
//        Số lượng bản ghi tại trang cuối cùng trước khi thêm mới
        driver.get(CreateNewsPg.url_ListNews);
        int arg_before = CreateNewsPg.CountNews();
        System.out.println(arg_before);

//        Thêm tin mới
        driver.get(CreateNewsPg.url_News);
        CreateNewsPg.CreateNew(
                "Cảnh báo: Gia tăng tỉ lệ sử dụng thuốc lá điện tử trong giới trẻ",
                "Việc sử dụng các chất kích thích, chất gây nghiện ở học đường hiện nay đang là hiện tượng đáng báo động.");

//        Số lượng bản ghi tại trang cuối cùng sau khi thêm mới
        driver.get(CreateNewsPg.url_ListNews);
        int arg_after = CreateNewsPg.CountNews();
        System.out.println(arg_after);
        Assert.assertNotEquals(arg_after, arg_before);
    }

    @Test
    public void CreateNewsAField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        CreateNewsPg = new CreateNewsPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");

        driver.get(CreateNewsPg.url_ListNews);
        int arg_before = CreateNewsPg.CountNews();

        driver.get(CreateNewsPg.url_News);
        CreateNewsPg.CreateNew("Cảnh báo: Gia tăng tỉ lệ sử dụng thuốc lá điện tử trong giới trẻ","");

        driver.get(CreateNewsPg.url_ListNews);
        int arg_after = CreateNewsPg.CountNews();
        Assert.assertEquals(arg_after, arg_before);
    }

    @Test
    public void CreateNewsBlankField() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        CreateNewsPg = new CreateNewsPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");

        driver.get(CreateNewsPg.url_ListNews);
        int arg_before = CreateNewsPg.CountNews();

        driver.get(CreateNewsPg.url_News);
        CreateNewsPg.CreateNew("","");

        driver.get(CreateNewsPg.url_ListNews);
        int arg_after = CreateNewsPg.CountNews();
        Assert.assertEquals(arg_after, arg_before);
    }
}
