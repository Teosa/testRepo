package Ylab.Game_Lesson2;

public class DrawCheck {
    public boolean check(Maps gameMap) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameMap.isEmpty(new Cell(i, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
