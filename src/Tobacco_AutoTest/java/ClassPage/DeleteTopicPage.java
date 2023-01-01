package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import java.time.Duration;
import java.util.List;

public class DeleteTopicPage {
    WebDriver driver;
    public String url_ListTopic = "http://103.226.249.46:4000/assignedtopics";

    public DeleteTopicPage(WebDriver driver){
        this.driver = driver;
    }

    public void DeleteTopicWithIcon(Integer row){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.pagination-page:nth-child(3) > a:nth-child(1)")));

        WebElement icon_Delete = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[8]/div/a[3]/i"))));
        icon_Delete.click();

        Alert alert_Delete = driver.switchTo().alert();
        alert_Delete.accept();
    }

    public void DeleteTopicWithView(Integer row){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.pagination-page:nth-child(3) > a:nth-child(1)")));

        WebElement icon_View = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[8]/div/a[1]"))));
        icon_View.click();

        WebElement btn_Delete = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/section/div[2]/a[2]"))));
        btn_Delete.click();

        Alert alert_Delete = driver.switchTo().alert();
        alert_Delete.accept();
    }

    public int CountTopic(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pagination-last > a:nth-child(1)")));
        btn_LastPage.click();

        WebElement table_Topic = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_Topic.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }
}
