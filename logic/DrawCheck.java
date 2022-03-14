package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.body.Cell;
import Ylab.Game_Lesson2.body.Maps;

public class DrawCheck {
    public boolean check() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Maps.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
