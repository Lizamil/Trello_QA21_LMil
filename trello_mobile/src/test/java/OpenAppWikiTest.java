import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenAppWikiTest {
    AppiumDriver driver;

    @BeforeClass

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emu");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia"); //com.trello
        capabilities.setCapability("appActivity", ".main.MainActivity"); //.home.HomeActivity
        capabilities.setCapability("app", "trello_mobile/src/test/resources/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


    }
    @Test
    public void openAppTest(){

        System.out.println("App opened");
    }

    @AfterClass

    public void tearDown() {

    }

}