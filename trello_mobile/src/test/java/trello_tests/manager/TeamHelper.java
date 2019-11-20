package trello_tests.manager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import trello_tests.model.TeamData;


public class TeamHelper extends HelperBase {


    public TeamHelper(AppiumDriver driver) {
        super(driver);
    }

    //Team Create
    public void teamCreation(TeamData team) {
        fillTeamCreationForm(team);
        clickContinueButtonInTeamCreationForm();
        click(By.cssSelector(".eg0KI5SqghoOFd"));


    }

    public void fillTeamCreationForm(TeamData team) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());
        type(By.cssSelector("textarea"), team.getDescription());
    }

    public void clickContinueButtonInTeamCreationForm() {
        click(By.cssSelector("[type='submit']"));

    }


    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));

    }

    public String getTeamNameFromTeamPage() {

        waitPresenceElement(By.cssSelector("h1"), 15);
        return driver.findElement(By.cssSelector("h1")).getText();

    }

    //Team Delete
    public void deleteFirstTeam()  {
        clickOnFirstTeam();
        openSettings();
        deleteTeam();
        confirm();
        //      returnToHomePage();

    }

    public void cleanTeams() {
        int count = getTeamsCount();
        while (count > 7) {
            deleteFirstTeam();
            count = getTeamsCount();
        }
    }


    public void deleteTeam() {
       waitPresenceElement(By.cssSelector(".quiet-button"), 15);
        click(By.cssSelector(".quiet-button"));

    }

    public void openSettings() {
        waitPresenceElement(By.cssSelector(".icon-gear.icon-sm"), 10);
        click(By.cssSelector(".icon-gear.icon-sm")); // was .icon-gear.icon-sm.OiX3P2i2J92Xat
    }

    public void clickOnFirstTeam() {
        waitPresenceElement(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li"), 10);
        click(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li[1]"));

    }

    public void clickOnPlusButtonOnLeftNavigationMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));

    }


    public void initEditTeamProfile() {
        click(By.cssSelector(".js-edit-profile"));
    }

    public void changeTeamProfile(String newName, String description) {
        type(By.name("displayName"), newName);
        type(By.name("desc"), description);

    }


    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));
    }

    public String getTeamDescription() {
        waitPresenceElement(By.cssSelector(".tabbed-pane-header-details-content"), 15);
        return driver.findElement(By.cssSelector(".tabbed-pane-header-details-content")).getText();
    }
}
