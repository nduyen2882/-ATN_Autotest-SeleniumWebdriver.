package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ViewTopicPage {
    WebDriver driver;
    public String url_ListTopic = "http://103.226.249.46:4000/assignedtopics";

    public ViewTopicPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean ViewDetailTopic(int row){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.pagination-page:nth-child(3) > a:nth-child(1)")));
//        click icon [view]
        driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[8]/div/a[1]/i")).click();
//        kiểm tra hiển thị màn view chi tiết thông qua title.
        return driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[1]/h2")).isDisplayed();
    }
}
