import java.awt.*; import javax.swing.*; import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class modules the Board in a Game of Life
 */
public class BoardModel{
        //Using boolean makes sense since true means cell occupied and false not
        private static char grid[][];
		private char newgrid[][];
        private LifeCanvas Canvas;
       private static ArrayList<char[][]> frames;
       /**
        ** Constructs a board of size rows x columns. Note that
        ** boards start from position (1,1) and not (0,0)
        ** @param rows The number of rows and must be positive
        ** @params columns The number of columns and must be positive
        ** @exception IllegalArgumentException is thrown if rows or columns
        ** are not positive values
        */
        public BoardModel(int row, int column) {
            // Let caller decide on the size of the board grid. However
            // we add a layer of cells around the edge of the grid to
            // make the calc method algorithm easier.
            if (row < 1 || column < 1)
               throw new IllegalArgumentException("Rows & columns must be +ve");
            // By default all the values in the grid are set to false
            grid = new char[row+2][column+2];
            newgrid = new char[row+2][column+2];
            frames = new ArrayList<char[][]>();
            frames.add(grid);
        }
        /*
        ** Return true if the board position has true value, else false
        ** @param row to check. Must be within limits of board
        ** @param column to check. Must be within limits of board
        ** @exception IllegalArgumentException is thrown if a row or column
        ** goes outside the bounds of the visible board
        */
        public char getValue (int row, int column){
            if ((row < 1 || row >= grid.length-1) ||
                (column < 1 || column >= grid[0].length-1))
               throw new IllegalArgumentException
                    ("Attempting to access beyond the bounds of the board");
            return grid[row][column];
        }
       /**
        ** Sets a specific value in the board grid to the given value
        ** @param row to set. Must be within limits of board
        ** @param column to set. Must be within limits of board
        ** @exception IllegalArgumentException is thrown if a row or column
        ** goes outside the bounds of the visible board
        **
        */
        public void setValue(int row, int column, char b) {
            if ((row < 1 || row >= grid.length-1) ||
                (column < 1 || column >= grid[0].length-1))
               throw new IllegalArgumentException
                    ("Attempting to access beyond the bounds of the board");
            grid[row][column] = b;
        }
        /**
        ** Calculate the cells to die and those to be born based approx. on
        ** game of life rules
        */
        
        public void setDefault () {
        	int row, column; 
        	for (row=0; row < grid.length-2; row ++)
        		for (column=0; column < grid[0].length-2; column++)
        			grid[row] [column] = 'd';
        }
      
            
               
       /**
        ** Resets the board grid to empty
        */
        public void clear() {
           int row, column;
           for (row=0; row < grid.length-2; row++)
               for (column=0; column < grid[0].length-2; column++)
                   grid[row][column] = 'd';
           
        }
       /**
        ** Updates the current board grid to make it reflect
        ** the newly calculated state
        */
        public void copy(){
            for (int row=0; row < grid.length-2; row++)
                 for (int column=0; column < grid[0].length-2; column++)
                     grid[row][column]= newgrid[row][column] = 'd';
        }
       /**
        ** Returns true if the newgrid is now different from
        ** the old grid
        */
        public boolean hasChanged() {
           for (int row=0; row < grid.length-2; row++)
               for (int column=0; column < grid[0].length-2; column++)
                   if (grid[row][column] != newgrid[row][column])
                         return true;
           return false;
        }
        
        public static void saveFrame(String filename) throws FileNotFoundException {
			//BoardModel.setGridValues();
	PrintWriter outfile = new PrintWriter (new OutputStreamWriter
	( new FileOutputStream(filename)));
	outfile.println(frames.size());
	outfile.println(grid.length-2);
	for (int row=0; row < grid.length-2; row++) 
	{
		for (int column=0; column < grid[0].length-2; column++)
		{
			outfile.print(grid[row][column]);

		}
		System.out.println("Saved:" +grid);
		outfile.println();
		
		
		
	}
	outfile.close();
}

        
     /*  public static void loadFrame(String filename) throws IOException {
        	Scanner infile =new Scanner(new InputStreamReader
        			(new FileInputStream(filename)));
        	for (int row=0; row < grid.length; row++){
        	for	(int column=0; column < grid[0].length; column++){
        			
        		}
        		System.out.println("Saved:" +grid);
        	}
        	infile.close();
        }*/
        
        public static void loadFrame(String filename) throws IOException {
        	Scanner infile =new Scanner(new InputStreamReader
        	(new FileInputStream(filename)));
        	int nof;//number of frames
        	int dims;//dimensions
        	String temp;

        	//nof=frames.size();
        	nof=infile.nextInt();
        	infile.nextLine();
        	dims=infile.nextInt();
        	infile.nextLine();
        	for (int row=1;row<dims+1;row++) {
        	temp=infile.nextLine();
        	for (int column=1; column<dims+1;column++){
        	grid[row][column]=temp.charAt(column-1);	

        	}
        	System.out.println("Loaded:" +grid);


        	}

        	infile.close();
        	}
}
 
       

