package Ylab.Game_Lesson2.body;

public final class Cell {
    private final int row;
    private final int col;
    // Удобно хранить это тут, так как
    private int cellNumber;

    public Cell(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    // Тут не нужны модификаторы final. Они вообще редко используются для входящих параметров, такое принято в C++
    // Не ставь без необходимости
    public Cell(int row, int col, int cellNumber) {
        this.row = row;
        this.col = col;
        this.cellNumber = cellNumber;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getCellNumber() {return cellNumber;}

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }
}
