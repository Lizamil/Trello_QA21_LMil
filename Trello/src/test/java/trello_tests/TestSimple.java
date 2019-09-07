package trello_tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestSimple extends TestBase {

    @Test

    public void createBoard() throws InterruptedException {
        String boardName="board1";
        testBoardCreation(boardName);
        Assert.assertTrue(isBoardExistsByNameCheckOnMainPage(boardName));
    }


    public void testBoardCreation(String name) throws InterruptedException {
        click(By.cssSelector("[class='board-tile mod-add']"));
        type(By.cssSelector("[class='subtle-input']"), name);
        click(By.cssSelector("[class= 'primary']"));
        returnToHomePage();

    }

}
