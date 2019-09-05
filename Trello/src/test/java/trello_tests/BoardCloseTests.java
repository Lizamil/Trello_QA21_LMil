package trello_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCloseTests extends TestBase {

@Test
    public void close(){
   String boardName="25856";
   closeBoard(boardName);
}

}
