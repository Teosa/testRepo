package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.logic.XmlReader.Player;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {

	public void loggingWin(Player player) {
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
			bw.write(player.getName() + " ('" + player.getSymbol() + "') WIN !!!\n");
		} catch (
				IOException ex) {
			System.out.println("File not found");
		}
	}

	public void loggingIfDraw() {
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
			bw.write("Its DRAW !!!\n");
		} catch (
				IOException ex) {
			System.out.println("File not found");
		}
	}

}
