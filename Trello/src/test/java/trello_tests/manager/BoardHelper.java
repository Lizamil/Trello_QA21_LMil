package trello_tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import trello_tests.model.BoardData;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    //Count of Boards
    public int getPersonalBoardsCount() {
        waitPresenceElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//li"), 10);
        return driver.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size() - 1;

    }

    public int getTeamBoardsCount() {
        if (getTeamsCount() > 0)
            return driver.findElements
                    (By.xpath("//span[@class='icon-lg icon-organization']/../../..//li")).size() - getTeamsCount();
        return 0;

    }

    public int getClosedBoardsCount() {
        if (!isElementPresent(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li")))
            return 0;
        waitPresenceElement(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li"), 10);
        return driver.findElements(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li")).size();
    }

    //Create Board From Create Board Button
    public void createBoardFromCreateBoardButton(BoardData board, String teamName, int status) {
        int countOfTeam = getTeamsCount();
        clickOnCreateNewBoardOnHomePage();
        fillBoardCreationForm(board);
        int IndexTeam = enterTeamNameToCreateBoardViaCreateBoardButton(teamName, countOfTeam);
        enterBoardStatusToCreateBoardViaCreateBoardButton(teamName, countOfTeam, status, IndexTeam);
        confirmnOnBoardIPage();

    }

    //Create Board From Plus Button On Header
    public void createBoardFromPlusButtonOnHeader(BoardData board, String teamName, int status) {
        int countOfTeam = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm(board);
        int IndexTeam = enterTeamNameToCreateBoardViaPlusButtonOnHeader(teamName, countOfTeam);
        enterBoardStatusToCreateBoardViaPlusButtonOnHeader(teamName, countOfTeam, status, IndexTeam);
        click(By.cssSelector("[type='button']"));//confirm Create
    }


    public void clickOnCreateNewBoardOnHomePage() {
        click(By.cssSelector(".board-tile.mod-add"));

    }

    public void fillBoardCreationForm(BoardData boardData) {
        type(By.cssSelector("[placeholder='Add board title']"), boardData.getBoardTitle());

    }

    public void confirmnOnBoardIPage() {
        click(By.cssSelector(".primary"));

    }

    public int enterTeamNameToCreateBoardViaCreateBoardButton(String teamName, int countOfTeam) {
        int i = 1;
        if (countOfTeam > 0) {
            click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
            i = searchIndexTeamNameToCreateBoardViaCreateBoardButton(teamName, countOfTeam);
            click(By.xpath("//*[@class='pop-over-list org-chooser']//li[" + i + "]"));
        }
        return i;
    }

    public int searchIndexTeamNameToCreateBoardViaCreateBoardButton(String teamName, int countOfTeam) {
        String hhh = "";
        int count = countOfTeam + 1;
        for (int i = 1; i <= count; i++) {
            hhh = driver.findElement(By.xpath("//*[@class='pop-over-list org-chooser']//li[" + i + "]")).getText();
            if (hhh.equals(teamName))
                return i;
        }
        return 1;
    }

    public void enterBoardStatusToCreateBoardViaCreateBoardButton(String teamName, int countOfTeam, int status, int IndexTeam) {
        //board public (1)/private (0)/teamVisible (2)
        click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
        if (IndexTeam > 1) {
            if (status == 0)
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']//*[@class='icon-sm icon-private']"));
            if (status == 1) {
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']/li[3]"));
                confirm();
            }
            if (status == 2)
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']/li[2]"));
        } else { //if (teamName = "no")
            if (status == 0 || status == 2)
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']//span[@class='icon-sm icon-private']"));
            if (status == 1) {
                click(By.cssSelector("[class='icon-sm icon-public']"));
                confirm();
            }
        }

    }



    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));

    }

    public int enterTeamNameToCreateBoardViaPlusButtonOnHeader(String teamName, int countOfTeam) {
        int i = 1;
        if (countOfTeam > 0) {
            click(By.cssSelector("._1vk4y48RR5OmqE"));
            i = searchIndexTeamNameToCreateBoardViaPlusButtonOnHeader(teamName, countOfTeam);
            click(By.xpath("//*[@class='SdlcRrTVPA8Y3K']//li[" + i + "]"));
        }
        return i;
    }

    public int searchIndexTeamNameToCreateBoardViaPlusButtonOnHeader(String teamName, int countOfTeam) {
        String hhh = "";
        int count = countOfTeam + 1;
        for (int i = 1; i <= count; i++) {
            hhh = driver.findElement(By.xpath("//*[@class='SdlcRrTVPA8Y3K']//li[" + i + "]")).getText();
            if (hhh.equals(teamName))
                return i;
        }
        return 1;
    }

    public void enterBoardStatusToCreateBoardViaPlusButtonOnHeader(String teamName, int countOfTeam, int status, int IndexTeam) {
        //board public (1)/private (0)/teamVisible (2)
        click(By.cssSelector("._1Lkx3EjS3wCrs7"));
        if (IndexTeam > 1) {
            if (status == 0)
                click(By.xpath("//*[@class='_3n2uNSrVwAmo1u']//li[1]"));//private
            if (status == 1) {
                click(By.xpath("//*[@class='_3n2uNSrVwAmo1u']//li[3]")); //public
                click(By.cssSelector("._3UeOvlU6B5KUnS._2MgouXHqRQDP_5._3ZPeWh5QQj47DA"));//confirm
            }
            if (status == 2)
                click(By.xpath("//*[@class='_3n2uNSrVwAmo1u']//li[2]"));
        } else { //if (teamName = "no")
            if (status == 0 || status == 2)
                click(By.xpath("//*[@class='_2R1DnMySK1mTDa']//li[1]"));
            if (status == 1) {
                click(By.xpath("//*[@class='_2R1DnMySK1mTDa']//li[2]"));
                click(By.cssSelector("._3UeOvlU6B5KUnS._2MgouXHqRQDP_5._3ZPeWh5QQj47DA"));//confirm
            }
        }

    }


    //Board Close
    public void closeFirstPersonalBoard() {
        clickOnFirstBoard();
        clickOnMoreButtonInBoardMenuNew();
        selectCloseBoardInMoreInMenuOnBoardPage();
        confirm();
    }

    public void clickOnFirstBoard() {
        waitPresenceElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//li"),15);
        click(By.xpath("//span[@class='icon-lg icon-member']/../../..//li"));
    }

    public void selectCloseBoardInMoreInMenuOnBoardPage() {
        waitPresenceElement(By.cssSelector(".js-close-board"), 15);
        click(By.cssSelector(".js-close-board"));

    }

    public void clickOnShowMenuButtonOnBoardPage() {
        click(By.cssSelector(".mod-show-menu"));

    }

    public void selectMoreInMenuOnBoardPage() {
        click(By.cssSelector(".js-open-more"));

    }

    public void clickOnMoreButtonInBoardMenu() {   //right method
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        System.out.println(menuButton.getCssValue("visibility"));
        if (menuButton.getCssValue("visibility").equals("visible")) {
            clickOnShowMenuButtonOnBoardPage();
            selectMoreInMenuOnBoardPage();
        } else {
            selectMoreInMenuOnBoardPage();
        }
    }

    public void clickOnMoreButtonInBoardMenuNew() {
        WebElement menuButton = driver.findElement(By.cssSelector(".board-header-btn.mod-show-menu"));
        System.out.println(menuButton.getCssValue("visibility"));
        if (menuButton.getCssValue("visibility").equals("visible")) {
            //if ShowMenu Button visible
            clickOnShowMenuButtonOnBoardPage();
            actionsAfterClickingOnShowMenuButtonToCloseBoard();
            selectMoreInMenuOnBoardPage();
        } else { // if ShowMenu Button hidden
            actionsAfterClickingOnShowMenuButtonToCloseBoard();
            selectMoreInMenuOnBoardPage();
        }
    }

    public void actionsAfterClickingOnShowMenuButtonToCloseBoard() {
        if (isElementPresent(By.cssSelector(".icon-member.icon-lg.window-module-title-icon"))) {
            // if open About this Board Menu
            click(By.cssSelector(".board-menu-header-back-button"));
        }
    }

    //Board Delete
    public void deleteFirstPesonalBoardFromHomePage() {
        clickOnFirstBoard();
        clickOnMoreButtonInBoardMenuNew();
        selectCloseBoardInMoreInMenuOnBoardPage();
        confirm();
        click(By.cssSelector(".js-delete"));
        confirm();
        returnToHomePage();
        refreshPage();

    }

    //Delete & ReOpen boards through Closed Boards Form
    public void selectSeeCloseBoardsFromDropDown() {
        click(By.cssSelector("[data-test-id='header-boards-menu-open-closed']"));

    }

    public void clickOnBoardButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-boards-menu-button']"));

    }

    public void deleteBoardByNameFromClosedBoardsForm(String boardName) throws InterruptedException {
        if (isElementPresent(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'" + boardName + "')]"))) {
            click(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'" + boardName + "')]/../..//span[@ name='remove']"));
            click(By.cssSelector("._3G2HCCjNJGfeNW"));
            new WebDriverWait(driver, 3);
            Thread.sleep(1500);
        } else System.out.println("This board doesn't exist");
    }

    public void closeClosedBoardsForm() {
        waitPresenceElement(By.cssSelector("[class='_2BQG4yPMt5s_hu lAz6zCcJVJePNN _20uPs4MFhz7Z5r _3TXPFC9AbvtH0v iV27mPo7If_zwQ vmfY4Z5HOr-J1T']"), 10);
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu lAz6zCcJVJePNN _20uPs4MFhz7Z5r _3TXPFC9AbvtH0v iV27mPo7If_zwQ vmfY4Z5HOr-J1T']"));
    }

    public void reOpenBoardByName(String boardName) throws InterruptedException {
        if (isElementPresent(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'" + boardName + "')]"))) {
            click(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'" + boardName + "')]/../..//span[@ name='refresh']"));
            Thread.sleep(1500);
        } else System.out.println("This board doesn't exist");

    }

    //For assert
    public boolean isThereBoardsPresent() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    public boolean isBoardExistsByNameCheckOnMainPage(String name) {
        return isElementPresent(By.cssSelector("[title=" + name + "]"));

    }


    public void renameBoard(String newName, String boardNameCurrent) {
        focusOn(By.cssSelector(".mod-board-name"));
        click(By.cssSelector("[class='board-name-input js-board-name-input']"));
        clearString(boardNameCurrent);
        sendText(By.cssSelector("[class='board-name-input js-board-name-input']"), newName + "\n");
    }
    public String getBoardNameFromBoardPage() {

        waitPresenceElement(By.cssSelector(".mod-board-name"), 15);
        return driver.findElement(By.cssSelector(".mod-board-name")).getText();

    }

    public int getListCount() {
        return driver.findElements(By.xpath("//*[@class='list-header-target js-editing-target']")).size();
    }

    public void focusOn(By locator){
        new Actions(driver).moveToElement(driver.findElement(locator)).click().perform();
    }


    public void clearString(String name) {
        int count = name.length();
        for (int i = 0; i < count/2+1; i++) {
            right();
        }
        for (int i = 0; i < count; i++) {
            backSpase();
        }
    }


    public void backSpase(){
        driver.findElement(By.cssSelector("[class='board-name-input js-board-name-input']")).sendKeys(Keys.BACK_SPACE);

    }
    public void right(){
        driver.findElement(By.cssSelector("[class='board-name-input js-board-name-input']")).sendKeys(Keys.ARROW_RIGHT);

    }

    public void renameBoardShort(String newName) {
       click(By.cssSelector(".js-rename-board"));
       sendText(By.cssSelector("input.js-board-name-input"), newName + "\n");
    }
}
