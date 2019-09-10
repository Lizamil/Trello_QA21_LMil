package trello_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCloseTests extends TestBase {

    @BeforeMethod
    public void isOnHomePage() {
        if (!isThereBoardsPresent())
            returnToHomePage();
    }

    @Test
    public void close01() {
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "a1"; //Menu is closed
        closeBoardNew(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);
    }

    @Test
    public void close02() {
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "menuOpen2"; //Menu is opened
        closeBoardNew(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);
    }

    @Test
    public void close03() {
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "zzzAboutBoardOpen2"; //About this boards is opened
        closeBoardNew(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);

    }

    @Test
    public void close04() {
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "zzzAboutBoardCloseButHas2"; //About this boards Menu close but open after click on ShowMenu
        closeBoardNew(boardName);
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);

    }

}



