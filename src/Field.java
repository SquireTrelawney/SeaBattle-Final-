import java.awt.Color;
import java.awt.Graphics;

public class Field {
	Cell[][] cells;
	int fieldSize, leftIndent, topIndent, cellSize;
	boolean isComputerField;
	Ship[] ships;
	Field(int fieldSize, int cellSize, int leftIndent, int downIndent, int deskAmount, boolean isComputerField) {
		this.fieldSize = fieldSize;
		this.cellSize = cellSize;
		this.leftIndent = leftIndent;
		this.topIndent = downIndent;
		cells = new Cell[fieldSize][fieldSize];
		this.isComputerField = isComputerField;
		
		int shipsAmout = (1 + deskAmount) *  deskAmount / 2;
		ships = new Ship[shipsAmout];
		
		for (int i = 0; i < this.fieldSize; i++) {
			for (int j = 0; j < this.fieldSize; j++) {
				cells[i][j] = new Cell(0, cellSize);
			}
		}
		setShips(deskAmount);
	}

	public void paintField(Graphics g) {
		if (!isComputerField) {
			for (int i = 0; i < fieldSize; i++) {
				for (int j = 0; j < fieldSize; j++) {
					cells[i][j].paintCell(leftIndent, topIndent, i, j, g);
				}
			}
		}
		for (int i = 0; i < fieldSize + 1; i++) {
			g.setColor(Color.BLACK);
			g.drawLine(leftIndent, topIndent + i * cellSize, leftIndent + cellSize * fieldSize,
					topIndent + i * cellSize);
			g.drawLine(leftIndent + i * cellSize, topIndent, leftIndent + i * cellSize,
					topIndent + cellSize * fieldSize);
		}
	}

	public void setShips(int deskAmount) {
		int k = 0;
		for (int i = deskAmount; i >= 1; i--) {
			for (int j = deskAmount; j >= i; j--) {
				ships[k] = new Ship(i, cells, fieldSize);
				k++;
			}
		}
	}
}
