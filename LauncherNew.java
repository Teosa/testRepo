package Ylab.Game_Lesson2;

import Ylab.Game_Lesson2.body.Game;
import Ylab.Game_Lesson2.logic.DrawCheck;
import Ylab.Game_Lesson2.logic.GamePlay;
import Ylab.Game_Lesson2.logic.Logs;
import Ylab.Game_Lesson2.logic.ParsingXml;
import Ylab.Game_Lesson2.logic.Users;
import Ylab.Game_Lesson2.logic.WinCheck;
import Ylab.Game_Lesson2.logic.XmlReader.Root;

public class LauncherNew {

	public static GamePlay gamePlay;

	public static void main(String[] args) throws Exception {

		gamePlay = new GamePlay();

		if (args.length == 0) {
			new Game(
					new Users(),
					new WinCheck(),
					new DrawCheck(),
					new Logs(),
					new ParsingXml(),
					false
			).play();
		} else {
			String filename = args[0];
			Root.read(filename);
			new Game(
					new Users(),
					new WinCheck(),
					new DrawCheck(),
					new Logs(),
					new ParsingXml(),
					true
			).play();
		}

	}

}
