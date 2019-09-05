package trello_tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {

    @Test
    public void boardDelete(){
        clickOnBoardButtonOnHeader();
        selectSeeCloseBoardsFromDropDown();
        deleteBoardByName("25856");
    }

    public void deleteBoardByName(String boardName) {
        if(isElementPresent(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'"+boardName+"')]"))) {
            click(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'" + boardName + "')]/../..//span[@ name='remove']"));
        click(By.cssSelector("._3G2HCCjNJGfeNW"));}
        else System.out.println("This board doesn't exist");
    }
}
