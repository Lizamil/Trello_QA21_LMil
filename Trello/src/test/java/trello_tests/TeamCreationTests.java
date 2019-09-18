package trello_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeClass
public void ensurePreconditions(){
        if(!app.getSessionHelper().isUserLoggedIn())
            app.getSessionHelper().login("Lizamil@mail.ru","liza1978");
    }

    @Test (priority = 2)
   public void teamCreationFromPlusButtonOnHeader() {
       int before= app.getSessionHelper().getTeamsCount();
       //path to Team create form From Plus Button On Header
       app.getTeamHelper().clickOnPlusButtonOnHeader();
       app.getTeamHelper().selectCreateTeamFromDropDown();

       String teamName="teamPlusBut_"+System.currentTimeMillis();;
       app.getTeamHelper().teamCreation(teamName);
       String createdTeamName= app.getTeamHelper().getTeamNameFromTeamPage();

       app.getTeamHelper().returnToHomePage();

       int after= app.getTeamHelper().getTeamsCount();
       Assert.assertEquals(after,before+1);
       Assert.assertEquals(createdTeamName,teamName);
       }

    @Test(priority = 1)
    public void teamCreationFromLeftNavButton()  {
    int before= app.getTeamHelper().getTeamsCount();
    //path to Team create form From Left Navigation Button
    app.getTeamHelper().clickOnPlusButtonOnLeftNavigationMenu();

    String teamName="qa21__"+System.currentTimeMillis();
    app.getTeamHelper().teamCreation(teamName);
    String createdTeamName= app.getTeamHelper().getTeamNameFromTeamPage();

    app.getTeamHelper().returnToHomePage();

    int after= app.getTeamHelper().getTeamsCount();
    Assert.assertEquals(after,before+1);
    Assert.assertEquals(createdTeamName,teamName);

}

    @AfterClass
    public void removeUnnecessaryTeams() throws InterruptedException {
        while (app.getTeamHelper().getTeamsCount() > 5)
            app.getTeamHelper().deleteFirstTeam();
    }


}
