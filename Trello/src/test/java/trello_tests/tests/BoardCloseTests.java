package trello_tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCloseTests extends TestBase {

    @BeforeMethod
    public void isBoardExist() {
        if (app.getBoardHelper().getPersonalBoardsCount() == 0)
            app.getBoardHelper().createBoardFromCreateBoardButton("a1", "no", 0);
    }

    @Test
    public void closeFirstPersonalBoardTest() {
        int before = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().closeFirstPersonalBoard();
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("before= " + before);
        System.out.println("after= " + after);
    }


}



