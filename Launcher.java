package Ylab.Game_Lesson2;

public class Launcher {
    public static void main(String[] args) {
        var game = new Game(new Maps(), new Users(), new WinCheck(), new DrawCheck());
        game.play();
    }
}
