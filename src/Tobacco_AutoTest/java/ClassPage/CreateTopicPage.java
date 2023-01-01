package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateTopicPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_Topic = "http://103.226.249.46:4000/assignedtopics/create";
    public String url_ListTopic = "http://103.226.249.46:4000/assignedtopics";

    public CreateTopicPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CreateTopic(String topic, String assign, String working){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-default")));
        Select cb_topic = new Select(driver.findElement(By.id("topic")));
        cb_topic.selectByVisibleText(topic);
        Select cb_assign = new Select(driver.findElement(By.id("assgned_user")));
        cb_assign.selectByVisibleText(assign);
        Select cb_working = new Select(driver.findElement(By.id("working_status")));
        cb_working.selectByVisibleText(working);
        driver.findElement(By.cssSelector("button.btn-default:nth-child(1)")).click();
    }

    public int CountTopic(){
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pagination-last > a:nth-child(1)")));
        btn_LastPage.click();

        WebElement table_Topic = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_Topic.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }

//    public void ViewDetailTopicPage(String e_topic, String e_assign, String e_working){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.pagination-page:nth-child(3) > a:nth-child(1)")));
//        driver.findElement(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(1) > span:nth-child(1)")).click();
//
//        WebElement btn_Edit = wait.until(ExpectedConditions.elementToBeClickable(
//                driver.findElement(By.cssSelector("a.btn:nth-child(1)"))));
//        btn_Edit.click();
//
//        Select cb_topic = new Select(driver.findElement(By.id("topic")));
//        Assert.assertEquals(e_topic, cb_topic.getFirstSelectedOption().getText());
//        Select cb_assign = new Select(driver.findElement(By.id("assgned_user")));
//        Assert.assertEquals(e_assign, cb_assign.getFirstSelectedOption().getText());
//        Select cb_working = new Select(driver.findElement(By.id("working_status")));
//        Assert.assertEquals(e_working, cb_working.getFirstSelectedOption().getText());
//    }
}
