package Ylab.Game_Lesson2;

import Ylab.Game_Lesson2.body.Game;
import Ylab.Game_Lesson2.logic.*;
import Ylab.Game_Lesson2.body.Maps;

public class Launcher {
    public static GamePlay gamePlay;

    public static void main(String[] args) throws Exception {

        gamePlay = new GamePlay();

        Game game = new Game(new Maps(), new Users(),
                             new WinCheck(), new DrawCheck(),
                             new Logs(), new CheckGamersNames(), new ParsingXml());
        game.play();
    }
}
