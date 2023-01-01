package ClassPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StatisticsWebsitesPage {
    WebDriver driver;
    public String url_SttWebsites = "http://103.226.249.46:4000/newsdailies/statistic";

    public StatisticsWebsitesPage(WebDriver driver){
        this.driver = driver;
    }
    public void StatisticsWsPage(int cb_index){
//        đợi load biểu đồ
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select.form-control")));

//        click combobox filter biểu đồ
        Select cb_filterChart = new Select(driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[1]/div/div/select")));
        cb_filterChart.selectByIndex(cb_index);
    }

    public boolean isChart() {
        //        kiểm tra hiển thị biểu đồ
        WebElement chart = driver.findElement(By.xpath("//*[@id=\"pieChart\"]"));
        return chart.isDisplayed();
    }

    public String isTitleChart(){
        String txt_title = driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[1]/h4")).getText();
        return txt_title;
    }
}
