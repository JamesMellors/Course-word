
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;



public class SodokuSwingBoard extends SudokuSolver  {
private JButton Solvebutton;
    /**
     * Draws the game board.
     * @param this is the  sw the puzzle to solve.
     */
    public SodokuSwingBoard(SudokuSwing sw) {
        super(sw); 
        final JPanel panel = sw.getPanel();
        

        Runnable runner = new Runnable() {
            
        	
        	
       public void run() {
                final JFrame frame = new JFrame("Sudoku");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ActionListener actionl = new ActionListener() {
                    
                	
            
                	public void actionPerformed(ActionEvent AE) {
                        if (! solve(0, 0))
                            JOptionPane.showMessageDialog(frame, "Solution not found!");
                    }
                };
                frame.setLayout(new GridBagLayout());
                addComponent(frame, panel, 0, 0, 1, 1);
                Solvebutton = new JButton ("solve");
            
                Solvebutton.setMnemonic(KeyEvent.VK_S);
                Solvebutton.addActionListener(actionl);
                addComponent(frame, Solvebutton, 0, 1, 1, 1);

                frame.setSize(400, 450);
                frame.setLocation(400,200);
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(runner);
    }
    
    /**
     * Add to the GUI.
     * @param gridx Horizontal cell position inside the grid.
     * @param gridy Vertical cell position inside the grid.
     * @param gridwidth Number of cells in a row for the text field.
     * @param gridheight Number of cells in a column for the text field.
     */
    private static void addComponent(Container container, Component component,
        int gridx, int gridy, int gridwidth, int gridheight) {
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
                gridheight, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, insets, 0, 0);
        container.add(component, gbc);
    }
}