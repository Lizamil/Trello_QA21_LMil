package trello_tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

   @Test
   public void teamCreationFromPlusButtonOnHeader() throws InterruptedException {
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
    public void teamCreationFromLeftNavButton() throws InterruptedException {
    int before=getTeamsCount();
    //path to Team create form From Left Navigation Button
    clickOnPlusButtonOnLeftNavigationMenu();

    String teamName="qa21_new_new";
    teamCreation(teamName);
    String createdTeamName=getTeamNameFromTeamPage();

    returnToHomePage();

    int after=getTeamsCount();
    Assert.assertEquals(after,before+1);
    Assert.assertEquals(createdTeamName,teamName);

}

    @Test
    public void testIsUserLoggedIn_1(){
        Assert.assertTrue(isUserLoggedIn());

    }

    @Test
    public void testIsUserLoggedIn_2(){
        Assert.assertFalse(isUserLoggedOut());

    }


}
