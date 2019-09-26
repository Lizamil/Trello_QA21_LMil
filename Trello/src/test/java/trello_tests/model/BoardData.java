package trello_tests.model;

public class BoardData {
    private String boardTitle;

    public BoardData withBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
        return  this;
    }

    public String getBoardTitle() {
        return boardTitle;
    }
}
