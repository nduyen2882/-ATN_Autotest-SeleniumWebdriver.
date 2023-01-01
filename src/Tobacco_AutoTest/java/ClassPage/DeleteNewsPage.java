package ClassPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeleteNewsPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_ListNews = "http://103.226.249.46:4000/newsdailies";

    public DeleteNewsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void DeleteNewsWithIcon(int row){
        WebElement icon_Delete = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr["+row+"]/td[6]/div/a[4]/i"))));
        icon_Delete.click();

        Alert alert_Delete = driver.switchTo().alert();
        alert_Delete.accept();
    }

    public int CountNews(){
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pagination-last > a:nth-child(1)")));
        btn_LastPage.click();

        WebElement table_News = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_News.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }
}
