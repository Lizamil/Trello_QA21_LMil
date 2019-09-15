package trello_tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {


    @Test
    public void createBoard() {
        int before = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        String boardName = "b_no_private_"+System.currentTimeMillis();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        app.createBoard(boardName, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.returnToHomePage();
        int after = app.getPersonalBoardsCount() + app.getTeamBoardsCount();
        Assert.assertTrue(app.isBoardExistsByNameCheckOnMainPage(boardName));
        Assert.assertEquals(after, before + 1);
    }


    @AfterClass
    public void removeUnnecessaryPersonalBoards() {
        while (app.getPersonalBoardsCount()> 5)
            app.deleteFirstPesonalBoardFromHomePage();
    }
}