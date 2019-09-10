package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DealerMainPage {
    private static final String URL = "http://qa.yotec.net/location-search/dealer";
    WebDriver driver;
    WebDriverWait wait;
    By searchInput = By.xpath("//*[@placeholder='Search Term']");
    By locationInput = By.xpath("//*[@placeholder='State, city, street, zip code, etc']");
    By brandCheckBox = By.xpath("//*[@id='ctl00_ContentPlaceHolderContent_C001_RadCheckBoxList1']//*[@type='button']");
    By resultsList = By.xpath("//*[@id='w__dealer_list']//*[@class='w__dealer_item']");
    By listLoader = By.xpath("//*[contains(@class,'loading_panel')]");


    public DealerMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public DealerMainPage openPage() {
        driver.get(URL);
        return this;
    }

    public DealerMainPage enterSearchCriteria(String criteria) {
        driver.findElement(searchInput).sendKeys(criteria);
        return this;
    }

    public DealerMainPage validateNumberOfItems(String resultAfterSearch, int sizeListAfterSearch) {
        WebElement result = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderContent_C001_lblDealerCount']"));
        Assert.assertEquals(result.getText(), resultAfterSearch);
        int sizeListSearch = driver.findElements(resultsList).size();
        Assert.assertEquals(sizeListSearch, sizeListAfterSearch);
        return this;
    }

    public DealerMainPage waitUntilLoadResultList() {
        WebElement loader = driver.findElement(listLoader);
        wait.until(ExpectedConditions.visibilityOf(loader));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        return this;
    }

    public DealerMainPage selectTypeOfLocation(String location) {
        WebElement choiceLocation = driver.findElement(By.xpath(String.format("//*[@id='ctl00_ContentPlaceHolderContent_C001_RadCheckBoxList2']//*[@type='button'][contains(@value,'%s')]", location)));
        choiceLocation.click();
        return this;
    }

    public DealerMainPage validateAfterCheckBoxing(String resultAfterCheckBox, int sizeListAfterCheckBox) {
        WebElement resultString = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderContent_C001_lblDealerCount']"));
        Assert.assertEquals(resultString.getText(), resultAfterCheckBox);
        int sizeListCheckBox = driver.findElements(By.xpath("//*[@id='w__dealer_list']//*[@class='w__dealer_item']")).size();
        Assert.assertEquals(sizeListCheckBox, sizeListAfterCheckBox);
        return this;
    }
}
