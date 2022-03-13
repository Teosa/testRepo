package Ylab.Game_Lesson2.body;

import Ylab.Game_Lesson2.Launcher;
import Ylab.Game_Lesson2.logic.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import static Ylab.Game_Lesson2.logic.Users.userOneMoveInt;
import static Ylab.Game_Lesson2.logic.Users.userTwoMoveInt;

public class Game {
    public static  boolean isWin1 = false;
    public static  boolean isWin2 = false;
    public static boolean isDraw = false;
    public static int countFirstPlayerMove = 0;
    public static int countSecondPlayerMove = 0;
    public static String firstPlayerName;
    public static String secondPlayerName;
    private final Logs logs;
    private final Maps maps;
    private final Users users;
    private final WinCheck winCheck;
    private final DrawCheck drawCheck;
    private final CheckGamersNames checkGamersNames;
private final ParsingXml parsingXml;

    public Game(final Maps maps, final Users users,
                final WinCheck winCheck, final DrawCheck drawCheck,
                final Logs logs, final CheckGamersNames checkGamersNames, final ParsingXml parsingXml) {
        this.maps = maps;
        this.users = users;
        this.winCheck = winCheck;
        this.drawCheck = drawCheck;
        this.logs = logs;
        this.checkGamersNames = checkGamersNames;
        this.parsingXml  = parsingXml;
    }

    public void play() throws FileNotFoundException, ParserConfigurationException, TransformerException {
        checkGamersNames.checkNames();
        maps.printMapOnce();
        int num = 1;
        int num2 = 1;
        while (true) {
            System.out.println(firstPlayerName + " 'X' :");
            users.printUserOneMove(maps);
            Launcher.gamePlay.moves.add(new Move(1, userOneMoveInt, num++));
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
            users.printUserTwoMove(maps);
            Launcher.gamePlay.moves.add(new Move(2, userTwoMoveInt, num2++));
            maps.refreshMap(maps);
            if (winCheck.userTwoWin(maps)) {
                logs.loggingPlayerTwo();
                System.out.println(secondPlayerName + " '0' WIN!");
                System.out.println("GAME OVER");
                isWin2=true;
                break;
            }
            if (drawCheck.check(maps)) {
                logs.loggingIfDraw();
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                isDraw = true;
                break;
            }
        }
parsingXml.parse();
    }
}
