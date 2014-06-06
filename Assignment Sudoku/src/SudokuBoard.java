import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class SudokuBoard {
    final int EMPTY = 0;      // Empty cells marker
    final int size;           // Size of the board (number of rows and columns)
    final int box_size; // Size of the inner boxes
    
 //   private int row;
  //  private int col;
    private int[][] board; // 2D array representing the game board
	

    /**
     * Creates an empty board.
     * @param size Number of rows and columns of the board.
     */
    public SudokuBoard(int size){
    //	this.row = row;
      //  this.col = col;
       board = new int[9][9];
       this.size = 9;
       this.box_size = (int) Math.sqrt(size);
    }
    
    /**
     * Creates and initializes the board.
     * @param board Array to initialize the board contents.
     */
    public SudokuBoard(int[][] board) {
        this(board.length);
        this.board = board;
        for (int row = 0; row < 9; row++)
        for (int col = 0; col < 9; col++);
                   
                   
            
    }
    
    /**
     * Puts a number into a chosen cell.
     * @param num Number to put into the board cell.
     * @param row Cell's row.
     * @param col Cell's column.
     */
    public void setCell(int num, int row, int col) {
        board[row][col] = num;
    }

    /**
     * Returns the number contained in a chosen cell.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return The number contained in the cell.
     */
    public int getCell(int row, int col) {
        return board[row][col];
    }
    
  /*  private boolean solve2(int row, int col) {
        if(row > 8) {
            return true;
        }
        if(board[row][col] == 0) {
            for(int var = 1; var < 10; var++) {
                if(checkFill(row, col, var)) {
                    board[row][col] = var;
                    if(col >= 8) {
                        board(row + 1, 0);
                    } else {
                        board(row, col+1);
                    }
                }
            }
        } else {
            if(col >= 8) {
                board(row + 1, 0);
            } else {
                board(row, col+1);
            }
        }
        return false;
    }
    
    private void board(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private boolean checkFill(int num, int col, int row) {
        for(int a = 0; a < 9; a++) {
            if(board[a][col] == num) {
                return false;
            }
        }
        for(int a = 0; a < 9; a++) {
            if(board[row][a] == num) {
                return false;
            }
        }
        int tempI = (row / 3) * 3;
        int tempJ = (col / 3) * 3;
        for(int a = 0; a < 3; a++) {
            for(int b = 0; b < 3; b++) {
                if(board[tempI + a][tempJ + b] == num)
                    return false;
            }
        }
        return true;
    }
     
    */
    
  /*  public static void load(String filename) throws IOException {
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
        board[row][column]=temp.charAt(column-1);	

    	}
    	System.out.println("Loaded:" +board);


    	}

    	infile.close();
    	}*/
}

