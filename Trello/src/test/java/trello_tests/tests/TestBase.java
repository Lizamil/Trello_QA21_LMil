package trello_tests.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import trello_tests.manager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUP() {
        app.init();

    }

    @BeforeMethod
    public void isOnHomePage() {
        if (!app.getBoardHelper().isThereBoardsPresent())
            app.getSessionHelper().returnToHomePage();
    }

    @AfterSuite
    public void tearDown() {
        //dfdfdfd

        app.stop();

    }

    @BeforeMethod
    public void startLogger(Method m, Object[] p) {

        logger.info("start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopLogger(Method m, Object[] p) {
        logger.info("stop test " + m.getName() + " with parameters " + Arrays.asList(p));
        System.out.println("________________________________________________________________");

    }
}

