package trello_tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeleteTest extends TestBase {

    @BeforeMethod
    public void isTeamExist() {
        if (getTeamsCount() == 0) {
            clickOnPlusButtonOnHeader();
            selectCreateTeamFromDropDown();
            teamCreation("team1");
        }
    }

    @Test

    public void deleteTeamFromLeftNavMenu() {
        int before = getTeamsCount();
        deleteFirstTeam();
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(before, after - 1);

    }

    @Test
    public void deleteTeamWhileCountMoreThanNeedNumber() {
        int needCount = 4;
        int countTeam = getTeamsCount();
        while (countTeam > needCount) {
            deleteFirstTeam();
            countTeam = getTeamsCount();
        }
        Assert.assertEquals(needCount, needCount);
    }

}
