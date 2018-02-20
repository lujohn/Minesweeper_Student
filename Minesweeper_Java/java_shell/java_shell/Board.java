package java_shell;
import java.util.Random;

/*	Author: John Lu
 * 	Description: TO DO
 */

public class Board {
	// *** Change to private
	public int nRows;
	public int nCols;
	public int[][] board;  // change to Tiles

    // ---------------------------- Constructors -----------------------------
	// Description: Default constructor creates a random 10x10 board with 25 bombs
	public Board() {
		this(10, 10, 25);
	}
	
	/* Description:	This constructor takes the dimensions, n and m, of the board as input and
	 * 				a 2-d grid of of dimension n x m indicating bomb locations. grid[i][j] is
	 * 				0 iff location (i,j) has no bomb and is 1 iff location (i,j) has a bomb.
	 * 
	 * Inputs:		nRows: the number of rows, n
	 * 				nCols: the number of columns, m
	 * 				grid: a 2-d array of size n x m
	 */
	public Board(int nRows, int nCols, int[][] grid) {
		this.nRows = nRows;
		this.nCols = nCols;
		this.board = grid;
	}
	
	/* Description:	This constructor takes the integer dimensions, n and m, of the board as input and
	 * 				a third integer indicating the number of bombs for the board. A board of size
	 * 				n x m is created with the specified number of bombs placed randomly.
	 * 
	 * Inputs:		nRows: the number of rows, n
	 * 				nCols: the number of columns, m
	 * 				nBombs: the number of bombs to be randomly placed
	 */
	public Board(int nRows, int nCols, int nBombs) {
		this.nRows = nRows;
		this.nCols = nCols;
		this.createRandomBoard(nRows, nCols, nBombs);
	}
	
	// ------------------------------- Methods -------------------------------
	/* 
	 * Description: This method creates an n x m dimensional board with the
	 * 				specified number of bombs (bombs placed randomly)
	 * 
	 * Inputs:		nRows: the number of rows, n
	 * 				nCols: the number of columns, m
	 * 				nBombs: the number of bombs
	 */
	public void createRandomBoard(int nRows, int nCols, int nBombs) {
		// Initialize board
		this.board = new int[nRows][nCols];
		for (int i = 0; i < this.nRows; i++) {
			for (int j = 0; j < this.nCols; j++) {
				this.board[i][j] = 0;
			}
		}
		// Place bombs randomly
		int bombsPlaced = 0;
		Random rand = new Random();
		while (bombsPlaced < nBombs) {
			int r = rand.nextInt(nRows);
			int c = rand.nextInt(nCols);
			// If bomb already exists at location (r, c),
			// then get another location
			if (board[r][c] == 0) {
				board[r][c] = 1;
				bombsPlaced++;
			}
		}
	}
	
	/* 
	 * Description: This method prints the current state of the board.
	 * Inputs: 		None
	 * Outputs		Prints the current state of the boad.
	 */
	public void printBoard() {
		for (int i = 0; i < this.nRows; i++) {
			for (int j = 0; j < this.nCols; j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
