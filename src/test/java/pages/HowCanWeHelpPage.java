package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HowCanWeHelpPage {
    private static final String URL = "http://qa.yotec.net/we-are-wabash/support/frequently-asked-questions";
    WebDriver driver;
    WebDriverWait wait;

    By choice = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_ctl02_C015_ctl00_ctl00_dropDown']//*[@value]");
    By location = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_ctl02_C019_ctl00_ctl00_dropDownCountry']//*[@value]");
    By guestName = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_C006_ctl00_ctl00_textBox_write']");
    By companyName = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_C008_ctl00_ctl00_textBox_write']");
    By userEmail = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_C010_ctl00_ctl00_textBox_write']");
    By userPhone = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_C011_ctl00_ctl00_textBox_write']");
    By commentsArea = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_ctl09_C009_ctl00_ctl00_textBox_write']");
    By submitBtn = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_ctl10_C007']");
    By subnitedReport = By.xpath("//*[@id='ContentPlaceHolderFooter_TADBF704B033_ctl00_ctl00_successMessage']");

    public HowCanWeHelpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public HowCanWeHelpPage openPage() {
        driver.get(URL);
        return this;
    }

    public HowCanWeHelpPage chooseChoice(int numberOfChoice) {
        WebElement choiceItem = driver.findElements(choice).get(numberOfChoice - 1);
        choiceItem.click();
        return this;
    }

    public HowCanWeHelpPage chooseLocation(int numberOfLocation) {
        WebElement locationChoice = driver.findElements(location).get(numberOfLocation - 1);
        locationChoice.click();
        return this;
    }

    public HowCanWeHelpPage completeData(String name, String company, String email, String phoneNumber, String message) {
        driver.findElement(guestName).sendKeys(name);
        driver.findElement(companyName).sendKeys(company);
        driver.findElement(userEmail).sendKeys(email);
        driver.findElement(userPhone).sendKeys(phoneNumber);
        driver.findElement(commentsArea).sendKeys(message);
        driver.findElement(submitBtn).click();
        return this;
    }

    public HowCanWeHelpPage succesfulySubmited() {
        boolean submitRepo = driver.findElement(subnitedReport).isDisplayed();
        Assert.assertEquals(submitRepo, true);
        return this;
    }
}
