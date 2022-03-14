package Ylab.Game_Lesson2.logic.XmlReader;

public class Player {
    private String id;
    private String name;
    private String symbol;
    private int moveCounter;
    private boolean isWinner;

    public Player(final String id, final String name, final String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        // При создании всегда 0, так как мы еще не начали игру
        this.moveCounter = 0;
    }

    public Player() {
        // При создании всегда 0, так как мы еще не начали игру
        this.moveCounter = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void increaseMoveCount() {
        moveCounter++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
