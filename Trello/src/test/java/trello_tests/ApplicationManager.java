package trello_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
WebDriver driver;
TeamHelper teamHelper;
BoardHelper boardHelper;
SessionHelper sessionHelper;

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        teamHelper=new TeamHelper(driver);
        boardHelper=new BoardHelper(driver);
        sessionHelper=new SessionHelper(driver);
        sessionHelper.openSite("https://trello.com");
        sessionHelper.login("Lizamil@mail.ru", "liza1978");
    }

    public void stop() {
        driver.quit();
        driver = null;
    }

}
