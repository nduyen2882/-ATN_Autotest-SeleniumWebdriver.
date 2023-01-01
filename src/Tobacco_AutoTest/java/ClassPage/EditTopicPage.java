package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditTopicPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_ListTopic = "http://103.226.249.46:4000/assignedtopics";
    public int row;

    public String ValueTopic() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[2]/span")).getText();
    }
    public String ValueAssign(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[4]/span")).getText();
    }
    public String ValueWorking(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[5]/span")).getText();
    }
    public EditTopicPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CLickIconEdit() {
//        Click icon Sửa tại list
        WebElement icon_Edit = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[8]/div/a[2]/i"))));
        icon_Edit.click();
    }

    public void ClickBtnUpdate() {
//        Sau khi sửa, nhấn btn Update để lưu lại.
        driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/section/div/form/fieldset[4]/div[1]/button")).click();
    }

    public void edit_topic(int index_topic) throws InterruptedException {
        Thread.sleep(3000);
        Select cb_topic = new Select(driver.findElement(By.id("topic")));
        cb_topic.selectByIndex(index_topic);
    }

    public void edit_assign(int index_assign) {
        Select cb_assign = new Select(driver.findElement(By.id("assgned_user")));
        cb_assign.selectByIndex(index_assign);
    }

    public void edit_working(int index_working) {
        Select cb_working = new Select(driver.findElement(By.id("working_status")));
        cb_working.selectByIndex(index_working);
    }
}
