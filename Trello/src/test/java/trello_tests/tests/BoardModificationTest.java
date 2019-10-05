package trello_tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import trello_tests.model.BoardData;

public class BoardModificationTest extends TestBase {

    @BeforeMethod
    public void isBoardExist() {
        if (app.getBoardHelper().getPersonalBoardsCount() == 0) {
            BoardData board = new BoardData().withBoardTitle("a1");
            app.getBoardHelper().createBoardFromCreateBoardButton(board, "no", 0);
        }
    }

    @Test

    public void testAddListOnBoard() {
        app.getBoardHelper().clickOnFirstBoard();
        int before = app.getBoardHelper().getListCount();
        String listName = "aaa3";
        app.getBoardHelper().click(By.cssSelector(".placeholder"));
        app.getBoardHelper().type(By.cssSelector(".list-name-input"), listName);
        app.getBoardHelper().confirmnOnBoardIPage();
        int after = app.getBoardHelper().getListCount();
        Assert.assertEquals(after, before + 1);
        app.getTeamHelper().returnToHomePage();
    }

    @Test

    public void testRenameBoard() {
        app.getBoardHelper().clickOnFirstBoard();
        String boardNameCurrent=app.getBoardHelper().getBoardNameFromBoardPage();
        String boardNameNew = "rename"+System.currentTimeMillis();
        app.getBoardHelper().renameBoard(boardNameNew,boardNameCurrent);
        //Assert.assertEquals(boardNameCurrent, boardNameNew);
        app.getTeamHelper().returnToHomePage();
    }

    @Test

    public void testRenameBoard2() {
        app.getBoardHelper().clickOnFirstBoard();
        String boardNameCurrent=app.getBoardHelper().getBoardNameFromBoardPage();
        String boardNameNew = "_rename"+System.currentTimeMillis();
        app.getBoardHelper().renameBoardShort(boardNameNew);
       // Assert.assertEquals(boardNameCurrent, boardNameNew);
        app.getTeamHelper().returnToHomePage();
    }


}
