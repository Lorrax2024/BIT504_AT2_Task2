import java.awt.*;

public class Board {
	
	// grid line width
	public static final int GRID_WIDTH = 8;
	// grid line half width
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;
	
	//2D array of ROWS-by-COLS Cell instances
	Cell [][] cells;
	
	/** Constructor to create the game board */
	public Board() {
		
		// Initialise the cell arrays using rows and cols
		this.cells = new Cell[GameMain.ROWS][GameMain.COLS];
		
		for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	

	 /** Return true if it is a draw (i.e., no more EMPTY cells) */ 
	public boolean isDraw() {
		
		//check each cell in the board
		for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				//if any cell is empty it's not a draw
				if (cells[row][col].content == Player.Empty) {
					return false;
				}
			}
		}	 
		   
		// if all cells are filled and no winner, return true to indicate draw
		return true;

		
	}
	
	/** Return true if the current player "thePlayer" has won after making their move  */
	public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
		
	 // check if player has 3-in-that-row
		//check row
		if(cells[playerRow][0].content == thePlayer && cells[playerRow][1].content == thePlayer && cells[playerRow][2].content == thePlayer )
			return true; 
		
		//Check if player has 3-in-that-row
		if (cells[playerCol][0].content == thePlayer && cells[playerCol][1].content == thePlayer && cells[playerCol][2].content == thePlayer )
			return true;
		
		
		
		 // 3-in-the-diagonal
		// check if the payer won by having 3 in a diagonal --- top-left to bottom-right
		if( cells[0][0].content == thePlayer && cells[1][1].content == thePlayer && cells[2][2].content == thePlayer)
			return true;
		// check if the payer won by having 3 in a diagonal --- top-right to bottom-left
		if ( cells[0][2].content == thePlayer && cells[1][1].content == thePlayer && cells[2][0].content == thePlayer)
			return true;
		// check if the player won by having 3 in a diagonal --- top-left to bottom-left 
		if (cells[0][0].content == thePlayer && cells[1][0].content == thePlayer && cells[2][0].content == thePlayer)
		    return true;
		// check if the player won by having 3 in a diagonal --- top-right to bottom-right
		if (cells[0][2].content == thePlayer && cells[1][2].content == thePlayer && cells[2][2].content == thePlayer)
		    return true;
		// check if the player won by having 3 in a diagonal --- middle left to middle right
		if (cells[0][1].content == thePlayer && cells[1][1].content == thePlayer && cells[2][1].content == thePlayer)
		    return true;

		//no winner, keep playing
		return false;
	}
	
	/**
	 * Draws the grid (rows then columns) using constant sizes, then call on the
	 * Cells to paint themselves into the grid
	 */
	public void paint(Graphics g) {
		//draw the grid
		g.setColor(Color.gray);
		for (int row = 1; row < GameMain.ROWS; ++row) {          
			g.fillRoundRect(0, GameMain.CELL_SIZE * row - GRID_WIDHT_HALF,                
					GameMain.CANVAS_WIDTH - 1, GRID_WIDTH,                
					GRID_WIDTH, GRID_WIDTH);       
			}
		for (int col = 1; col < GameMain.COLS; ++col) {          
			g.fillRoundRect(GameMain.CELL_SIZE * col - GRID_WIDHT_HALF, 0,                
					GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,                
					GRID_WIDTH, GRID_WIDTH);
		}
		
		//Draw the cells
		for (int row = 0; row < GameMain.ROWS; ++row) {          
			for (int col = 0; col < GameMain.COLS; ++col) {  
				cells[row][col].paint(g);
			}
		}
	}
	

}
