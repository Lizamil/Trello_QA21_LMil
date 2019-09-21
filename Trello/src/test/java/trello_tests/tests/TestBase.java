package trello_tests.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import trello_tests.manager.ApplicationManager;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

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
        app.stop();

    }


}

