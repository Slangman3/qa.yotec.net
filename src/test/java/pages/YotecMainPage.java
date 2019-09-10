package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

}
