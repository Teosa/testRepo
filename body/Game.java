package Ylab.Game_Lesson2.body;

import Ylab.Game_Lesson2.logic.*;

import java.util.Scanner;

public class Game {
public static int countFirstPlayerMove = 0;
public static int countSecondPlayerMove = 0;
public static String firstPlayerName;
public static String secondPlayerName;
    private  final Logs logs;
    private final Maps maps;
    private final Users users;
    private final WinCheck winCheck;
    private final DrawCheck drawCheck;
    private final CheckGamersNames checkGamersNames;

    public Game(final Maps maps, final Users users,
                final WinCheck winCheck, final DrawCheck drawCheck,
                final Logs logs, final  CheckGamersNames checkGamersNames) {
        this.maps = maps;
        this.users = users;
        this.winCheck = winCheck;
        this.drawCheck = drawCheck;
        this.logs=logs;
        this.checkGamersNames=checkGamersNames;
    }

    public void play() {
        checkGamersNames.checkNames();
        maps.printMapOnce();

        while (true) {
            System.out.println(firstPlayerName +" 'X' :");
            users.printUserOneMove(maps);

            maps.refreshMap(maps);
            if (winCheck.userOneWin(maps)) {
                logs.loggingPlayerOne();
                System.out.println(firstPlayerName + " 'X' WIN!");
                System.out.println("GAME OVER");
                break;
            }
            if (drawCheck.check(maps)) {
                logs.loggingIfDraw();
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                break;
            }
            System.out.println(secondPlayerName + " '0' :");
            users.printUserTwoMove(maps);

            maps.refreshMap(maps);
            if (winCheck.userTwoWin(maps)) {
                logs.loggingPlayerTwo();
                System.out.println(secondPlayerName + " '0' WIN!");
                System.out.println("GAME OVER");
                break;
            }
            if (drawCheck.check(maps)) {
                logs.loggingIfDraw();
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                break;
            }
        }
    }
}
