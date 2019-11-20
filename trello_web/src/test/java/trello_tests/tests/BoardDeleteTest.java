package trello_tests.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import trello_tests.model.BoardData;

public class BoardDeleteTest extends TestBase {

    @BeforeMethod
    public void isBoardExist() {
        if (app.getBoardHelper().getPersonalBoardsCount() == 0) {
            BoardData board = new BoardData().withBoardTitle("a1");
            app.getBoardHelper().createBoardFromCreateBoardButton(board, "no", 0);
        }
    }

    @Test
    public void deleteFirstPesonalBoardTest() {
        int beforeBoards = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        app.getBoardHelper().deleteFirstPesonalBoardFromHomePage();
        app.getTeamHelper().returnToHomePage();
        int afterBoards = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertEquals(afterBoards, beforeBoards - 1);
    }

    @Test
    public void deletePersonalBoardsWhileCountMoreThanNeedNumber() {
        int needCount = 8;
        int countBoards = app.getBoardHelper().getPersonalBoardsCount();
        while (countBoards > needCount) {
            app.getBoardHelper().deleteFirstPesonalBoardFromHomePage();
          //  app.getTeamHelper().returnToHomePage();
            countBoards = app.getBoardHelper().getPersonalBoardsCount();
        }
        Assert.assertEquals(countBoards, needCount);
    }

    @Test(enabled=false)
    public void boardDeleteFromClosedBoardsList() throws InterruptedException {
        app.getBoardHelper().clickOnBoardButtonOnHeader();
        app.getBoardHelper().selectSeeCloseBoardsFromDropDown();
        int before = app.getBoardHelper().getClosedBoardsCount();
        if (before == 0) {
            System.out.println("Closed boards don't exist");
            return;
        }
        app.getBoardHelper().deleteBoardByNameFromClosedBoardsForm("aaa");
        int after = app.getBoardHelper().getClosedBoardsCount();
        //check that count of boards in Closed Boards list decreased by 1
        Assert.assertEquals(after, before - 1);
        app.getBoardHelper().closeClosedBoardsForm();
    }

}
