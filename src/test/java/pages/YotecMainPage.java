package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class YotecMainPage {

    private static final String URL = "http://qa.yotec.net/";
    WebDriver driver;
    WebDriverWait wait;

    public YotecMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public YotecMainPage openPage() {
        driver.get(URL);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        return this;
    }

    public YotecMainPage selectMenuItem(String menuItemName) {
        Actions actions = new Actions(driver);
        WebElement newItemSelect = driver.findElement(By.xpath(String.format("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='%s']", menuItemName)));
        actions.moveToElement(newItemSelect).build().perform();
        return this;
    }

    public YotecMainPage goToSubMenuPageWithVerifyBreadCrumbsAndURL(String menuName, String subMenuName, String currentURL) {
        WebElement subMenu = driver.findElement(By.xpath(String.format("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='%s']/..//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl00_childNodesContainer']//*[contains(text(),'%s')]", menuName, subMenuName)));
        subMenu.click();
        Assert.assertEquals(currentURL, driver.getCurrentUrl());
        String currentCrumbs = driver.findElement(By.xpath(String.format("//*[@id='ctl00_ContentPlaceHolderContent_TADBF704B007_ctl00_ctl00_Breadcrumb']//*[contains(text(),'%s')]", subMenuName))).getText();
        Assert.assertEquals(currentCrumbs, subMenuName);
        return this;
    }

    public void innovationMenu(int index) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        WebElement tradition = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Tradition of Innovation']"));
        actions.moveToElement(tradition).build().perform();
        List<WebElement> traditionList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl01_childNodesContainer']/li/a"));
        WebElement checkTradition = traditionList.get(index - 1);
        checkTradition.click();
        String traditionURL = driver.getCurrentUrl();
        Assert.assertEquals(traditionURL, "http://qa.yotec.net/tradition-of-innovation/future-focus");
        String traditionCrumbs = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolderContent_TADBF704B007_ctl00_ctl00_Breadcrumb']//*[contains(text(),'Future Focus')]")).getText();
        Assert.assertEquals(traditionCrumbs, "Future Focus");
        driver.navigate().back();
    }

    public void ourProductsMenu() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        WebElement products = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Our Products']"));
        actions.moveToElement(products).build().perform();
        WebElement trailers = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl02_childNodesContainer']/li/a"));
        trailers.click();
        String trailersURL = driver.getCurrentUrl();
        Assert.assertEquals(trailersURL, "http://qa.yotec.net/our-products/trailers");
        String trailerCrumbs = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolderContent_TC9310CFE005_ctl00_ctl00_Breadcrumb']//*[contains(text(),'Trailer')]")).getText();
        Assert.assertEquals(trailerCrumbs, "Trailers");
        driver.navigate().back();
    }

    public void ourBrandsMenu(int index) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        WebElement brands = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Our Brands']"));
        actions.moveToElement(brands).build().perform();
        List<WebElement> supremeList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl03_childNodesContainer']/li/a"));
        WebElement supreme = supremeList.get(index - 1);
        supreme.click();
        String supremeURL = driver.getCurrentUrl();
        Assert.assertEquals(supremeURL, "http://qa.yotec.net/our-brands/supreme");
        driver.navigate().back();
    }

    public void workWithWabashMenu(int index) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        WebElement workWith = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Work With Wabash']"));
        actions.moveToElement(workWith).build().perform();
        List<WebElement> CareersList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl04_childNodesContainer']/li/a"));
        WebElement career = CareersList.get(index - 1);
        career.click();
        String careerURL = driver.getCurrentUrl();
        Assert.assertEquals(careerURL, "http://qa.yotec.net/work-with-wabash/careers");
        String careerCrumbs = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolderContent_TADBF704B007_ctl00_ctl00_Breadcrumb']//*[contains(text(),'Careers')]")).getText();
        Assert.assertEquals(careerCrumbs, "Careers");
        driver.navigate().back();
    }

    public void timeLineMenu() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        WebElement timeLine = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Timeline']"));
        timeLine.click();
        String timeLineURL = driver.getCurrentUrl();
        Assert.assertEquals(timeLineURL, "http://qa.yotec.net/timeline");
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[contains(@class,'w__timeline')]//li"), 5));
        driver.navigate().back();
    }

    public void locationSearchMenu(int index) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']/li"), 7));
        WebElement locationSearch = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Location Search']"));
        actions.moveToElement(locationSearch).build().perform();
        List<WebElement> locationSearchList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl06_childNodesContainer']/li/a"));
        WebElement test = locationSearchList.get(index - 1);
        test.click();
        String testURL = driver.getCurrentUrl();
        Assert.assertEquals(testURL, "http://qa.yotec.net/location-search/test");
        String testCrumbs = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolderContent_TADBF704B007_ctl00_ctl00_Breadcrumb']//*[contains(text(),'test')]")).getText();
        Assert.assertEquals(testCrumbs, "test");
        driver.navigate().back();
    }

}
