package java_shell;

import java.util.Random;

public class Board {
	public int nRows;
	public int nCols;
	public int[][] board;  // change to Tiles
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	public Board(int nRows, int nCols, int[][] grid) {
		this.nRows = nRows;
		this.nCols = nCols;
		this.board = grid;
	}
	
	public Board(int nRows, int nCols, int nBombs) {
		this.nRows = nRows;
		this.nCols = nCols;
		this.createRandomBoard(nRows, nCols, nBombs);
	}
	
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
	
	public void printBoard() {
		// Print created board
		for (int i = 0; i < this.nRows; i++) {
			for (int j = 0; j < this.nCols; j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
