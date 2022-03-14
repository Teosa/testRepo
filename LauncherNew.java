package Ylab.Game_Lesson2;

import Ylab.Game_Lesson2.body.Game;
import Ylab.Game_Lesson2.logic.*;
import Ylab.Game_Lesson2.body.Maps;
import Ylab.Game_Lesson2.logic.XmlReader.Root;

public class LauncherNew {
    public static GamePlay gamePlay;
    public static Root root;

    public static void main(String[] args) throws Exception {

        gamePlay = new GamePlay();
        root = new Root();

        Game game = new Game(new Maps(), new Users(),
                             new WinCheck(), new DrawCheck(),
                             new Logs(), new CheckGamersNames(), new ParsingXml());

        if(args.length==0) {
            game.play(false);
        }else {
            String filename = args [0];
            root.read(filename);
            game.play(true);
        }

    }
}
