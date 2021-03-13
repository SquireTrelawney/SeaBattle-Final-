import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	int state, size;
	Cell(int state, int cellSize){
		setState(state);
		size = cellSize;
	}
	public void setState(int state) {
		if(state >= -2 && state <= 2) {
			this.state = state;
		}
	}
	public int getState() {
		return state;
	}
	public void paintCell(int leftIndent, int downIndent, int x, int y, Graphics g) {
		switch (state) {
		case 2:
			g.setColor(Color.RED);
			g.fillRect(leftIndent +  x * size, downIndent + y * size, size, size);
			break;

		case -2:
			g.setColor(Color.BLACK);
			g.fillOval(leftIndent +  x * size, downIndent + y * size, size, size);
			break;
		}
	}
}
