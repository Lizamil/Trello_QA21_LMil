package trello_tests.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper  extends HelperBase{

    public SessionHelper(AppiumDriver driver) {
        super(driver);
    }

    public void openSite(String url) {
        driver.get(url);

    }
    public void login(String email, String password) {
        click(By.id("log_in_button"));
        type(By.id("user"), email);
        type(By.id("password"), password);
        clickConfirmLogin();
    }

    public void clickConfirmLogin() {
        click(By.id("authenticate"));

    }

    // For check logIn
    public boolean isUserLoggedIn() {
        return isElementPresent(By.name("house"));

    }
    public boolean isUserLoggedOut() {
        return isElementPresent(By.cssSelector("[href='/login']"));

    }

    public void clickByContains(String teamName) {
        click(By.xpath("//a[@href='#']//div[contains(text(),'" + teamName + "')]"));
    }
}
