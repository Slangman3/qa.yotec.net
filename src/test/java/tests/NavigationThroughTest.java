package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.YotecMainPage;
import java.util.concurrent.TimeUnit;

public class NavigationThroughTest {
    ChromeDriver driver;

    @BeforeClass
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void navigationThroughMenu() {
        YotecMainPage yotec = new YotecMainPage(driver);
        yotec.wabashMenu(7);
//        yotec.innovationMenu(3);

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
