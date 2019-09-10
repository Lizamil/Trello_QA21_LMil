package trello_tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {




    @Test
    public void createBoard() {
        int before = getPersonalBoardsCount() + getTeamBoardsCount();
        String boardName = "board_noTeam_public";
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        createBoard(boardName, teamName, 1); // status board: public (1)/private (0)/teamVisible (2)
        returnToHomePage();
        int after = getPersonalBoardsCount() + getTeamBoardsCount();
        Assert.assertTrue(isBoardExistsByNameCheckOnMainPage(boardName));
        Assert.assertEquals(after, before + 1);
    }


    @AfterClass
    public void removeUnnecessaryBoards() {
        while (getPersonalBoardsCount() + getTeamBoardsCount() > 5)
            deleteFirstPesonalBoardFromHomePage();
    }
}