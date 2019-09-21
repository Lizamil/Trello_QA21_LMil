package trello_tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TeamHelper extends HelperBase{



    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    //Team Create
    public void teamCreation(String teamName) {
        fillTeamCreationForm(teamName, "description qa 21");
        clickContinueButtonInTeamCreationForm();

    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);

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
    public void deleteFirstTeam() throws InterruptedException {
        clickOnFirstTeam();
        openSettings();
        deleteTeam();
        confirm();
        returnToHomePage();

    }

    public void cleanTeams() throws InterruptedException {
        int count = getTeamsCount();
        while (count > 5) {
            deleteFirstTeam();
            count = getTeamsCount();
                  }
    }




    public void deleteTeam() throws InterruptedException {
Thread.sleep(5);
        waitPresenceElement(By.cssSelector(".quiet-button"), 15);
        click(By.cssSelector(".quiet-button"));

    }

    public void openSettings() {

        click(By.cssSelector(".icon-gear.icon-sm.OiX3P2i2J92Xat"));
    }

    public void clickOnFirstTeam() {
        waitPresenceElement(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li"),10);
        click(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li[1]"));

    }

    public void clickOnPlusButtonOnLeftNavigationMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));

    }


    public void initEditTeamProfile() {
        click(By.cssSelector(".js-edit-profile"));
    }

    public void changeTeamProfile(String newName,String description) {
        type(By.name("displayName"),newName);
        type(By.name("desc"),description);

    }


    public void confirmEditTeam() {
        click(By.cssSelector(".js-submit-profile"));
    }

    public String getTeamDescription()  {
        waitPresenceElement(By.cssSelector(".tabbed-pane-header-details-content"), 15);
              return driver.findElement(By.cssSelector(".tabbed-pane-header-details-content")).getText();
    }
}
