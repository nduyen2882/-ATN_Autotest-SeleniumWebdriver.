package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class EditArgumentPage {
    WebDriver driver;
    WebDriverWait wait;
    public String url_ListArg = "http://103.226.249.46:4000/languagevariables";
    public int row;

    public String ValueName() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" +row + "]/td[2]/span")).getText();
    }
    public String ValueTopic() throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".table > tbody:nth-child(2)")));
        return driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" + row + "]/td[3]/span")).getText();
    }

    public EditArgumentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void CLickIconEdit() {
//        Click icon Sửa tại list
        WebElement icon_Edit = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/table/tbody/tr[" +row + "]/td[6]/div/a[2]/i"))));
        icon_Edit.click();
    }

    public void ClickBtnUpdate() {
//        Sau khi sửa, nhấn btn Update để lưu lại.
        driver.findElement(By.xpath("/html/body/div/div/section/ui-view/div/div/div/div[2]/section/div/form/fieldset/div[4]/button")).click();
    }

    public void edit_topic(int index_topic) throws InterruptedException {
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                Select select = new Select(driver.findElement(By.id("topic")));
                return select.getOptions().size()>1;
            }
        });
        Select cb_topic = new Select(driver.findElement(By.id("topic")));
        cb_topic.selectByIndex(index_topic);
        Thread.sleep(500);
    }

    public void edit_name(String value_assign) throws InterruptedException {
        WebElement txt_name = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        txt_name.clear();
        txt_name.sendKeys(value_assign);
        Thread.sleep(500);
    }
}
