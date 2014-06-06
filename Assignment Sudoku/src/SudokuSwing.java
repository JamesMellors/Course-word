
import java.awt.*;
import javax.swing.*;


public class SudokuSwing extends SudokuBoard  {
    private JTextField[][] cells = new JTextField [9][9];          // Graphical game board
    private JPanel panel = new JPanel();   // Container

    /**
     * Draws an empty board.
     * @param size Number of rows and columns of the board.
     */
    public SudokuSwing(int size) {
        super(size);
        cells = new JTextField[size][size];
        panel.setLayout(new GridLayout(size, size));
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++)  {
                cells[row][col] = new JTextField(1);
                panel.add(cells[row][col]);
            }
        }
    }

    /**
     * Draws and initializes the board.
     * @param board Array to initialize the board.
     */
    public SudokuSwing(int[][] board) {
        this(board.length);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                setCell(board[row][col], row, col);
            }
        }
    }
    
    /**
     * Puts a number into a specific text field.
     * @param num Number to put into the text field.
     * @param row Cell's row.
     * @param col Cell's column.
     */
    public void setCell(int num, int row, int col) {
        super.setCell(num, row, col);
        String text = (num == EMPTY) ? "" : String.valueOf(num);
        cells[row][col].setText(text);
    }
    
    /**
     * Returns the number contained in a specific text field.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return The number contained in the cell.
     */
    public int getCell(int row, int col) {
        int cell;

        try {
            cell = Integer.parseInt(cells[row][col].getText());
        }
        catch (NumberFormatException e) {
            cell = EMPTY;
        }
        return cell;
    }
    
    /**
     * Returns the JPanel containing the board.
     * @return Returns the board container.
     */
    public JPanel getPanel() {
        return panel;
    }
}