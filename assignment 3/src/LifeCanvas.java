import java.awt.*; import javax.swing.*; import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * This class displays the game of Life using SWing
 */
public class LifeCanvas extends JPanel implements MouseListener,Runnable{
    private String status;
    private boolean keepGoing;
    private BoardModel board;
    private int ROWS = 20;
    private int COLUMNS = 20;
    private String filename="frame.txt";
    
    
    	
    
    
           
    /**
     * constructor builds the LifeCanvas and creates Model
     */
    public LifeCanvas(String initstring) {
        status=initstring;
        setBackground(Color.white);         
        board=new BoardModel(ROWS, COLUMNS); // Create ROWS x COLUMNS board
        this.addMouseListener(this);
        board.setDefault();
        
    }

    /**
     * paints the Canvas - calls drawgris()
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawgrid(g);          
        g.drawString(status,150, 20);
    }
  

    /**
     * the actual drawing 
     */
    public void drawgrid(Graphics g) {
        
    	    // the leftmost position for a block on a row
        int startX = 40;
        
        // the topmost position for a block on a row 
        int startY = 40;
        
        // sets the colour to blue on the graphics context. This 
        // means that the lines and text will be drawn in blue 
        // from this point until the colour is changed again 
        g.setColor(Color.black);
        
        // an outer loop, that uses the variable i to represent the 
        // current row number. 
        for (int row = 0; row < ROWS; row++) { 
        	
        	    // an outer loop, that uses the variable j to represent 
        	    // the current column number. It goes from 0 to COLUMNS-1
        	    // for each ROW in the outer loop. 
            for (int col = 0; col < COLUMNS; col++) { 
            	
            	   int topLeftX = startX + (col * 20); 
       		   int topLeftY = startY + (row * 20); 
       		   int width = 18; 
       		   int height = 18;
       		   
       		if (board.getValue(row+1,col+1)=='r') { 
     		   g.setColor(Color.RED);
     		    g.fillRect(topLeftX, topLeftY, width, height);
 	        	
       		}
       		
       		else if (board.getValue(row+1,col+1)=='n') { 
      		   g.setColor(Color.BLACK);
      		    g.fillRect(topLeftX, topLeftY, width, height);
  	     
        		}
       		
       		else if (board.getValue(row+1,col+1)=='m') { 
       		   g.setColor(Color.GRAY);
       		    g.fillRect(topLeftX, topLeftY, width, height);
   	        	
         		}
       		
       		else if (board.getValue(row+1,col+1)=='l') { 
       		   g.setColor(Color.BLUE);
       		    g.fillRect(topLeftX, topLeftY, width, height);
   	        	
         		}
       		 
       	//	System.out.format("board position: [%d,%d] - drawing at top left: (%d,%d) and bottom right: (%d,%d)\n", 
	      //      col, row, topLeftX, topLeftY, topLeftX + width, topLeftY + height);
     	   
            	   // check if the block at the position i,j is not 'alive'
            	   { 
                    
            		    // the block is not 'alive', so draw an 
            		    // rectangle that doesn't have a fill 
            		    g.drawRect(topLeftX, topLeftY, width, height);
            		    g.setColor(Color.BLACK);
            	   }
               
            	        // the block is 'alive', so draw a filled 
            	        // rectangle 
                    
               }
            }
        }
       

    
    
    
    /**
     * this method could be improved a lot with a calculation
     */
    public void mouseClicked(MouseEvent e) {
        int startX = 40; 
        int startY = 40;
        
        int x=e.getX(); 
        int y=e.getY();
        char[] myColours = new char[4];
        
        myColours[0]= 'r';
        myColours[1]= 'n';
        myColours[2]= 'm';
        myColours[3]= 'l';
        
        
        outerloop: 
        for (int row=0; row < ROWS; row++) {
        	 	
            for (int col=0; col < COLUMNS; col++) {
            	
            	   int topLeftX = startX + (col * 20); 
            	   int topLeftY = startY + (row * 20); 
           	       int width = 18; 
        	       int height = 18;
        	       
        		//   System.out.format("board position: [%d,%d] - checking click at top left: (%d,%d) and bottom right: (%d,%d)\n", 
 				  //           col, row, topLeftX, topLeftY, topLeftX + width, topLeftY + height);
	   
        		    boolean xGreaterThanLeft = x > topLeftX; 
        		    boolean xLessThanRight = x < topLeftX + width; 
        		    boolean yGreaterThanTop = y > topLeftY; 
        		    boolean yLessThanBottom = y < topLeftY + height; 
        		   
                if ( xGreaterThanLeft && 
                		 xLessThanRight &&
                     yGreaterThanTop && 
                     yLessThanBottom ) {
                	
                	if (e.getButton() == MouseEvent.BUTTON1) { 
                	
                	
                	if (board.getValue (row+1, col+1) == 'b'){
                		board.setValue(row+1, col+1, 'd');
                	}
                    	
                    else if (board.getValue (row+1, col+1) == 'd'){
                		board.setValue(row+1, col+1, 'n');
                	}
                	
                	else if  (board.getValue (row+1, col+1) == 'n'){
                		board.setValue(row+1, col+1, 'm');
                	
                	}
                	
                	else if  (board.getValue (row+1, col+1) == 'm'){
                		board.setValue(row+1, col+1, 'b');
                	
                	}
                	}
                	
                	else if (e.getButton() == MouseEvent.BUTTON3){
                		
                		if (board.getValue (row+1, col+1) == 'b'){
                     		board.setValue(row+1, col+1, 'd');
                	}
                		else if (board.getValue (row+1, col+1) == 'd'){
                    		board.setValue(row+1, col+1, 'r');
                		}
                		
                		else if (board.getValue (row+1, col+1) == 'r'){
                    		board.setValue(row+1, col+1, 'l');
                		}
                		
                		else if (board.getValue (row+1, col+1) == 'l'){
                    		board.setValue(row+1, col+1, 'b');
                		}
                	}
                
                
        
        
                	
                 
                	  //  System.out.format("Click within the block at: %d,%d\n\n\n", row, col);
                //    board.setValue(row+1, col+1,  );
                    
                    // break to the end of the loop that is labelled with outerloop:
                    break outerloop;  
                }
            }
        }
        
        // refresh the drawing of the board on the canvas
        this.repaint();
    }
    
    
   

