package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DealerMainPage;
import pages.HowCanWeHelpPage;
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

    @Test(priority = 1)
    public void navigationThroughMenuTest() {
        YotecMainPage yotec = new YotecMainPage(driver);
        yotec.openPage()
                .selectMenuItem("We Are Wabash")
                .goToSubMenuPageWithVerifyBreadCrumbsAndURL("We Are Wabash", "Our Heritage", "http://qa.yotec.net/we-are-wabash/our-heritage");
    }

    @Test(priority = 2)
    public void dealerSearchWithCheckBoxOnTest() {
        DealerMainPage dealerSearchInputPage = new DealerMainPage(driver);
        dealerSearchInputPage.openPage()
                .enterSearchCriteria("Truck")
                .waitUntilLoadResultList()
                .validateNumberOfItems("49 results near Indiana", 49)
                .selectTypeOfLocation("Warranty")
                .waitUntilLoadResultList()
                .validateAfterCheckBoxing("31 results near Indiana", 31);
    }

    @Test(priority = 3)
    public void locationTypeOnTest() {
        DealerMainPage dealerCheckBoxPage = new DealerMainPage(driver);
        dealerCheckBoxPage.openPage()
                .selectTypeOfLocation("Warranty")
                .waitUntilLoadResultList()
                .validateAfterCheckBoxing("48 results near Indiana", 48);
    }

    @Test(priority = 4)
    public void submitedFormOnTest() {
        HowCanWeHelpPage helpPage = new HowCanWeHelpPage(driver);
        helpPage.openPage()
                .chooseChoice(3)
                .chooseLocation(256)
                .completeData("Boris", "VTB", "blabla@dobri.ru", "20200303", "Hello World!")
                .succesfulySubmited();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
