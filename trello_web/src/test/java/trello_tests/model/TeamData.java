package trello_tests.model;

public class TeamData {
    private String teamName;
    private String description;



    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }

    public TeamData withTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public TeamData withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "Team Name= " + teamName + ", description= " + description;
       // return "Team Name= " + teamName + '\'' + ", description= " + description + '\'';
    }
}

