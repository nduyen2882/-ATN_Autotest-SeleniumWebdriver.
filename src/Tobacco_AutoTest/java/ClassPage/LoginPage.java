package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{
    String name_Login = "input#usernameOrEmail";
    String pass_Login = "input#password";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void Login(String userName, String passWord){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement tb_Username = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(name_Login))));
        tb_Username.sendKeys(userName);
        driver.findElement(By.cssSelector(pass_Login)).sendKeys(passWord);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    }
}
