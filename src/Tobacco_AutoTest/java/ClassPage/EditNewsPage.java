package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EditNewsPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_ListNews = "http://103.226.249.46:4000/newsdailies";
    public int row;

    public EditNewsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void EditNews(int option) throws InterruptedException {
//        Click icon Sửa tại list
        WebElement icon_Edit = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr["+row+"]/td[6]/div/a[3]"))));
        icon_Edit.click();
//        Click btn Lưu
        WebElement btn_Update = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button.btn-default:nth-child(1)"))));
        btn_Update.click();
        Thread.sleep(3000);
//        Gán nhãn cho bài báo (Xử lý radio btn)
        //        option: 1. không xác định, 2. ủng hộ ngành y tế, 3. ủng hộ ngành công nghiệp.
        List<WebElement> list_radiobtn = driver.findElements(By.name("flexRadioDefault"));
        System.out.println(list_radiobtn.size());
        WebElement radio_Tag = list_radiobtn.get(option);
        radio_Tag.click();
//        Click btn Submit
        driver.findElement(By.cssSelector("#btn_submit_group")).click();
//        Xử lý toast message thông báo
        String toastMessage = driver.findElement(By.className("message")).getText();
        Assert.assertEquals(toastMessage, "Submit success!");
    }
}
