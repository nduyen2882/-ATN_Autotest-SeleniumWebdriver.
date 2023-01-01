package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CreateNewsPage {
    WebDriver driver;
    public String url_ListNews = "http://103.226.249.46:4000/newsdailies";
    public String url_News = "http://103.226.249.46:4000/newsdailies/create";

    public CreateNewsPage(WebDriver driver){
        this.driver = driver;
    }

    public void CreateNew(String title, String body){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-default")));
        driver.findElement(By.xpath("//*[@id=\"news_title\"]")).sendKeys(title);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/section/div/form/fieldset/div[2]/textarea")).sendKeys(body);
        driver.findElement(By.cssSelector("button.btn-default:nth-child(1)")).click();
    }

    public int CountNews() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/div/ul/li[12]/a")));
        btn_LastPage.click();
        Thread.sleep(3000);

        WebElement table_News = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_News.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }
}
