package trello_tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WelcomeScreeenSwipeTests extends TestBase {

    @Test
    public void swipeToLeft() {
        app.getSessionHelper().swipeLeft(By.xpath("//*[@resource-id='com.trello:id/content']"));

    }


    @Test
    public void swipeToRight() {
        app.getSessionHelper().swipeRight(By.xpath("//*[@resource-id='com.trello:id/content']"));

    }

    @Test
    public void swipeToLeftLeftRight() {
        app.getSessionHelper().swipeLeft(By.xpath("//*[@resource-id='com.trello:id/content']"));
        app.getSessionHelper().swipeLeft(By.xpath("//*[@resource-id='com.trello:id/content']"));
        app.getSessionHelper().swipeRight(By.xpath("//*[@resource-id='com.trello:id/content']"));

    }

}
