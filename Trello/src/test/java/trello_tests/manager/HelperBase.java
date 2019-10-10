package trello_tests.manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    //Base Methods
    public void type(By locator, String text) {
        if(text!=null){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);}


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
//        if (!isElementPresent(By.cssSelector(".icon-organization.icon-sm.OiX3P2i2J92Xat")))
//            return 0;
        waitPresenceElement(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li"), 15);
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }


    public void confirm() {
        waitPresenceElement(By.cssSelector(".js-confirm"), 10);
        click(By.cssSelector(".js-confirm"));

    }
    public void clickOnPlusButtonOnHeader() {
        waitPresenceElement(By.cssSelector("[data-test-id='header-create-menu-button']"),15);
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));

    }



    public void clickEnter() {
        driver.findElement(By.cssSelector("[class='board-name-input js-board-name-input']")).sendKeys(Keys.ENTER);

    }

    public void sendText(By locator, String newBoardName) {
        driver.findElement(locator).sendKeys(newBoardName);
    }

public void takeScreenshot() {
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screen = new File("src/test/resources/Screenshots/screen/"+System.currentTimeMillis()+".png");
    try {
        Files.copy(tmp,screen);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public void attach(File file) {
        driver.findElement(By.name("file")).sendKeys(file.getAbsolutePath());
    }

    public void clickBoardButton() {
       click(By.cssSelector("[href='/elizaveta528/boards']"));
    }
}
