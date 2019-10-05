package trello_tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import trello_tests.model.TeamData;

public class TeamModificationTest extends TestBase {

    @BeforeMethod
    public void isTeamExist() {
        if (app.getTeamHelper().getTeamsCount() == 0) {
            TeamData team = new TeamData().withTeamName("team_1").withDescription("description");
            app.getTeamHelper().clickOnPlusButtonOnHeader();
            app.getTeamHelper().selectCreateTeamFromDropDown();
            app.getTeamHelper().teamCreation(team);
            app.getTeamHelper().returnToHomePage();
        }
    }

    @Test

    public void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfile();
        String nameTeam = "team_" + System.currentTimeMillis();
        String des = "newDescription";
        app.getTeamHelper().changeTeamProfile(nameTeam, des);
        app.getTeamHelper().confirmEditTeam();
        Thread.sleep(2000);
        Assert.assertEquals(nameTeam, app.getTeamHelper().getTeamNameFromTeamPage());
        Assert.assertEquals(des, app.getTeamHelper().getTeamDescription());
        app.getTeamHelper().returnToHomePage();
        app.getTeamHelper().click(By.cssSelector("[href='/elizaveta528/boards']"));
        Thread.sleep(5000);
        }
}
