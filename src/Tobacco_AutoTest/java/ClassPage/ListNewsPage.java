package ClassPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ListNewsPage {
    public WebDriver driver;
    WebDriverWait wait;
    public String url_ListNews = "http://103.226.249.46:4000/newsdailies";
    public ListNewsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isShowListNews(){
//        Đợi load table cho tới khi có thể click vào icon Xem.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(6) > div:nth-child(1) > a:nth-child(2) > i:nth-child(1)")));
        WebElement table_ListNews = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody"));
        return table_ListNews.isDisplayed();
    }
    public String isTitleNews(){
        WebElement txt_title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[1]/h2")));
        return txt_title.getText();
    }
}
