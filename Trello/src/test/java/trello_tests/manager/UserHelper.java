package trello_tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAvatar() {
        click(By.cssSelector(".js-open-header-member-menu"));
    }

    public void clickOnProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void addPicture(String pathname) throws InterruptedException {
        attach(new File(pathname));
        Thread.sleep(7000);
    }

    public void clickOnChangeLanguage() {
        click(By.cssSelector("[data-test-id='header-member-menu-lang']"));

    }

    public void changeLangageTo(String toLang) {
        int countOfLang = driver.findElements(By.xpath("//*[@data-test-id='header-member-menu-popover']//li")).size();
        for (int i = 1; i <= countOfLang; i++) {
            String lang = driver.findElement(By.xpath("//div[@class='_3n2uNSrVwAmo1u _3lA-VqbTFB0ciD']//li[" + i + "]")).getText();
            if (lang.equals(toLang)) {
                click(By.xpath("//div[@class='_3n2uNSrVwAmo1u _3lA-VqbTFB0ciD']//li[" + i + "]"));
                return;
            }
        }
    }

    public String currentLang() {
        return driver.findElement(By.xpath("//*[@name=\"check\"]/..")).getText();
    }

    public void closeMenuProfile() {
        click(By.cssSelector("[data-test-id='popover-close']"));
    }
}
