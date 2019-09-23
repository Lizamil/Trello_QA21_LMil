package trello_tests.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import trello_tests.manager.TeamData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TeamCreationTests extends TestBase {

//    @DataProvider
//    public Iterator<Object[]> validTeams() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"name", "description"});
//        list.add(new Object[]{"NAME", "DESC"});
//        list.add(new Object[]{"name1518161588555", "1122description"});
//        list.add(new Object[]{"123458", "description"});
//        list.add(new Object[]{"@#%#^#", "#^%#^dherer@^"});
//        list.add(new Object[]{"name", ""});
//        return list.iterator();
//    }
//
//    @DataProvider
//    public Iterator<Object[]> validTeamsfromcsv() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(
//                new FileReader(new File("src/test/resources/Team.csv")));
//        String line = reader.readLine();
//        while (line != null) {
//            String[] split = line.split(",");
//            list.add(new Object[]{new TeamData().withTeamName(split[0]).withDescription(split[1])});
//            line = reader.readLine();
//        }
//        return list.iterator();
//    }

    @BeforeClass
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn())
            app.getSessionHelper().login("Lizamil@mail.ru", "liza1978");
    }


//    @Test(dataProvider = "validTeams")
//    public void teamCreationWithDataProvider(String teamName, String description) {
//        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
//
//        int before = app.getSessionHelper().getTeamsCount();
//        app.getTeamHelper().clickOnPlusButtonOnHeader();
//        app.getTeamHelper().selectCreateTeamFromDropDown();
//        app.getTeamHelper().teamCreation(team);
//        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
//        app.getTeamHelper().returnToHomePage();
//        int after = app.getTeamHelper().getTeamsCount();
//
//        Assert.assertEquals(after, before + 1);
//        Assert.assertEquals(createdTeamName, teamName);
//    }
//
//
//    @Test(dataProvider = "validTeamsfromcsv")
//    public void teamCreationFromPlusButtonOnHeader(String teamName, String description) {
//        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
//        int before = app.getSessionHelper().getTeamsCount();
//        //path to Team create form From Plus Button On Header
//        app.getTeamHelper().clickOnPlusButtonOnHeader();
//        app.getTeamHelper().selectCreateTeamFromDropDown();
//        app.getTeamHelper().teamCreation(team);
//        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
//
//        app.getTeamHelper().returnToHomePage();
//
//        int after = app.getTeamHelper().getTeamsCount();
//        Assert.assertEquals(after, before + 1);
//        Assert.assertEquals(createdTeamName, teamName);
//    }

//    @Test
//    public void teamCreationFromLeftNavButton(String teamName, String description) {
//        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
//        int before = app.getTeamHelper().getTeamsCount();
//        app.getTeamHelper().clickOnPlusButtonOnLeftNavigationMenu();
//        app.getTeamHelper().teamCreation(team);
//        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
//
//        app.getTeamHelper().returnToHomePage();
//        int after = app.getTeamHelper().getTeamsCount();
//        Assert.assertEquals(after, before + 1);
//        Assert.assertEquals(createdTeamName, teamName);
//
//    }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader_Elena() {
        String teamName="qa__" + System.currentTimeMillis();
        TeamData team = new TeamData().withTeamName(teamName).withDescription("description qa");
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().teamCreation(team);
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);
    }





    @AfterClass(enabled = false)
    public void removeUnnecessaryTeams() throws InterruptedException {
        int count = app.getTeamHelper().getTeamsCount();
        while (count > 5) {
            app.getTeamHelper().deleteFirstTeam();
            count = app.getTeamHelper().getTeamsCount();
        }
    }


}
