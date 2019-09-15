package trello_tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSimple extends TestBase {

    @Test

    public void createBoard() throws InterruptedException {
        String boardName="board1";
        testBoardCreation(boardName);
        Assert.assertTrue(app.isBoardExistsByNameCheckOnMainPage(boardName));
    }


    public void testBoardCreation(String name) throws InterruptedException {
        app.click(By.cssSelector("[class='board-tile mod-add']"));
        app.type(By.cssSelector("[class='subtle-input']"), name);
        app.click(By.cssSelector("[class= 'primary']"));
        app.returnToHomePage();

    }

}
