package trello_tests.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import trello_tests.model.BoardData;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"board"});
        list.add(new Object[]{"BOARD"});
        list.add(new Object[]{"board13"});

        return list.iterator();
    }


    @Test(dataProvider="validBoards")
    public void createBoardFromCreateBoardButtonDPTest(String boardTitle) {
        BoardData team = new BoardData().withBoardTitle(boardTitle);
        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        app.getBoardHelper().createBoardFromCreateBoardButton(boardTitle, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardTitle));
        Assert.assertEquals(after, before + 1);
    }




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
        while (app.getBoardHelper().getPersonalBoardsCount()> 13)
            app.getBoardHelper().deleteFirstPesonalBoardFromHomePage();
    }
}