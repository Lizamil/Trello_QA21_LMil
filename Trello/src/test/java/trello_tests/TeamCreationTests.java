package trello_tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeClass
public void ensurePreconditions(){
        if(!isUserLoggedIn())
            login("Lizamil@mail.ru","liza1978");
    }

    @Test
   public void teamCreationFromPlusButtonOnHeader() {
       int before=getTeamsCount();
       //path to Team create form From Plus Button On Header
       clickOnPlusButtonOnHeader();
       selectCreateTeamFromDropDown();

       String teamName="qa22";
       teamCreation(teamName);
       String createdTeamName=getTeamNameFromTeamPage();

       returnToHomePage();

       int after=getTeamsCount();
       Assert.assertEquals(after,before+1);
       Assert.assertEquals(createdTeamName,teamName);
       }

    @Test
    public void teamCreationFromLeftNavButton()  {
    int before=getTeamsCount();
    //path to Team create form From Left Navigation Button
    clickOnPlusButtonOnLeftNavigationMenu();

    String teamName="qa21__"+System.currentTimeMillis();
    teamCreation(teamName);
    String createdTeamName=getTeamNameFromTeamPage();

    returnToHomePage();

    int after=getTeamsCount();
    Assert.assertEquals(after,before+1);
    Assert.assertEquals(createdTeamName,teamName);

}

    @AfterClass
    public void removeUnnecessaryTeams() {
        while (getTeamsCount() > 4)
            deleteFirstTeam();
    }

}
