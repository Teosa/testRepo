package Ylab.Game_Lesson2;

public class WinCheck {

    private boolean winCheckByRows(Maps gameMap, final char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameMap.getSymbol(new Cell(i, 0)) == gameMap.getSymbol(new Cell(i, 1)) &&
                    gameMap.getSymbol(new Cell(i, 1)) == gameMap.getSymbol(new Cell(i, 2)) &&
                    gameMap.getSymbol(new Cell(i, 2)) == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean winCheckByCols(Maps gameMap, final char symbol) {
        for (int i = 0; i < 3; i++) {
            if (gameMap.getSymbol(new Cell(0, i)) == gameMap.getSymbol(new Cell(1, i)) &&
                    gameMap.getSymbol(new Cell(1, i)) == gameMap.getSymbol(new Cell(2, i)) &&
                    gameMap.getSymbol(new Cell(2, i)) == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean winCheckByDiagonalOne(Maps gameMap, final char symbol) {
        return gameMap.getSymbol(new Cell(0, 0)) == gameMap.getSymbol(new Cell(1, 1)) &&
                gameMap.getSymbol(new Cell(1, 1)) == gameMap.getSymbol(new Cell(2, 2)) &&
                gameMap.getSymbol(new Cell(2, 2)) == symbol;

    }

    private boolean winCheckByDiagonalTwo(Maps gameMap, final char symbol) {
        return gameMap.getSymbol(new Cell(0, 2)) == gameMap.getSymbol(new Cell(1, 1)) &&
                gameMap.getSymbol(new Cell(1, 1)) == gameMap.getSymbol(new Cell(2, 0)) &&
                gameMap.getSymbol(new Cell(2, 0)) == symbol;
    }

    private boolean winCheck(final Maps gameMap, final char symbol) {
        return winCheckByCols(gameMap, symbol) ||
                winCheckByRows(gameMap, symbol) ||
                winCheckByDiagonalOne(gameMap, symbol) ||
                winCheckByDiagonalTwo(gameMap, symbol);
    }

    public boolean userOneWin(final Maps gameMap) {
        return winCheck(gameMap, 'X');
    }

    public boolean userTwoWin(final Maps gameMap) {
        return winCheck(gameMap, '0');
    }
}
