package ClassPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeleteKeywordPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_ListKey = "http://103.226.249.46:4000/keywords";

    public DeleteKeywordPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void DeleteKeyWithIcon(int row){
        WebElement icon_Delete = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr["+row+"]/td[6]/div/a[3]/i"))));
        icon_Delete.click();

        Alert alert_Delete = driver.switchTo().alert();
        alert_Delete.accept();
    }

    public void DeleteKeyWithBtn(int row){
        driver.findElement(By.cssSelector(".pagination-first > a:nth-child(1)")).click(); //Chuyển driver về page đầu tiên.
        WebElement icon_View = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr["+row+"]/td[6]/div/a[1]/i"))));
        icon_View.click();

        WebElement btn_Delete = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/section/div[1]/a[2]/i"))));
        btn_Delete.click();

        Alert alert_Delete = driver.switchTo().alert();
        alert_Delete.accept();
    }

    public int CountKey(){
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pagination-last > a:nth-child(1)")));
        btn_LastPage.click();

        WebElement table_Key = driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_Key.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }
}
