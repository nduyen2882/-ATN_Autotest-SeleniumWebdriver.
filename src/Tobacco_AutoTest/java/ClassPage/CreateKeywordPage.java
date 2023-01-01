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

public class CreateKeywordPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_Keyword = "http://103.226.249.46:4000/keywords/create";
    public String url_ListKeyword = "http://103.226.249.46:4000/keywords";

    public CreateKeywordPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CreateKeyword(String keyTopic, String keyName, String keyOperator, String keyExactly){
        WebElement tb_keywordName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#keyword_name")));
        Select cb_topic = new Select(driver.findElement(By.id("topic")));
        cb_topic.selectByVisibleText(keyTopic);
        tb_keywordName.sendKeys(keyName);
        driver.findElement(By.cssSelector("#keyword_operators")).sendKeys(keyOperator);
        driver.findElement(By.cssSelector("#keyword_exactly")).sendKeys(keyExactly);
        driver.findElement(By.cssSelector("button.btn-default:nth-child(1)")).click();
    }

    public int CountKeyword(){
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pagination-last > a:nth-child(1)")));
        btn_LastPage.click();

        WebElement table_Keyword = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_Keyword.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }
}
