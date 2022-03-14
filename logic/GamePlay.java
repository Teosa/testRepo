package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.logic.XmlReader.Move;

import java.util.ArrayList;
import java.util.List;


public class GamePlay {

  public List<Move> moves = new ArrayList<>();

    @Override
    public String toString() {
        return "GamePlay{" +
                "moves=" + moves +
                '}';
    }
}
