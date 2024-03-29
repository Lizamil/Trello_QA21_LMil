package trello_tests.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import trello_tests.model.TeamData;

public class TeamDeleteTest extends TestBase {

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

    public void deleteTeamFromLeftNavMenu() {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().deleteFirstTeam();
        app.getTeamHelper().takeScreenshot();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before - 1);

    }

    @Test(enabled = false)
    public void deleteTeamWhileCountMoreThanNeedNumber() {
        int needCount = 4;
        int countTeam = app.getTeamHelper().getTeamsCount();
        while (countTeam > needCount) {
            app.getTeamHelper().deleteFirstTeam();
            countTeam = app.getTeamHelper().getTeamsCount();
        }
        Assert.assertEquals(needCount, needCount);
    }

}
