package trello_tests.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


    @Test
    public void createBoardFromCreateBoardButtonTest() {
        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String boardName = "b_no_private_"+System.currentTimeMillis();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        app.getBoardHelper().createBoardFromCreateBoardButton(boardName, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardName));
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void createBoardFromPlusButtonOnHeaderTest() {
        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String boardName = "bFromPlus_no_private_"+System.currentTimeMillis();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        app.getBoardHelper().createBoardFromPlusButtonOnHeader(boardName, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardName));
        Assert.assertEquals(after, before + 1);
    }


    @AfterClass
    public void removeUnnecessaryPersonalBoards() {
        while (app.getBoardHelper().getPersonalBoardsCount()> 5)
            app.getBoardHelper().deleteFirstPesonalBoardFromHomePage();
    }
}