package trello_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @Test
    public void deleteFirstPesonalBoardTest() throws InterruptedException {
        int beforeBoards = getPersonalBoardsCount() + getTeamBoardsCount();
        deleteFirstPesonalBoardFromHomePage();
        returnToHomePage();
        int afterBoards = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(afterBoards, beforeBoards-1);
    }

    @Test
    public void deletePersonalBoardsWhileCountMoreThanNeedNumber() throws InterruptedException {
        int needCount= 8;
        int countBoards = getPersonalBoardsCount();
        while(countBoards>needCount)
        {deleteFirstPesonalBoardFromHomePage();
        returnToHomePage();
        countBoards = getPersonalBoardsCount();}
        Assert.assertEquals(countBoards, needCount);
    }


    @Test
    public void boardDeleteFromClosedBoardsList() throws InterruptedException {
        int beforeBoards = getPersonalBoardsCount() + getTeamBoardsCount();
        clickOnBoardButtonOnHeader();
        selectSeeCloseBoardsFromDropDown();
        int before = getClosedBoardsCount();
        deleteBoardByNameFromClosedBoardsForm("a2");
        Thread.sleep(3000);
        int after = getClosedBoardsCount();
        //check that count of boards in Closed Boards list decreased by 1
        Assert.assertEquals(after, before - 1);
        closeClosedBoardsForm();
        //check that count of boards hasn't changed
        int afterBoards = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(afterBoards, beforeBoards);
    }


}
