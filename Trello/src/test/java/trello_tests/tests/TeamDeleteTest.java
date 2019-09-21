package trello_tests.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeleteTest extends TestBase {

    @BeforeMethod
       public void isTeamExist() {
        if(app.getTeamHelper().getTeamsCount()==0)
            {
            app.getTeamHelper().clickOnPlusButtonOnHeader();
            app.getTeamHelper().selectCreateTeamFromDropDown();
            app.getTeamHelper().teamCreation("team1");
            app.getTeamHelper().returnToHomePage();
        }
    }

    @Test

    public void deleteTeamFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().deleteFirstTeam();

        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before - 1);

    }

    @Test (enabled=false)
    public void deleteTeamWhileCountMoreThanNeedNumber() throws InterruptedException {
        int needCount = 4;
        int countTeam = app.getTeamHelper().getTeamsCount();
        while (countTeam > needCount) {
            app.getTeamHelper().deleteFirstTeam();
            countTeam = app.getTeamHelper().getTeamsCount();
        }
        Assert.assertEquals(needCount, needCount);
    }

}
