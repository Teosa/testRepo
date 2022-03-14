package Ylab.Game_Lesson2.logic;

import java.util.Scanner;

public class CheckGamersNames {

	public void checkNames() {
		// Плохой вариант взаимодействия с пользователем, в случае ошибки во втором имени ты заставляешь
		// заново вводить первое и к тому же не уточняешь где именно произошла ошибка
/*            System.out.println("Введите имя первого игрока:");
            firstPlayerName = new Scanner(System.in).nextLine();
            System.out.println("Введите имя второго игрока:");
            secondPlayerName = new Scanner(System.in).nextLine();

            if (firstPlayerName.isBlank() || secondPlayerName.isBlank()) {
                System.out.println("Некорректный ввод данных. Имя должно содержать хотя бы одну букву или цифру.");
                tries++;
            } */

		// Для обоих игроков ты делаешь одно и то же. Дублировать код - плохая практика, его сложнее читать и поддерживать
		// Получение имени игрока вынесла в отдельный метод
		//*****
		// Это тоже теперь не нужно
//		firstPlayerName = getPlayersNames("Введите имя первого игрока:");
//		secondPlayerName = getPlayersNames("Введите имя второго игрока:");
	}

	// Метод статичный, чтобы можно было дернуть откуда угодно
	public static String getPlayersName(String messageText) {
		// while очень опасная штука в плане ошибок. Чтобы эта фигня не зациклилась в бесконечность
		// добавила счетчик попыток
		int tries = 0;

		while (true) {
			System.out.println(messageText);
			String nameVariable = new Scanner(System.in).nextLine();

			if (tries > 3) {
				// Если попытки исчерпаны, выбрасываем исключение, нам нужно чтобы программа завершилась, а не ушла в бесконечный цикл
				throw new RuntimeException("Ошибка. Лимит попыток исчерпан.");
			} else if (!checkName(nameVariable)) {
				// Если ввели что-то не то, выводим сообщение и увеличиваем счетчик попыток
				System.out.println("Некорректный ввод данных. Имя должно содержать хотя бы одну букву или цифру.");
				tries++;
			} else {
				// Если все хорошо, то выходим из while
				return nameVariable;
			}
		}
	}

	// У меня нет .isBlank(), это альтернатива
	private static boolean checkName(String name) {
		return name != null && name.trim().length() > 0;
	}

}
