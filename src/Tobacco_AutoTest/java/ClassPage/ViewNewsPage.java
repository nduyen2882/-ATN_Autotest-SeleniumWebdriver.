package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewNewsPage {
    WebDriver driver;
    public String url_ListNews = "http://103.226.249.46:4000/newsdailies";

    public ViewNewsPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean ViewDetailNews(int row){
//        đợi load trang cho tới khi click được nút phân trang
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[1]/td[6]/div/a[2]/i")));
//        click icon [view]
        driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[6]/div/a[2]/i")).click();
//        kiểm tra hiển thị màn view chi tiết thông qua title.
        return driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div[1]/div[1]/h3")).isDisplayed();
    }
}
