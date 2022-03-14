package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.LauncherNew;
import Ylab.Game_Lesson2.body.Cell;
import Ylab.Game_Lesson2.body.Maps;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static Ylab.Game_Lesson2.body.Game.*;

public class Users {
    public static int userOneMoveInt;
    public static int userTwoMoveInt;

    char[][] tempMap = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'},
    };

    public Cell userOneMove() {
        while (true) {
            final String userOneMove = new Scanner(System.in).nextLine();
            if (userOneMove.length() == 1) {
                userOneMoveInt = Integer.parseInt(userOneMove);
               // char userOneChar = userOneMove.charAt(0);
                return convert(userOneMoveInt);
            } else System.out.println("Incorrect data, please try again!");
        }
    }
    public Cell convert(int cellNumber) {
        if (cellNumber >= 1 && cellNumber <= 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tempMap[i][j] == (Integer.toString(cellNumber)).charAt(0)) {
                        return new Cell(i, j);
                    }
                }
            }
        }
        return null;
    }

    public Cell userTwoMove() {
        while (true) {
            final String userTwoMove = new Scanner(System.in).nextLine();
            if (userTwoMove.length() == 1) {
                userTwoMoveInt = Integer.parseInt(userTwoMove);
            //    char userTwoChar = userTwoMove.charAt(0);
                return convert(userTwoMoveInt);
            } else System.out.println("Incorrect data, please try again!");
        }
    }


    public void printUserOneMove(final Maps gameMap, boolean isFromFile) {
        countFirstPlayerMove++;
        while (true) {
            final Cell cell;
            if (!isFromFile) {
                cell = userOneMove();
            } else {
          //   int cellNumber = LauncherNew.root.getMoves().get(countFirstPlayerMove - 1).getCoordinate();
                int cellNumber = LauncherNew.root.getMoves().get(countFirstPlayerMove).getCoordinate();
               // int cellNumber = userOneMoveInt;
                 cell = convert(cellNumber);
            }
                if (gameMap.isEmpty(cell)) {
                    gameMap.setSymbol(cell, 'X');
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
                        bw.write(firstPlayerName + " ('X') make " + countFirstPlayerMove
                                + " move to " + cell.getRow() + "-" + cell.getCol() + "\n");
                    } catch (IOException ex) {
                        System.out.println("File not found");
                    }
                    return;
                } else System.out.println("This cell is not EMPTY, try again!");
            }
        }

        public void printUserTwoMove ( final Maps gameMap, boolean isFromFile){
            countSecondPlayerMove++;
            while (true) {
                Cell cell;
                if (!isFromFile) {
                     cell = userTwoMove();
                } else {
                    int cellNumber = LauncherNew.root.getMoves().get(countSecondPlayerMove).getCoordinate();
                 //   int cellNumber = LauncherNew.root.getMoves().get(countSecondPlayerMove).getCoordinate();
                 //   int cellNumber = userTwoMoveInt;
                     cell = convert(cellNumber);
                }
                    if (gameMap.isEmpty(cell)) {
                        gameMap.setSymbol(cell, '0');
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
                            bw.write(secondPlayerName + " ('0') make " + countSecondPlayerMove
                                    + " move to " + cell.getRow() + "-" + cell.getCol() + "\n");
                        } catch (IOException ex) {
                            System.out.println("File not found");
                        }
                        return;
                    } else System.out.println("This cell is not EMPTY, try again!");
            }
        }
    }
