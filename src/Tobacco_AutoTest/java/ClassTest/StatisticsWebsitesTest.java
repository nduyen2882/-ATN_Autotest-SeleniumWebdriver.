package ClassTest;
import ClassPage.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StatisticsWebsitesTest extends BaseTest {
    LoginPage LoginPg;
    StatisticsWebsitesPage StatisticsWebsitesPg;

    @Test
    public void CheckStatistics(){
        LoginPg = new LoginPage(driver);
        StatisticsWebsitesPg = new StatisticsWebsitesPage(driver);
        LoginPg.Login("local-admin", "Qazxsw@123");
        driver.get(StatisticsWebsitesPg.url_SttWebsites);
        Assert.assertEquals(StatisticsWebsitesPg.isTitleChart(), "Statistic by Websites");
        Assert.assertTrue(StatisticsWebsitesPg.isChart());
        StatisticsWebsitesPg.StatisticsWsPage(1);
        Assert.assertTrue(StatisticsWebsitesPg.isChart());
    }
}
