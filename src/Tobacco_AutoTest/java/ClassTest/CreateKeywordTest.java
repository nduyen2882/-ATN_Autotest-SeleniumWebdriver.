package ClassTest;

import ClassPage.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateKeywordTest extends BaseTest {
    LoginPage LoginPg;
    CreateKeywordPage CreateKeywordPg;

    @Test
    public void CreateKeywordFullField(){
        LoginPg = new LoginPage(driver);
        CreateKeywordPg = new CreateKeywordPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(CreateKeywordPg.url_ListKeyword);
        int key_before = CreateKeywordPg.CountKeyword();
        driver.get(CreateKeywordPg.url_Keyword);
        CreateKeywordPg.CreateKeyword(
                "Thuế và buôn lậu",
                "Thuế tiêu thụ đường",
                "Firefox",
                "Thuế, đường"
        );
        driver.get(CreateKeywordPg.url_ListKeyword);
        int key_after = CreateKeywordPg.CountKeyword();
        Assert.assertNotEquals(key_after, key_before);
    }
}

