package trello_tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestSimple extends TestBase {

    @Test

    public void createBoard() {
        String boardName="board1";
        testBoardCreation(boardName);
        Assert.assertTrue(isUserLoggedIn(boardName));
    }


    private boolean isUserLoggedIn(String name) {
        return isElementPresent(By.cssSelector("[title="+name+"]"));
    }

    public void testBoardCreation(String name) {
        click(By.cssSelector("[class='board-tile mod-add']"));
        type(By.cssSelector("[class='subtle-input']"), name);
        click(By.cssSelector("[class= 'primary']"));
       /* new Actions(driver).moveToElement(
               driver.findElement(By.cssSelector("[class='_1q-xxtNvcdFBca']"))).click().perform();
            click(By.cssSelector("[class='js-react-root']"));
            click(By.cssSelector("[class='js-react-root'] [class='_1q-xxtNvcdFBca']"));*/
              openSite("https://trello.com");
    }

}
