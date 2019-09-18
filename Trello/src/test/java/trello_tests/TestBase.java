package trello_tests;

import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

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

