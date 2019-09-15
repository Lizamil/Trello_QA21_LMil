package trello_tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeClass
public void ensurePreconditions(){
        if(!app.isUserLoggedIn())
            app.login("Lizamil@mail.ru","liza1978");
    }

    @Test
   public void teamCreationFromPlusButtonOnHeader() {
       int before= app.getTeamsCount();
       //path to Team create form From Plus Button On Header
       app.clickOnPlusButtonOnHeader();
       app.selectCreateTeamFromDropDown();

       String teamName="teamPlusBut_"+System.currentTimeMillis();;
       app.teamCreation(teamName);
       String createdTeamName= app.getTeamNameFromTeamPage();

       app.returnToHomePage();

       int after= app.getTeamsCount();
       Assert.assertEquals(after,before+1);
       Assert.assertEquals(createdTeamName,teamName);
       }

    @Test
    public void teamCreationFromLeftNavButton()  {
    int before= app.getTeamsCount();
    //path to Team create form From Left Navigation Button
    app.clickOnPlusButtonOnLeftNavigationMenu();

    String teamName="qa21__"+System.currentTimeMillis();
    app.teamCreation(teamName);
    String createdTeamName= app.getTeamNameFromTeamPage();

    app.returnToHomePage();

    int after= app.getTeamsCount();
    Assert.assertEquals(after,before+1);
    Assert.assertEquals(createdTeamName,teamName);

}

    @AfterClass
    public void removeUnnecessaryTeams() {
        while (app.getTeamsCount() > 4)
            app.deleteFirstTeam();
    }

}
