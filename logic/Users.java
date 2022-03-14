package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.body.Cell;
import Ylab.Game_Lesson2.body.Maps;
import Ylab.Game_Lesson2.logic.XmlReader.Move;
import Ylab.Game_Lesson2.logic.XmlReader.Player;
import Ylab.Game_Lesson2.logic.XmlReader.Root;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Users {
	// Хранить в таком виде переменные - плохая идея. Если игроков будет 5? 10? 200? На каждого переменную не сделаешь
	// Номер ячейки переехал в класс Cell
//    public static int userOneMoveInt;
//    public static int userTwoMoveInt;

	char[][] tempMap = {
			{'7', '8', '9'},
			{'4', '5', '6'},
			{'1', '2', '3'},
	};

	public Cell makeMove() {
		// Снова водим счетчик попыток, чтобы не уйти в бесконечный цикл
		int tries = 0;
		// Переменную для ввода обьявляем вне цикла, чтобы ее могли использовать методы за пределами while
		String userMove = "";
		int userMoveInt;

		while (true) {
			// Если было слишком много неправильных попыток ввода, выбрасываем исключение
			// Если выше ты его не перехватишь, то программа прервется (в данном случае нам так и нужно)
			if (tries > 3) {
				throw new RuntimeException("Исчерпан лимит попыток ввода координат.");
			}

			userMove = new Scanner(System.in).nextLine();

			// Проверяем что строка не null, не пуста и имеет длинну 1 символ
			if (isNotBlank(userMove) && userMove.trim().length() == 1) {
				try {
					// Пытаемся превратить ввод в инт. Если нам ввели не цифру, метод parseInt() выбросит исключение,
					// его и ловим в блоке catch, чтобы наша программа не упала
					userMoveInt = Integer.parseInt(userMove);

					// Стоит проверить тут что нам ввели число в правильном диапазоне
					if (userMoveInt <= 0 || userMoveInt > 9) {
						System.out.println("Ошибка. Введенное число должно быть в диапазоне между 1 и 9 включительно.");
					}

					// И последняя проверка, что выбранная ячейка свободна
					Cell cell = convert(userMoveInt);
					if (!Maps.isEmpty(cell)) {
						System.out.println("Ошибка. Ячейка уже занята.");
						tries++;
					}

					return cell;
				} catch (NumberFormatException nfe) {
					// Выводим ошибку и увеличиваем счетчик попыток
					System.out.println("Ошибка. Введенный символ должен быть числом.");
					tries++;
				}
			} else {
				// Если наша введенная строка не прошла проверку, выводим ошибку и увеличиваем счетчик попыток
				System.out.println("Incorrect data, please try again!");
				tries++;
			}
		}
	}

	public Cell convert(int cellNumber) {
		if (cellNumber >= 1 && cellNumber <= 9) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (tempMap[i][j] == (Integer.toString(cellNumber)).charAt(0)) {
						// Тут добавляем в Cell номер ячейки, он нам пригодится
						return new Cell(i, j, cellNumber);
					}
				}
			}
		}
		return null;
	}

	public Cell printUserMove(Player player, boolean isFromFile) {
		// Зачем у тебя тут был while совсем не ясно
		final Cell cell;

		// Увеличиваем счетчик ходов
		player.increaseMoveCount();

		if (!isFromFile) {
			cell = makeMove();
		} else {
			// Так как метод теперь универсальный, мы не можем вычислить индекс записи, так как не знаем какой игрок у нас
			// сейчас. Поэтому мы будем искать нужную по полю id (так как оно есть и у нашего игрока и в записи Move) и по
			// номеру хода, так как он оже есть и там и там
			Move playersMove = Root.getMoveByIdAndName(Integer.parseInt(player.getId()), player.getMoveCounter());
			cell = convert(playersMove.getCoordinate());
		}

		Maps.setSymbol(cell, player.getSymbol().charAt(0));

		// Логирование выносим отдельным методом
		logMove(player, cell);

		return cell;
	}

	private void logMove(Player player, Cell cell) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
			bw.write(player.getName()
					+ " ('" + player.getSymbol() + "') make "
					+ player.getMoveCounter()
					+ " move to " + cell.getRow() + "-" + cell.getCol() + "\n");
		} catch (IOException ex) {
			System.out.println("File not found");
		}
	}

	private boolean isNotBlank(String name) {
		return name != null && name.trim().length() > 0;
	}

	// Очень много дублирования. Все можно свернуть в универсальные методы
	//*********************************************************************
/*	public Cell userOneMove() {
		while (true) {
			final String userOneMove = new Scanner(System.in).nextLine();
			if (userOneMove.length() == 1) {
				userOneMoveInt = Integer.parseInt(userOneMove);
				// char userOneChar = userOneMove.charAt(0);
				return convert(userOneMoveInt);
			} else {
				System.out.println("Incorrect data, please try again!");
			}
		}
	}

	public Cell userTwoMove() {
		while (true) {
			final String userTwoMove = new Scanner(System.in).nextLine();
			if (userTwoMove.length() == 1) {
				userTwoMoveInt = Integer.parseInt(userTwoMove);
				//    char userTwoChar = userTwoMove.charAt(0);
				return convert(userTwoMoveInt);
			} else {
				System.out.println("Incorrect data, please try again!");
			}
		}
	}*/




/*	public void printUserTwoMove(final Maps gameMap, boolean isFromFile) {
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
			} else {
				System.out.println("This cell is not EMPTY, try again!");
			}
		}
	}*/

}
