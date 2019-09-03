package trello_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test

  public void create() {
    String boardName="board_test2_team";
    String teamName="test2"; //if you want to create a board w/o team,   teamName=="no"
    createBoard(boardName,teamName,2); // status board: public (1)/private (0)/teamVisible (2)
    Assert.assertTrue(isUserLoggedIn(boardName));
      }

    @Test

    public void create2() {
        String boardName="board_test1_private";
        String teamName="test1"; //if you want to create a board w/o team,   teamName=="no"
        createBoard(boardName,teamName,0); // status board: public (1)/private (0)/teamVisible (2)
        Assert.assertTrue(isUserLoggedIn(boardName));
    }

    @Test

    public void create3() {
        String boardName="board_no_public";
        String teamName="no"; //if you want to create a board w/o team,   teamName=="no"
        createBoard(boardName,teamName,1); // status board: public (1)/private (0)/teamVisible (2)
        Assert.assertTrue(isUserLoggedIn(boardName));
    }


    private boolean isUserLoggedIn(String name) {
        return isElementPresent(By.cssSelector("[title="+name+"]"));
    }

}
