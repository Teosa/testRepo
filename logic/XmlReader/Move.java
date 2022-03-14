package Ylab.Game_Lesson2.logic.XmlReader;

public  final class Move {
  final   int playerId;
  final   int coordinate;
  final   int num;

    public Move(final int playerId, final int coordinate, final int num) {
        this.playerId = playerId;
        this.coordinate = coordinate;
        this.num = num;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Move{" +
                "playerId=" + playerId +
                ", coordinate=" + coordinate +
                ", num=" + num +
                '}';
    }
}
