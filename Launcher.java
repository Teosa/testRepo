package Ylab.Game_Lesson2;

import Ylab.Game_Lesson2.body.Game;
import Ylab.Game_Lesson2.body.Maps;
import Ylab.Game_Lesson2.logic.DrawCheck;
import Ylab.Game_Lesson2.logic.Users;
import Ylab.Game_Lesson2.logic.WinCheck;

public class Launcher {
    public static void main(String[] args) {
        var game = new Game(new Maps(), new Users(), new WinCheck(), new DrawCheck());
        game.play();
    }
}
