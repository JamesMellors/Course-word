import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * This class represents the View and the Controller for the game of LIfe
 * Look up on Google for how Life works :)
 * 
 * This is more an example of what CAN be done with Swing
 * than of how it should be done. I first wrote it long ago.
 * so the comments and spacing are inplaces erratic so as to fit on one page
 * READ THIS BIT WHEN WE HAVE LOOKED AT THREADS: (or read ahead)
 * By putting the run into a separate thread, you can see the updating board 
 * and you can use the stop button while it is running to stop it.
 * SwingWorker threads are now the standard way to do this 
 */
public class LifeSwing extends JFrame implements ActionListener{ 
	private String filename="frame.txt";
    private JPanel buttonPanel;           //area of controls
    private JButton keepButton, clearButton, runButton, stopButton, saveButton, loadButton; //buttons
    private LifeCanvas canvas;            //area the grid shows in
    private BoardModel board;
    final JFileChooser fc = new JFileChooser();
   //private JTextField field1 = new JTextField("example");
    Thread runningThread;                 //handles animation of run   
    /**
     * constructor - builds buttons and board (in an instance of NewCanvas)
     */
    public LifeSwing() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Animation Creater");
        //buttons
        buttonPanel=new JPanel();
        keepButton = new JButton("step");
        clearButton = new JButton("clear");
        saveButton = new JButton("save");
        loadButton =new JButton("load");
       
      // buttonPanel.add(field1);
        runButton = new JButton("run");
        stopButton = new JButton("stop");
        buttonPanel.setLayout(new GridLayout(1,4));
        buttonPanel.add(keepButton);   buttonPanel.add(clearButton);     buttonPanel.add(saveButton);  
        buttonPanel.add(runButton);    buttonPanel.add(stopButton);      buttonPanel.add(loadButton);
        keepButton.addActionListener(this);
        clearButton.addActionListener(this);
        runButton.addActionListener(this);
        stopButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
       
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        //board
        canvas=new LifeCanvas("Click to colour the squares");
        canvas.setBorder(BorderFactory.createLineBorder(Color.black,6));
        add(canvas, BorderLayout.CENTER);
        //ready to go
        setSize(500,550);         setVisible(true);
        setLocation(400,200);
        
    }
    
   
    /**
     * This object is its own Listener so respond to button presses
     */
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==keepButton)
            canvas.step();
        if (e.getSource()==clearButton)
            canvas.clear();
        if (e.getSource()==runButton){
            runningThread=new Thread(canvas);//start LifeCanvas in own thread
            runningThread.start();         }
        if (e.getSource()==stopButton){
            canvas.stopit();          }  
        if (e.getSource()==saveButton){
        	try {
				canvas.save();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
        }
        
        	
       if (e.getSource()==loadButton){

    		   int returnVal = fc.showOpenDialog(loadButton);
    		   if (returnVal == JFileChooser.APPROVE_OPTION) {
    		   File file = fc.getSelectedFile();
    		   //This is where a real application would open the file.
    		   System.out.println("File: " + file.getName() + "."); 
    		   } else {
    		   System.out.println("Open command cancelled by user.");
    		   }
    		   System.out.println(returnVal);
    		   



    		   try {
    		   canvas.load();
    		   } catch (IOException e1) {
    		   System.out.println("The load does not work");
    		   }
        }
    		    
    		   }
}
    
       	
              
        	
      
        
    
    
    


