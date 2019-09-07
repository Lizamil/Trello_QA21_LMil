package trello_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUP() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openSite("https://trello.com");
        login("Lizamil@mail.ru","liza1978");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
      //  driver.quit();

    }

    //Base Methods
    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void click(By locator) {
        driver.findElement(locator).click();

    }
    public void openSite(String url) {
        driver.get(url);

    }
    public void returnToHomePage() throws InterruptedException {
        Thread.sleep(10000);
        click(By.xpath("//a[@href='/']"));
        click(By.xpath("//a[@href='/']"));
    }
    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.id("user"), email);
        type(By.id("password"), password);
        clickConfirmLogin();
    }
    public void clickConfirmLogin() {
        click(By.id("login"));

    }
    public void clickOnPlusButtonOnHeader() {
        click(By.name("add"));

    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public boolean isElementVisible(By locator){
        return driver.findElement(locator).isDisplayed();

    }
    public boolean isTeamExist(){
    return driver.findElements(By.cssSelector("[class='icon-lg icon-organization']")).size()>0;
    }

        //Board Create
    public int getTeamBoardsCount() {
            if(getTeamsCount()>0)
                return driver.findElements
                        (By.xpath("//span[@class='icon-lg icon-organization']/../../..//li")).size()-getTeamsCount();
            return 0;

        }
    public int getPersonalBoardsCount() {
        return driver.findElements(
                By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size()-1;

    }

    public void createBoard(String boardTitle, String teamName, Integer status) {
        int countOfTeam =getTeamsCount();
        clickOnCreateNewBoardOnHomePage();
        fillBoardCreationForm(boardTitle);
        int IndexTeam=enterTeamNameInCreateNewBordForm(teamName,countOfTeam);
        enterBoardStatusInCreateNewBordForm(teamName,countOfTeam, status, IndexTeam);
        confirmCreateBoardInCreateForm();

    }
    public void clickOnCreateNewBoardOnHomePage() {
        click(By.cssSelector("[class='board-tile mod-add']"));

    }
    public void fillBoardCreationForm(String boardTitle) {
        type(By.cssSelector("[placeholder='Add board title']"), boardTitle);

    }
    public int enterTeamNameInCreateNewBordForm(String teamName, int countOfTeam) {
        int i=1;
        if (countOfTeam>0) {
            click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
            i=searchIndexTeamNameInPopDownInBoardCreateForm(teamName,countOfTeam);
            click(By.xpath("//*[@class='pop-over-list org-chooser']//li["+i+"]"));
        }
        return i;
    }
    public void enterBoardStatusInCreateNewBordForm(String teamName, int countOfTeam, int status,int IndexTeam) {
        //board public (1)/private (0)/teamVisible (2)
        click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
        if (IndexTeam>1) {
            if (status == 0)
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']//*[@class='icon-sm icon-private']"));
            if (status == 1) {
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']/li[3]"));
                click(By.cssSelector("[class='js-confirm full primary']"));
            }
            if (status == 2)
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']/li[2]"));
        }
        else{ //if (teamName = "no")
            if (status == 0||status == 2)
                click(By.xpath("//ul[@class='pop-over-list vis-chooser']//span[@class='icon-sm icon-private']"));
            if (status == 1) {
                click(By.cssSelector("[class='icon-sm icon-public']"));
                click(By.cssSelector("[class='js-confirm full primary']"));
            }
        }

    }
    public int searchIndexTeamNameInPopDownInBoardCreateForm(String teamName, int countOfTeam){
        String hhh="";
        int count=countOfTeam+1;
        for(int i=1;i<=count;i++){
            hhh=driver.findElement(By.xpath("//*[@class='pop-over-list org-chooser']//li["+i+"]")).getText();
            if(hhh.equals(teamName))
                return i;
        }
        return 1;
    }
    public void confirmCreateBoardInCreateForm() {
        click(By.cssSelector(".primary"));

    }

    public boolean isBoardExistsByNameCheckOnMainPage(String name) {
        return isElementPresent(By.cssSelector("[title="+name+"]"));

    }

    //Board Close
    public void closeBoard(String boardName) throws InterruptedException {
        //check that the board exists and enter to the board Main Page
        if (isElementPresent(By.xpath("//div[@title='"+boardName+"']")))
            click(By.xpath("//div[@title='"+boardName+"']"));
        else {
            System.out.println("Board doesn't exist");
            return;}
        //if open Menu
        if(isElementPresent(By.cssSelector
                    ("[class='board-menu-navigation-item-link js-about-this-board']"))==true && isElementVisible(
      By.cssSelector("[class='board-menu-navigation-item-link js-about-this-board']")))

        click((By.cssSelector("[title='Close the board menu.']")));

        //if open About this Board Menu
        if(isElementPresent(By.cssSelector
                ("[class='board-menu-header-title js-board-menu-title-text']"))==true && isElementVisible(By.cssSelector
                ("[class='board-menu-header-title js-board-menu-title-text']")))
        click((By.cssSelector("[title='Go back.']")));


        clickOnShowMenuButtonOnBoardPage();

        if(isElementPresent(By.cssSelector
                ("[class='board-menu-header-title js-board-menu-title-text']"))==true && isElementVisible(By.cssSelector
                ("[class='board-menu-header-title js-board-menu-title-text']")))
        { click((By.cssSelector("[title='Go back.']")));}

        selectMoreInMenuOnBoardPage();
        selectCloseBoardInMoreInMenuOnBoardPage();
        confirmCloseBoard();
        returnToHomePage();
        }

    public void clickOnShowMenuButtonOnBoardPage() {
        click(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"));

    }
    public void selectMoreInMenuOnBoardPage() {
      click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
      //click(By.cssSelector("[class='icon-sm icon-overflow-menu-horizontal board-menu-navigation-item-link-icon']"));
    }
    public void selectCloseBoardInMoreInMenuOnBoardPage() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }
    public void confirmCloseBoard() {
        click(By.cssSelector("[class='js-confirm full negate']"));

    }
    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));

    }

    // find Elements
    public boolean isUserLoggedIn() {
        return isElementPresent(By.name("house"));

    }

    public boolean isUserLoggedOut() {
        return isElementPresent(By.cssSelector("[href='/login']"));

    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        type(By.cssSelector("textarea"),description);

    }


    public void reOpenBoardByName(String boardName) {
        if(isElementPresent(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'"+boardName+"')]")))
            click(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'"+boardName+"')]/../..//span[@ name='refresh']"));
        else System.out.println("This board doesn't exist");

    }
    public void selectSeeCloseBoardsFromDropDown() {
        click(By.cssSelector("[data-test-id='header-boards-menu-open-closed']"));

    }
    public void clickOnBoardButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-boards-menu-button']"));

    }

    //Team
    public void teamCreation(String teamName) {
       fillTeamCreationForm(teamName, "description qa 21");
       clickContinueButtonInTeamCreationForm();

           }
    public void clickContinueButtonInTeamCreationForm() {
        click(By.cssSelector("[type='submit']"));

    }
    public void clickOnPlusButtonOnLeftNavigationMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));

    }
    public int getTeamsCount() {
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();

    }
    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));

    }
    public String getTeamNameFromTeamPage() {
        return driver.findElement(By.cssSelector("h1")).getText();

    }



    public void clickByContains(String teamName) {
        click(By.xpath("//a[@href='#']//div[contains(text(),'" + teamName + "')]"));
    }

    public void deleteBoardByName(String boardName) {
        if(isElementPresent(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'"+boardName+"')]"))) {
            click(By.xpath("//ul[@class='_3Qi2qlYDnzYhMI']/li//a[contains(text(),'" + boardName + "')]/../..//span[@ name='remove']"));
        click(By.cssSelector("._3G2HCCjNJGfeNW"));}
        else System.out.println("This board doesn't exist");
    }
}
