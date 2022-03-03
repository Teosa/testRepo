package Ylab.Game_Lesson2;

public class Game {

    private final Maps maps;
    private final Users users;
    private final WinCheck winCheck;
    private final DrawCheck drawCheck;

    public Game(final Maps maps, final Users users,
                final WinCheck winCheck, final DrawCheck drawCheck) {
        this.maps = maps;
        this.users = users;
        this.winCheck = winCheck;
        this.drawCheck = drawCheck;
    }

    public void play() {
        maps.printMapOnce();
        while (true) {
            System.out.println("UserOne 'X' :");
            users.printUserOneMove(maps);

            maps.refreshMap(maps);
            if (winCheck.userOneWin(maps)) {
                System.out.println("User one 'X' WIN!");
                System.out.println("GAME OVER");
                break;
            }
            if (drawCheck.check(maps)) {
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                break;
            }
            System.out.println("UserTwo '0' :");
            users.printUserTwoMove(maps);

            maps.refreshMap(maps);
            if (winCheck.userTwoWin(maps)) {
                System.out.println("User two '0' WIN!");
                System.out.println("GAME OVER");
                break;
            }
            if (drawCheck.check(maps)) {
                System.out.println("Sorry.. nobody win.. its a DRAW!");
                System.out.println("GAME OVER");
                break;
            }
        }
    }
}
