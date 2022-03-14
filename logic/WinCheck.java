package Ylab.Game_Lesson2.logic;

import Ylab.Game_Lesson2.body.Cell;
import Ylab.Game_Lesson2.body.Maps;

public class WinCheck {

	private boolean winCheckByRows(final char symbol) {
		for (int i = 0; i < 3; i++) {
			if (Maps.getSymbol(new Cell(i, 0)) == Maps.getSymbol(new Cell(i, 1)) &&
					Maps.getSymbol(new Cell(i, 1)) == Maps.getSymbol(new Cell(i, 2)) &&
					Maps.getSymbol(new Cell(i, 2)) == symbol) {
				return true;
			}
		}
		return false;
	}

	private boolean winCheckByCols(final char symbol) {
		for (int i = 0; i < 3; i++) {
			if (Maps.getSymbol(new Cell(0, i)) == Maps.getSymbol(new Cell(1, i)) &&
					Maps.getSymbol(new Cell(1, i)) == Maps.getSymbol(new Cell(2, i)) &&
					Maps.getSymbol(new Cell(2, i)) == symbol) {
				return true;
			}
		}
		return false;
	}

	private boolean winCheckByDiagonalOne(final char symbol) {
		return Maps.getSymbol(new Cell(0, 0)) == Maps.getSymbol(new Cell(1, 1)) &&
				Maps.getSymbol(new Cell(1, 1)) == Maps.getSymbol(new Cell(2, 2)) &&
				Maps.getSymbol(new Cell(2, 2)) == symbol;

	}

	private boolean winCheckByDiagonalTwo(final char symbol) {
		return Maps.getSymbol(new Cell(0, 2)) == Maps.getSymbol(new Cell(1, 1)) &&
				Maps.getSymbol(new Cell(1, 1)) == Maps.getSymbol(new Cell(2, 0)) &&
				Maps.getSymbol(new Cell(2, 0)) == symbol;
	}

	private boolean winCheck(final char symbol) {
		return winCheckByCols(symbol) ||
				winCheckByRows(symbol) ||
				winCheckByDiagonalOne(symbol) ||
				winCheckByDiagonalTwo(symbol);
	}

	// Методам возвращающим boolean равильнее давать имя начинающееся с is. Так как буль - это да или нет,
	// то имя твоего метода звучит как вопрос когда начинается с is
	public boolean uisUerWin(String symbol) {
		return winCheck(symbol.charAt(0));
	}

	//    public boolean userOneWin(final Maps gameMap) {
//        return winCheck(gameMap, 'X');
//    }
//
//    public boolean userTwoWin(final Maps gameMap) {
//        return winCheck(gameMap, '0');
//    }

}
