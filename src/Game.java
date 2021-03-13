
public class Game {
	Field PlayerField, ComputerField;
	int cellSize, fieldSize, computerLeftIndent, computerDownIndent, playerLeftIndent, playerDownIndent, maxDeskAmount;
	
	Game(int width, int height){
		maxDeskAmount = 20;
		fieldSize = 100;
		cellSize = 50;
		while(cellSize * fieldSize * 2 > width - 60 || cellSize * fieldSize > height - 100) {
			cellSize--;
		}
		computerDownIndent = playerDownIndent = (height - cellSize * fieldSize) / 2;
		int fieldsIndent = computerLeftIndent = (width - cellSize * fieldSize * 2) / 3;
		playerLeftIndent = computerLeftIndent + cellSize * fieldSize + fieldsIndent;
		ComputerField = new Field(fieldSize, cellSize, computerLeftIndent, computerDownIndent, maxDeskAmount, true);
		PlayerField = new Field(fieldSize, cellSize, playerLeftIndent, playerDownIndent, maxDeskAmount, false);
	}
	
}
