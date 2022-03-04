package Ylab.Game_Lesson2.logic;

import java.util.Scanner;
import static Ylab.Game_Lesson2.body.Game.*;

public class CheckGamersNames {

    public void checkNames() {
        while (true) {
            System.out.println("Введите имя первого игрока:");
            firstPlayerName = new Scanner(System.in).nextLine();
            System.out.println("Введите имя второго игрока:");
            secondPlayerName = new Scanner(System.in).nextLine();

            if (firstPlayerName.isBlank() || secondPlayerName.isBlank()) {
                System.out.println("Некорректный ввод данных. Имя должно содержать хотя бы одну букву или цифру.");
            } else break;

        }
    }
}
