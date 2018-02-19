package java_shell;

import java.io.*;


public class Main {

	public static void main(String[] args) {
		final String validOptions = "f";
		String options = "";
		if (args.length != 0) {
			if (args[0].charAt(0) == '-') {
				System.out.println("options detected");
				for (int i = 1; i < args[0].length(); i++) {
					if (validOptions.contains(args[0].substring(i,i+1))) {
						options += args[0].substring(i,i+1);
					} else {
						// Invalid Option Found
						System.out.println("Print Usage Guidelines Here");
						System.exit(1);
					}
				}
			}
			System.out.println("options: " + options);
		}
		// Read from file if option f was provided
		if (options.contains("f")) {
			int nRows = -1, nCols = -1;
			int[][] grid = {};
			try {
				String filename = args[1];
				BufferedReader in = new BufferedReader(new FileReader(filename));	
				// First line is two integers that denote the number of rows and columns
				String[] dims = in.readLine().split(" ");
				try {
					nRows = Integer.parseInt(dims[0]);
					nCols = Integer.parseInt(dims[1]);
					// text file has 2-d, space-delimited grid of 0's and 1's 
					// indicating locations of bombs (1 for bomb).
					grid = new int[nRows][nCols];
					int row = 0;
					String lineStr = in.readLine();
					while (lineStr != null) {
						String[] line = lineStr.split(" ");
						for (int i = 0; i < line.length; i++) {
							grid[row][i] = Integer.parseInt(line[i]);
						}
						row++;
						lineStr = in.readLine();			
					}

				} catch (NumberFormatException e) {
					System.out.println("Enter only integer values");
				}
				in.close();
			} catch(FileNotFoundException e) {
				// Print something useful
			} catch(IOException e) {
				// Print something useful
			}		
			// Create board that corresponds to text file input
			Board board = new Board(nRows, nCols, grid);
			board.printBoard();
		}
		else  {
			// If no file is provided, create a default random board
			Board board = createRandomBoard(10,10,25);
			board.printBoard();
		}
	}
	
	// For Debugging
	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	public static Board createBoardFromGrid(int nRows, int nCols, int[][] grid) {
		return new Board(nRows, nCols, grid);
	}
	
	public static Board createRandomBoard(int nRows, int nCols, int nBombs) {
		// Initialize 2-D array board representation
		return new Board(nRows, nCols, nBombs);
		
	}
}
