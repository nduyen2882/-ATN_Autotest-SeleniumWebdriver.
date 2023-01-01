package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CreateArgumentPage {
    WebDriver driver;
    public String url_Argument = "http://103.226.249.46:4000/languagevariables/create";
    public String url_ListArgument = "http://103.226.249.46:4000/languagevariables";

    public CreateArgumentPage(WebDriver driver){
        this.driver = driver;
    }

    public void CreateArgument(String topic, String name, String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-default")));
        Select cb_topic = new Select(driver.findElement(By.id("topic")));
        cb_topic.selectByVisibleText(topic);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"value\"]")).sendKeys(value);
        driver.findElement(By.cssSelector("button.btn-default:nth-child(1)")).click();
    }

    public int CountArgument(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement btn_LastPage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".pagination-last > a:nth-child(1)")));
        btn_LastPage.click();

        WebElement table_Argument = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        List<WebElement> rows_table = table_Argument.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        return rows_count;
    }
}
