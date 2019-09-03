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
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        openSite("https://trello.com");
        login("Lizamil@mail.ru","liza1978");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
       driver.quit();

    }

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

    public void clickConfirm() {
        click(By.id("login"));
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.id("user"), email);
        type(By.id("password"), password);
        clickConfirm();
    }

    public void createBoard(String boardTitle, String teamName,Integer status) {
    //enter button create new board from home page, Personal Boards section
            click(By.cssSelector("[class='board-tile mod-add']"));
     // enter board title
            type(By.cssSelector("[placeholder='Add board title']"), boardTitle);
     //team yes (1)/no (0)
            if (isTeamExist()) {
                click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
                if (teamName == "no")
                    click(By.xpath("//*[@class='pop-over-list org-chooser']//li[1]"));
                else {
                    clickByContains(teamName);
                     }
            }
    //board public (1)/private (0)/teamVisible (2)
            click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
            if (teamName != "no" && isTeamExist()) {
                if (status == 0)
                    click(By.xpath("//ul[@class='pop-over-list vis-chooser']//*[@class='icon-sm icon-private']"));
                if (status == 1) {
                    click(By.xpath("//ul[@class='pop-over-list vis-chooser']/li[3]"));
                    click(By.cssSelector("[class='js-confirm full primary']"));
                         }
                if (status == 2) {
                    click(By.xpath("//ul[@class='pop-over-list vis-chooser']/li[2]"));
                }
            }
            else {
               // click(By.cssSelector("[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
                if (status == 0||status == 2)
                    click(By.xpath("//ul[@class='pop-over-list vis-chooser']//span[@class='icon-sm icon-private']"));
                if (status == 1) {
                    click(By.cssSelector("[class='icon-sm icon-public']"));
                    click(By.cssSelector("[class='js-confirm full primary']"));
                }
                }
            click(By.cssSelector("[class='primary']"));
            openSite("https://trello.com");
               }

    public void clickByContains(String teamName) {
            click(By.xpath("//a[@href='#']//div[contains(text(),'"+teamName+"')]"));
        }

    private boolean isTeamExist(){
    return driver.findElements(By.cssSelector("[class='icon-lg icon-organization']")).size()>0;
    }

    protected boolean isElementPresent(By locator) {
            return driver.findElements(locator).size()>0;
        }
}
