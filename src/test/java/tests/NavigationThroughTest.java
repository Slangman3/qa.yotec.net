package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DealerMainPage;
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
        yotec.innovationMenu(3);
        yotec.ourProductsMenu();
        yotec.ourBrandsMenu(6);
        yotec.workWithWabashMenu(0);
        yotec.timeLineMenu();
        yotec.locationSearchMenu(2);
//        yotec.openPage
//                .selectMenuItem("MenuItem Nmae")
//                .checkThatCOntainsItems("Submenu 1", "submenu 2")
    }

    @Test
    public void dealerSearchTruckOnTest() {
        DealerMainPage dealerSearchInputPage = new DealerMainPage(driver);
        dealerSearchInputPage.openPage()
                .enterSearchCriteria("Truck")
                .waitUntilLoadResultList()
                .validateNumberOfItems("49 results near Indiana", 49)
                .selectTypeOfLocation("Warranty")
                .waitUntilLoadResultList()
                .validateAfterCheckBoxing("31 results near Indiana", 31);
    }

    @Test
    public void locationTypeOnTest() {
        DealerMainPage dealerCheckBoxPage = new DealerMainPage(driver);
        dealerCheckBoxPage.openPage()
                .selectTypeOfLocation("Warranty")
                .waitUntilLoadResultList()
                .validateAfterCheckBoxing("48 results near Indiana", 48);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
