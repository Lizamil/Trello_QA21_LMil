package trello_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    //Base Methods
    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();

    }

    public void waitPresenceElement(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitClickable(By locator, int timeOut) {
        new WebDriverWait(driver, timeOut).
                until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void returnToHomePage() {
        if (isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))) {
            new WebDriverWait(driver, 20).until(ExpectedConditions.stalenessOf(
                    driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            // wait until the element disappears - ExpectedConditions.stalenessOf
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            waitPresenceElement(By.cssSelector("a[href='/']"),15);
        click(By.cssSelector("a[href='/']"));
        click(By.cssSelector("a[href='/']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }

    public int getTeamsCount() {
        if (!isElementPresent(By.cssSelector(".icon-organization.icon-sm.OiX3P2i2J92Xat")))
            return 0;
        waitPresenceElement(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li"), 15);
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }


    public void confirm() {
        waitPresenceElement(By.cssSelector(".js-confirm"), 10);
        click(By.cssSelector(".js-confirm"));

    }
    public void clickOnPlusButtonOnHeader() {
        click(By.name("add"));

    }
}
