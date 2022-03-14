package Ylab.Game_Lesson2.logic.XmlReader;

public class Player {
    private final String id;
    private final String name;
    private final String symbol;

    public Player(final String id, final String name, final String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}
