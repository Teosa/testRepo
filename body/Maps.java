package Ylab.Game_Lesson2.body;

public class Maps {
    char[][] gameMap = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'},
    };

    public void printMapOnce() {
        System.out.println("Ваша игровая карта:");
        System.out.println("| 7 | 8 | 9 |");
        System.out.println("-------------");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("-------------");
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("User ONE make move using symbol 'X' \nUser TWO  make move using symbol '0'");
        System.out.println("Let's ROCK!!!");

    }

    public void refreshMap(Maps gameMap) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + gameMap.getSymbol(new Cell(i, j)) + " ");
            }
            System.out.println("|");
        }
    }

    public char setSymbol(Cell cell, final char symbol) {
        return gameMap[cell.getRow()][cell.getCol()] = symbol;
    }

    public char getSymbol(Cell cell) {
        return gameMap[cell.getRow()][cell.getCol()];
    }

    public boolean isEmpty(Cell cell) {
        return gameMap[cell.getRow()][cell.getCol()] == '-';
    }

}
