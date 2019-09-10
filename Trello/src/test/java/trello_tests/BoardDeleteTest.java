package trello_tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @BeforeMethod
    public void isBoardExist() {
        if (getPersonalBoardsCount() == 0)
            createBoard("a1", "no", 0);
    }

    @Test
    public void deleteFirstPesonalBoardTest() {
        int beforeBoards = getPersonalBoardsCount() + getTeamBoardsCount();
        deleteFirstPesonalBoardFromHomePage();
        returnToHomePage();
        int afterBoards = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(afterBoards, beforeBoards - 1);
    }

    @Test
    public void deletePersonalBoardsWhileCountMoreThanNeedNumber() {
        int needCount = 8;
        int countBoards = getPersonalBoardsCount();
        while (countBoards > needCount) {
            deleteFirstPesonalBoardFromHomePage();
            returnToHomePage();
            countBoards = getPersonalBoardsCount();
        }
        Assert.assertEquals(countBoards, needCount);
    }

    @Test
    public void boardDeleteFromClosedBoardsList() throws InterruptedException {
        clickOnBoardButtonOnHeader();
        selectSeeCloseBoardsFromDropDown();
        int before = getClosedBoardsCount();
        if (before == 0) {
            System.out.println("Closed boards don't exist");
            return;
        }
        deleteBoardByNameFromClosedBoardsForm("aaa");
        int after = getClosedBoardsCount();
        //check that count of boards in Closed Boards list decreased by 1
        Assert.assertEquals(after, before - 1);
        closeClosedBoardsForm();
    }

}
