package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class YotecMainPage {

    String URL = "http://qa.yotec.net/";
    WebDriver driver;
    WebDriverWait wait;

    public YotecMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void wabashMenu(int index) {

        Actions actions = new Actions(driver);
        driver.get(URL);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl00_childNodesContainer']/li/a"), 8));
        WebElement wabash = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='We Are Wabash']"));
        actions.moveToElement(wabash).build().perform();
        List<WebElement> wabashList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl00_childNodesContainer']/li/a"));
        WebElement checkWabash = wabashList.get(index);
        checkWabash.click();
    }

    public void innovationMenu(int index) {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl00_childNodesContainer']/li/a"), 8));
        WebElement tradition = driver.findElement(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_navigationUl']//*[text()='Tradition of Innovation']"));
        actions.moveToElement(tradition).build().perform();
        List<WebElement> traditionList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolderMenu_TB28884E1021_ctl00_ctl00_ctl00_ctl01_childNodesContainer']/li/a"));
        WebElement checkTradition = traditionList.get(index);
        checkTradition.click();
    }

}
