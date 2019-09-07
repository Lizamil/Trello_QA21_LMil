package trello_tests;

import net.bytebuddy.utility.JavaModule;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCloseTests extends TestBase {
/*
1."qa22_team" --             2."qa22_private" --                 3."board_qa21_private_113"
4."board_no_private_13" -+   5."board_no_private_1" +            6."board_no_private_113" +
7."err_private" --           8."err_public" --                   9."err_team" +
10."no_public" --            11."no_private" +                   12."qa22_public" --
13."no_team" +               14."board_autoaTeam_private" --     15."board_team2_public" --
* */
    @Test
    public void close01() throws InterruptedException {
        returnToHomePage();
        String boardName = "qa22_team";
        closeBoard(boardName);
    }
    @Test
    public void close02() throws InterruptedException {
        returnToHomePage();
        String boardName = "qa22_private";
        closeBoard(boardName);
    }
    @Test
    public void close03() throws InterruptedException {
        returnToHomePage();
        String boardName = "board_team2_public";
        closeBoard(boardName);
    }




}

