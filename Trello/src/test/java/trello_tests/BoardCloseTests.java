package trello_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCloseTests extends TestBase {

    @Test
    public void close01() throws InterruptedException {
        int before = getPersonalBoardsCount() + getTeamBoardsCount();

        String boardName = "menuClose2"; //Menu is closed
        closeBoard(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void close02() throws InterruptedException {
        returnToHomePage();
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "menuOpen2"; //Menu is opened
        closeBoard(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
    }

    @Test(enabled=false)
    public void close03() throws InterruptedException {
        returnToHomePage();
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "aboutBoardOpen2"; //About this boards is opened
        closeBoard2(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after,before -1);


    }


    @Test(enabled=false)
    public void close04() throws InterruptedException {
        returnToHomePage();
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "aboutBoardCloseButHas2"; //Menu is closed but after click About this boards opens
        closeBoard2(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
    }


}
