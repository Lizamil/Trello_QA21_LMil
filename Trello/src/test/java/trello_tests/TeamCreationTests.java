package trello_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {

   @Test

   public void teamCreationFromPlusButtonOnHeader(){
           clickOnPlusButtonOnHeader();
           selectCreateTeamFromDropDown();
           fillTeamCreationForm("autoTeam1", "description qa 21");
           clickContinueButton();
       }

    @Test
    public void testTeamCreation(){
        Assert.assertTrue(isUserLoggedIn());

    }

    @Test
    public void testTeamCreation1(){
        Assert.assertFalse(isUserLoggedOut());

    }


}
