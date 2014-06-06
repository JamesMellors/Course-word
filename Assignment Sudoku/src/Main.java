import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
	private SudokuSwing ss;
	/**This is for putting the numbers into the grid so for setting the cells 
	 * so that the program will be able to solve the puzzle.
	  */
	public static void main(String[] args) throws FileNotFoundException {
	      int[][] board =   {{0, 0, 0, 4, 0, 0, 0, 2, 0},
	                         {0, 0, 7, 0, 0, 0, 6, 0, 3},
	                         {0, 4, 0, 0, 0, 5, 0, 7, 0},
	                         {9, 0, 0, 0, 5, 0, 1, 0, 0},
	                         {0, 0, 0, 7, 0, 8, 0, 0, 0},
	                         {0, 0, 8, 0, 9, 0, 0, 0, 6},
	                         {0, 2, 0, 3, 0, 0, 0, 5, 0},
	                         {3, 0, 4, 0, 0, 0, 8, 0, 0},
	                         {0, 9, 0, 0, 0, 2, 0, 0, 0}};
	        
		BufferedReader br = null;
		 
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("book55.sud"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				
				    
			}
 
		} catch (IOException e) {
			System.out.println("Could not load.");
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				System.out.println("Could not load.");
			}
			
			
		}
	        new SodokuSwingBoard(new SudokuSwing(board));
	    }   
	}


