package Ylab.Game_Lesson2.body;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {

    void loggingPlayerOne() {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true))) {
            bw.write("Player ONE WIN !!!\n");
        } catch (
                IOException ex) {
            System.out.println("File not found");
        }
    }

    void loggingPlayerTwo() {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true))) {
            bw.write("Player TWO WIN !!!\n");
        } catch (
                IOException ex) {
            System.out.println("File not found");
        }
    }

    void loggingIfDraw() {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt", true))) {
            bw.write("Its DRAW !!!\n");
        } catch (
                IOException ex) {
            System.out.println("File not found");
        }
    }
}
