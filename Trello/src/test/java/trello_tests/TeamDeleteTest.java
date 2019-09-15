package trello_tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeleteTest extends TestBase {

    @BeforeMethod
    public void isTeamExist() {
        if (app.getTeamsCount() == 0) {
            app.clickOnPlusButtonOnHeader();
            app.selectCreateTeamFromDropDown();
            app.teamCreation("team1");
        }
    }

    @Test

    public void deleteTeamFromLeftNavMenu() {
        int before = app.getTeamsCount();
        app.deleteFirstTeam();
       // returnToHomePage();
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before - 1);

    }

    @Test (enabled=false)
    public void deleteTeamWhileCountMoreThanNeedNumber() {
        int needCount = 4;
        int countTeam = app.getTeamsCount();
        while (countTeam > needCount) {
            app.deleteFirstTeam();
            countTeam = app.getTeamsCount();
        }
        Assert.assertEquals(needCount, needCount);
    }

}
