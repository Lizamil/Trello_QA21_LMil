package trello_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCloseTests extends TestBase {


    @Test
    public void close01() {
        int before = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        String boardName = "a1"; //Menu is closed
        app.closeBoardNew(boardName);
        app.returnToHomePage();
        int after = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);
    }

    @Test
    public void close02() {
        int before = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        String boardName = "menuOpen2"; //Menu is opened
        app.closeBoardNew(boardName);
        app.returnToHomePage();
        int after = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);
    }

    @Test
    public void close03() {
        int before = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        String boardName = "zzzAboutBoardOpen2"; //About this boards is opened
        app.closeBoardNew(boardName);
        app.returnToHomePage();
        int after = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);

    }

    @Test
    public void close04() {
        int before = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        String boardName = "zzzAboutBoardCloseButHas2"; //About this boards Menu close but open after click on ShowMenu
        app.closeBoardNew(boardName);
        app.returnToHomePage();
        int after = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);

    }

}



