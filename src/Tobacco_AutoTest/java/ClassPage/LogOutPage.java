package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogOutPage {
    WebDriver driver;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LogOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement icon_Logout = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("/html/body/div[1]/nav/ul[2]/li[5]/a/i"))));
        icon_Logout.click();
    }
}
