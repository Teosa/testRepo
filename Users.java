package Ylab.Game_Lesson2;


import java.util.Scanner;

public class Users {

    char[][] tempMap = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'},
    };

    public Cell usersMove() {
        while (true) {
            final String userOneMove = new Scanner(System.in).nextLine();
            if (userOneMove.length() == 1) {
                char userOneChar = userOneMove.charAt(0);
                if (userOneChar >= '1' && userOneChar <= '9') {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (tempMap[i][j] == userOneChar) {
                                return new Cell(i, j);
                            }
                        }
                    }
                }
            } else System.out.println("Incorrect data, please try again!");
        }
    }

    public void printUserOneMove(final Maps gameMap) {
        while (true) {
            final Cell cell = usersMove();
            if (gameMap.isEmpty(cell)) {
                gameMap.setSymbol(cell, 'X');
                return;
            } else System.out.println("This cell is not EMPTY, try again!");
        }
    }

    public void printUserTwoMove(final Maps gameMap) {
        while (true) {
            final Cell cell = usersMove();
            if (gameMap.isEmpty(cell)) {
                gameMap.setSymbol(cell, '0');
                return;
            } else System.out.println("This cell is not EMPTY, try again!");
        }
    }
}
