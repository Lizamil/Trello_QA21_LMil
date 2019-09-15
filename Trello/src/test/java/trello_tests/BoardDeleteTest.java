package trello_tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @BeforeMethod
    public void isBoardExist() {
        if (app.getPersonalBoardsCount() == 0)
            app.createBoard("a1", "no", 0);
    }

    @Test
    public void deleteFirstPesonalBoardTest() {
        int beforeBoards = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        app.deleteFirstPesonalBoardFromHomePage();
        app.returnToHomePage();
        int afterBoards = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        Assert.assertEquals(afterBoards, beforeBoards - 1);
    }

    @Test(enabled=false)
    public void deletePersonalBoardsWhileCountMoreThanNeedNumber() {
        int needCount = 5;
        int countBoards = app.getPersonalBoardsCount();
        while (countBoards > needCount) {
            app.deleteFirstPesonalBoardFromHomePage();
            app.returnToHomePage();
            countBoards = app.getPersonalBoardsCount();
        }
        Assert.assertEquals(countBoards, needCount);
    }

    @Test(enabled=false)
    public void boardDeleteFromClosedBoardsList() throws InterruptedException {
        app.clickOnBoardButtonOnHeader();
        app.selectSeeCloseBoardsFromDropDown();
        int before = app.getClosedBoardsCount();
        if (before == 0) {
            System.out.println("Closed boards don't exist");
            return;
        }
        app.deleteBoardByNameFromClosedBoardsForm("aaa");
        int after = app.getClosedBoardsCount();
        //check that count of boards in Closed Boards list decreased by 1
        Assert.assertEquals(after, before - 1);
        app.closeClosedBoardsForm();
    }

}
