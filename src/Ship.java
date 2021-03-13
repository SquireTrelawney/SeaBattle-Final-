import java.util.Random;

public class Ship {
	int size, x, y, speedX, speedY, fieldSize;
	String direction;
	Random rn;
	Ship(int size, Cell[][] cells, int fieldSize){
		this.size = size;
		rn = new Random();
		boolean canSetShip = false;
		this.fieldSize = fieldSize;
		while(!canSetShip) {
			x = rn.nextInt(fieldSize);
			y = rn.nextInt(fieldSize);
			direction = chooseDirection();
			canSetShip = true;
			for(int i = 0; i < size; i++) {
				if(!canSurroundWithBombs(x, y, cells) || isOutOfBounds(x, y) || cells[y][x].state != 0) {
					canSetShip = false;
				}
				x += speedX;
				y += speedY;
			}
		}
		for(int i = 0; i < size ; i++) {
			x -= speedX;
			y -= speedY;
			surroundWithBombs(x, y, cells);
			cells[y][x].setState(2);
			 
		}
		surroundWithBombs(x, y, cells);
	}
	public String chooseDirection() {
		switch (rn.nextInt(4)) {
		case 0:
			speedX = -1;
			speedY = 0;
			return "left";
		case 1:
			speedY = -1;
			speedX = 0;
			return "up";
		case 3:
			speedX = 1;
			speedY = 0;
			return "right";
		default:
			speedY = 1;
			speedX = 0;
			return "down";
		}
	}
	public boolean isOutOfBounds(int x, int y) {
		if(x < 0 || x >= fieldSize || y < 0 || y >= fieldSize) {
			return true;
		}else {
			return false;
		}
	}
	public boolean canSetBomb(int x, int y, Cell[][] cells) {
		if(!isOutOfBounds(x, y) && cells[y][x].state != 2) {
			return true;
		}else {
			return false;
		}
	}
	public boolean canSurroundWithBombs(int x, int y, Cell[][] cells) {
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(speedX != j && speedY != i ) {
					if (!canSetBomb(x + j, y + i, cells)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void setBomb(int x, int y, Cell[][] cells) {
		if(canSetBomb(x, y, cells)) {
			cells[y][x].setState(-1);
		}
	}
	
	public void surroundWithBombs(int x, int y, Cell[][] cells) {
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				setBomb(x + j, y + i, cells);
			}
		}
		
	}
	
}
