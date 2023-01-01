package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditKeywordPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_ListKey = "http://103.226.249.46:4000/keywords";
    public int row;

    public String ValueName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[2]/span")).getText();
    }
    public String ValueTopic(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[3]/span")).getText();
    }

    public EditKeywordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CLickIconEdit() {
//        Click icon Sửa tại list
        WebElement icon_Edit = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[6]/div/a[2]/i"))));
        icon_Edit.click();
    }

    public void ClickBtnUpdate() {
//        Sau khi sửa, nhấn btn Update để lưu lại.
        driver.findElement(By.cssSelector(".btn-default")).click();
    }

    public void edit_topic(int index_topic) {
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                Select select = new Select(driver.findElement(By.id("topic")));
                return select.getOptions().size()>1;
            }
        });
        Select cb_topic = new Select(driver.findElement(By.id("topic")));
        cb_topic.selectByIndex(index_topic);
    }

    public void edit_name(String value_assign) {
        WebElement txt_name = driver.findElement(By.cssSelector("#keyword_name"));
        txt_name.clear();
        txt_name.sendKeys(value_assign);
    }
}
