package Ylab.Game_Lesson2.body;

import Ylab.Game_Lesson2.LauncherNew;
import Ylab.Game_Lesson2.logic.CheckGamersNames;
import Ylab.Game_Lesson2.logic.DrawCheck;
import Ylab.Game_Lesson2.logic.Logs;
import Ylab.Game_Lesson2.logic.ParsingXml;
import Ylab.Game_Lesson2.logic.Users;
import Ylab.Game_Lesson2.logic.WinCheck;
import Ylab.Game_Lesson2.logic.XmlReader.Move;
import Ylab.Game_Lesson2.logic.XmlReader.Player;
import Ylab.Game_Lesson2.logic.XmlReader.Root;
import java.io.FileNotFoundException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Game {

	public static boolean isWin1 = false;

	public static boolean isWin2 = false;

	public static boolean isDraw = false;
	// Это данные игрока, будем хранить их там. Тут та же проблема что и в Users, если игроков будет
	// больше, создавать на каждого переменную - не рационально. Я понимаю что применительно к крестикам-ноликам
	// это невозможно, но тебе нужно понять подход при построении моделей данных
//    public static int countFirstPlayerMove = 0;
//    public static int countSecondPlayerMove = 0;
//    public static String firstPlayerName;
//    public static String secondPlayerName;

	// Собственно сами игроки
	// Статика тоже не очень хорошая прктика. У тебя есть пареметры в функциях, передавай туда того с кем работаешь
	// Твое дублирование кода возникает именно по этой причине, так как ты пишешь логику для статичной переменной playerOne,
	// а потом все то же самое для playerTwo
	public Player playerOne;

	public Player playerTwo;

	private final Logs logs;

	// Поле есть смысл сделать статичным, оно у тебя одно на всю игру и не должно меняться
	private final static Maps maps = new Maps();

	private final Users users;

	private final WinCheck winCheck;

	private final DrawCheck drawCheck;

	// Не нужно. Методы этого класса сделаны статичными, теперь для использования не нужна переменная
	// private final CheckGamersNames checkGamersNames;
	private final ParsingXml parsingXml;

	private final boolean isFromFile;

	public Game(final Users users,
			final WinCheck winCheck, final DrawCheck drawCheck,
			final Logs logs, final ParsingXml parsingXml, boolean isFromFile) {
		this.users = users;
		this.winCheck = winCheck;
		this.drawCheck = drawCheck;
		this.logs = logs;
		this.parsingXml = parsingXml;
		this.playerOne = new Player();
		this.playerTwo = new Player();
		this.isFromFile = isFromFile;
	}

	public void play()
			throws FileNotFoundException, ParserConfigurationException, TransformerException {
		if (!isFromFile) {
			// Для игры получаем имена из консоли
			playerOne.setName(CheckGamersNames.getPlayersName("Введите имя первого игрока:"));
			playerOne.setId("1");
			playerOne.setSymbol("X");

			playerTwo.setName(CheckGamersNames.getPlayersName("Введите имя второго игрока:"));
			playerTwo.setId("2");
			playerTwo.setSymbol("O");
		} else {
			// При чтении из файла у нас уже есть нужные обьекты, просто кладем в наши переменные
			playerOne = Root.players.get(0);
			playerTwo = Root.players.get(1);
		}

		maps.printMapOnce();

		System.out.println(playerOne.getName() + " make move using symbol '" + playerOne.getSymbol() + "'");
		System.out.println(playerTwo.getName() + " make move using symbol '" + playerTwo.getSymbol() + "'");
		System.out.println("Let's ROCK!!!");

		// Флаг окончания игры
		boolean gameEnded = false;

		while (!gameEnded) {
			gameEnded = makePlayerMove(playerOne);

			if (!gameEnded) {
				gameEnded = makePlayerMove(playerTwo);
			}
		}

		// Делаем xml-ку только если это настоящая игра
		if(!isFromFile) {
			parsingXml.parse(playerOne, playerTwo);
		}

		// Снова дублирование кода. Схлопываем в один метод
/*        while (true) {
            System.out.println(firstPlayerName + " 'X' :");
            // Почему ты тут true передал? У тебя всегда будет работать ветка чтения из файла
            // users.printUserOneMove(maps, true);
            users.printUserOneMove(maps, isFromFile);

            LauncherNew.gamePlay.moves.add(new Move(1, userOneMoveInt, num++));
            maps.refreshMap(maps);
            if (winCheck.userOneWin(maps)) {
                logs.loggingPlayerOne();
                System.out.println(firstPlayerName + " 'X' WIN!");
                isWin1 = true;
                System.out.println("GAME OVER");
                break;
            }
            if (drawCheck.check(maps)) {
                logs.loggingIfDraw();
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                isDraw = true;
                break;
            }
            System.out.println(secondPlayerName + " '0' :");

            // Почему ты тут true передал? У тебя всегда будет работать ветка чтения из файла
            // users.printUserTwoMove(maps, true);
            users.printUserTwoMove(maps, isFromFile);

            LauncherNew.gamePlay.moves.add(new Move(2, userTwoMoveInt, num2++));
            maps.refreshMap(maps);
            if (winCheck.userTwoWin(maps)) {
                logs.loggingPlayerTwo();
                System.out.println(secondPlayerName + " '0' WIN!");
                System.out.println("GAME OVER");
                isWin2 = true;
                break;
            }
            if (drawCheck.check(maps)) {
                logs.loggingIfDraw();
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                isDraw = true;
                break;
            }
        }*/
	}

	private boolean makePlayerMove(Player player) {
		System.out.println(player.getName() + " '" + player.getSymbol() + "' :");

		// Почему ты тут isFromFile = true передал? У тебя всегда будет работать ветка чтения из файла
		// users.printUserOneMove(maps, true);

		Cell movedCell = users.printUserMove(player, isFromFile);

		LauncherNew.gamePlay.moves.add(new Move(
				Integer.parseInt(player.getId()),
				movedCell.getCellNumber(),
				player.getMoveCounter()
		));

		Maps.refreshMap();

		if (winCheck.uisUerWin(player.getSymbol())) {
			player.setWinner(true);
			logs.loggingWin(player);
			System.out.println(player.getName() + " '" + player.getSymbol() + "' WIN!");
			System.out.println("GAME OVER");
			return true;
		} else if (drawCheck.check()) {
			logs.loggingIfDraw();
			System.out.println("Sorry.. nobody win.. its a DRAW!");
			System.out.println("GAME OVER");
			return true;
		}

		// Пока никто не выйграл и нет ничьи, возвращаем false чтобы игра продолжалась
		return false;
	}

}
