package trello_tests.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import trello_tests.model.TeamData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TeamCreationTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions() {
        if (!app.getSessionHelper().isUserLoggedIn())
            app.getSessionHelper().login("Lizamil@mail.ru", "liza1978");
    }

    @DataProvider
    public Iterator<Object[]> validTeams() {
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"name", "description"});
        list.add(new Object[]{"NAME", "DESC"});
        list.add(new Object[]{"name1518161588555", "1122description"});
        list.add(new Object[]{"123458", "description"});
        list.add(new Object[]{"@#%#^#", "#^%#^dherer@^"});
        list.add(new Object[]{"name", ""});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validTeamsfromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/Team.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new TeamData().withTeamName(split[0]).withDescription(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validTeams")
    public void teamCreationWithDataProvider(String teamName, String description) {
        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);

        int before = app.getSessionHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().teamCreation(team);

        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);
    }


    @Test(dataProvider = "validTeamsfromCSV")
    public void teamCreationFromPlusButtonOnHeaderfromCSV(TeamData team) {

        int before = app.getSessionHelper().getTeamsCount();

        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        app.getTeamHelper().teamCreation(team);
        app.getTeamHelper().returnToHomePage();

        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void teamCreationFromLeftNavButton() {
        String teamName="team_left_but_" + System.currentTimeMillis();
        String description="description__" + System.currentTimeMillis();
        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
        int before = app.getTeamHelper().getTeamsCount();

        app.getTeamHelper().clickOnPlusButtonOnLeftNavigationMenu();
        app.getTeamHelper().teamCreation(team);
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();

        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName, teamName);

    }

    @Test

    public void testTeamCreationFromPlusButtonOnHeader() {
        String teamName="team_plus_but_" + System.currentTimeMillis();
        String description="description__" + System.nanoTime();
        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
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

    @AfterClass()
    public void removeUnnecessaryTeams() throws InterruptedException {
        app.getTeamHelper().cleanTeams();
        }


}