    /**
     * one step
     */
    public void step()      {
        status="next frame";
    
        board.copy();
        repaint();
    }   
    
    public void load() throws IOException{
     	BoardModel.loadFrame(filename);
    	repaint();
    	
    }
    
    /**
     * clears board
     */
    public void clear() {
        board.clear();
        repaint();
       
    }

    /**
     * keepsgoing until stopped
     */
    public void run(){
        int i=0;
        status="1 iteration" ;
        keepGoing=true;    
        try{
            while (keepGoing) {
                
                if (!board.hasChanged())
                {status="stable in "+i+" moves"; repaint(); break;}
                if (i==100) 
                {status="100 generations and still changing";repaint();break;}
                board.copy();
                i++;
                status=i+" iterations";          //need slow down here
                Thread.sleep(200);
                repaint();
            }
        }
        catch (InterruptedException e) {}
    }

    /**
     * stop loop
     */
    public void stopit(){
        keepGoing=false;
        status="stopped";
        repaint();
    }      
    
    public void save() throws FileNotFoundException{
    	BoardModel.saveFrame(filename);
    }
    
  
    


    public void mouseReleased( MouseEvent e) {  }

    public void mousePressed( MouseEvent e) {}

    public void mouseEntered( MouseEvent e) {}

    public void mouseExited( MouseEvent e){}


	public void setRows() {
		// TODO Auto-generated method stub
		
	} 
 }
