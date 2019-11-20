package trello_tests.tests;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import trello_tests.model.BoardData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTestsMob extends TestBase {

    AppiumDriver driver;

    @DataProvider
    public Iterator<Object[]> validBoards() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"board"});
        list.add(new Object[]{"BOARD"});
        list.add(new Object[]{"board13"});

        return list.iterator();
    }


    @Test(dataProvider = "validBoards")
    public void createBoardFromCreateBoardButtonDPTest(String boardTitle) {
        BoardData board = new BoardData().withBoardTitle(boardTitle);
        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        app.getBoardHelper().createBoardFromCreateBoardButton(board, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardTitle));
        Assert.assertEquals(after, before + 1);
    }


    @DataProvider
    public Iterator<Object[]> validBoardsfromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/Board.csv")));
        String line = reader.readLine();
        while (line != null) {
            list.add(new Object[]{new BoardData().withBoardTitle(line)});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @Test(dataProvider = "validBoardsfromCSV")
    public void createBoardFromCreateBoardButtonfromCSV(BoardData board) {

        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        app.getBoardHelper().createBoardFromCreateBoardButton(board, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        //  Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(board));
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void createBoardFromCreateBoardButtonTest() {
        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String boardName = "b_no_private_" + System.currentTimeMillis();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        BoardData board = new BoardData().withBoardTitle(boardName);
        app.getBoardHelper().createBoardFromCreateBoardButton(board, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardName));
        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void createBoardFromPlusButtonOnHeaderTest() {
        int before = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        String boardName = "bFromPlus_no_private_" + System.currentTimeMillis();
        String teamName = "no"; //if you want to create a board w/o team,   teamName=="no"
        BoardData board = new BoardData().withBoardTitle(boardName);
        app.getBoardHelper().createBoardFromPlusButtonOnHeader(board, teamName, 0); // status board: public (1)/private (0)/teamVisible (2)
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardName));
        Assert.assertEquals(after, before + 1);
    }


//    @AfterClass
//    public void removeUnnecessaryPersonalBoards() {
//        while (app.getBoardHelper().getPersonalBoardsCount()> 15)
//            app.getBoardHelper().deleteFirstPesonalBoardFromHomePage();
//    }

    @Test
    public void createBoardMobTest() {
        //     int before = app.getBoardHelper().getPersonalBoardsCount();
//        System.out.println(before);
        app.getBoardHelper().clickOnPlusButton();
        String boardName = "mob_" + System.currentTimeMillis();
        BoardData board = new BoardData().withBoardTitle(boardName);
        app.getBoardHelper().createBoard(board);

//        String teamName = "no";
//
//
//        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getPersonalBoardsCount() + app.getBoardHelper().getTeamBoardsCount();
        // Assert.assertTrue(app.getBoardHelper().isBoardExistsByNameCheckOnMainPage(boardName));
        // Assert.assertEquals(after, before + 1);
    }
@Test
    public void countBoard() throws InterruptedException {

    Thread.sleep(10000);
 //int count=  driver.findElements(By.xpath("//*[@content-desc='Board background']/../../..")).size();
 int count=  driver.findElements(By.id("board_name")).size();

    System.out.println(count);
}


}