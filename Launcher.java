package Ylab.Game_Lesson2;

import Ylab.Game_Lesson2.body.Game;
import Ylab.Game_Lesson2.logic.*;
import Ylab.Game_Lesson2.body.Maps;

public class Launcher {
    public static void main(String[] args) {
        var game = new Game(new Maps(), new Users(),
                new WinCheck(), new DrawCheck(),
                new Logs(), new CheckGamersNames());
        game.play();
    }
}
