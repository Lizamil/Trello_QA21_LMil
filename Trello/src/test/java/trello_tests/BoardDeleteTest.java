package trello_tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @Test
    public void boardDelete(){
        clickOnBoardButtonOnHeader();
        selectSeeCloseBoardsFromDropDown();
        //list closed boards more than monitor ???????????????????????????
        deleteBoardByName("forclose");
        deleteBoardByName("board_test2_team");
        deleteBoardByName("board_no_private_5");
        deleteBoardByName("board_no_private_4");
        deleteBoardByName("board_no_private_3");
        deleteBoardByName("board_no_private_2");
    }

}
