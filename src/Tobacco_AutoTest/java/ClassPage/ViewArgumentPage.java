package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewArgumentPage {
    WebDriver driver;
    public String url_ListArg = "http://103.226.249.46:4000/languagevariables";

    public ViewArgumentPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean ViewDetailArg(int row){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(6) > div:nth-child(1) > a:nth-child(1) > i:nth-child(1)")));
//        click icon [view]
        driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[6]/div/a[1]/i")).click();
//        kiểm tra hiển thị màn view chi tiết thông qua title.
        return driver.findElement(By.xpath("/html/body/div[1]/div/section/ui-view/section/div[1]/h1")).isDisplayed();
    }
}
