package Ylab.Game_Lesson2.body;

public class Maps {

	private static char[][] gameMap = {
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

		// Это что тут делает? Не относится к полю для игры
//        System.out.println(firstPlayerName +" make move using symbol 'X' \n" + secondPlayerName + " make move using symbol '0'");
//        System.out.println("Let's ROCK!!!");
	}

	public static void refreshMap() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("| "
						+ getSymbol(new Cell(i, j))
						+ " ");
			}
			System.out.println("|");
		}
	}

	public static char setSymbol(Cell cell, final char symbol) {
		return gameMap[cell.getRow()][cell.getCol()] = symbol;
	}

	public static char getSymbol(Cell cell) {
		return gameMap[cell.getRow()][cell.getCol()];
	}

	public static boolean isEmpty(Cell cell) {
		return gameMap[cell.getRow()][cell.getCol()] == '-';
	}

}
