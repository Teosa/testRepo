package Ylab.Game_Lesson2.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {

    public void loggingPlayerOne() {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
            bw.write("Player ONE('X') WIN !!!\n");
        } catch (
                IOException ex) {
            System.out.println("File not found");
        }
    }

    public void loggingPlayerTwo() {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("GameLogs.txt", true))) {
            bw.write("Player TWO('0') WIN !!!\n");
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
