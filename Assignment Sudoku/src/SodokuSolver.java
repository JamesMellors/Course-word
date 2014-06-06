import java.util.List;


abstract class SudokuSolver {
    private SudokuBoard sb;    // Puzzle to solve;
  // private SudokuSwing ss;
   
    public SudokuSolver(SudokuBoard sb) {
    	
        this.sb = sb;
    }
    
  //  public SudokuSolver(SudokuSwing ss){
   	//this.ss = ss;
   //}
    
    /**
     * Check if a number candidate for
     * the given cell.
     * @param num Number to check.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return false if number already appears in the row,
     *         column and the box that the cell belongs to.
     */
    private boolean check(int num, int row, int col) {
        int Row = (row / sb.box_size) * sb.box_size;
        int Colum = (col / sb.box_size) * sb.box_size;
        
        for (int i = 0; i < sb.size; i++) {
            if (sb.getCell(row, i) == num ||
                sb.getCell(i, col) == num ||
                sb.getCell(Row + (i % sb.box_size), Colum + (i / sb.box_size)) == num) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Test all candidate numbers for a given cell
     * @param row Cell's row.
     * @param col Cell's column.
     * @return false if no legal numbers are found for this cell.
     */
   public boolean solve(int row, int col) {
        int nextCol = (col + 1) % sb.size;
        int nextRow = (nextCol == 0) ? row + 1 : row;
        
        try {
            if (sb.getCell(row, col) != sb.EMPTY)
                return solve(nextRow, nextCol);
            
        }
        catch (ArrayIndexOutOfBoundsException e) {
                return true;
        }

        for (int i = 1; i <= sb.size; i++) {
            if (check(i, row, col)) {
                sb.setCell(i, row, col);
                if (solve(nextRow, nextCol)) {
                    return true;
                }
            }
        }
        sb.setCell(sb.EMPTY, row, col);
        return false;
    }
  
   
  /* public boolean solve(int row, int col){
	   int nextCol = (col + 1) % sb.box_size;
       int nextRow = (nextCol == 0) ? row + 1 : row;
       
       try {
           if (sb.getCell(row, col) != sb.EMPTY)
               return solve(nextRow, nextCol);
           System.out.println("Final");
       }
       catch (ArrayIndexOutOfBoundsException e) {
               return true;
       }

       for (int i = 1; i <= sb.box_size; i++) {
           if (check(i, row, col)) {
               sb.setCell(i, row, col);
               if (solve(nextRow, nextCol)) {
                   return true;
               }
           }
       }
       sb.setCell(sb.EMPTY, row, col);
	   return false;
	   
	   
   }*/

 

}
