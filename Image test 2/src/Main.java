import java.awt.*;
import java.awt.image.*;
import java.applet.Applet;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*; 
import javax.swing.*; 
import javax.swing.event.ChangeListener;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main extends Canvas implements ActionListener {

BufferedImage edgeImage;
BufferedImage sourceImage;
File sourcefile,savedFile;
int width,height;
final JFileChooser fc = new JFileChooser();
	 private static JPanel buttonPanel; 
	 static JPanel sliderPanel;
	 private static JButton imageone, imagetwo, imagethree, imagefour, loadButton;
	 static JSlider slider = new JSlider(0,100,100);
	 
	 
public Main() //throws Exception
{


sourceImage=Load.getBufferedImage("name.jpg", this);
//sourceImage=ImageUtilities.getBufferedImage("1.jpg", this);
//sourceImage=ImageUtilities.getBufferedImage("2.jpg", this);
//sourceImage=ImageUtilities.getBufferedImage("3.jpg", this);
//sourceImage=ImageUtilities.getBufferedImage("4.jpg", this);
width=sourceImage.getWidth(this);
height=sourceImage.getHeight(this);

Edge edgeDetector=new Edge();

        edgeDetector.setSourceImage(sourceImage);
        edgeDetector.setHighThreshold(4); 
        edgeDetector.setWidth(170);
        
            edgeDetector.process();
       
        edgeImage=edgeDetector.getEdgesImage();
        repaint();

       savedFile=new File("test.jpg");
       //savedFile=new File("1.jpg");
      // savedFile=new File("2.jpg");
   //    savedFile=new File("3.jpg");
    //   savedFile=new File("4.jpg");
                try {
                ImageIO.write(edgeImage,"jpeg",savedFile);
                } catch (Exception e) {}


}

 public void paint(Graphics g)
 {
 int x = 80;
 int y = 15;

 g.drawImage(sourceImage, x, y, this);
 g.drawImage(edgeImage, x+width+40, y, this);

}

public static void main(String[] args) {
	 
	   JFrame frame=new JFrame();
            
	    //try {
	    Main ce=new Main();
            frame.add(ce);
            //} catch(Exception e){};
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // sliderPanel= new JPanel();
            buttonPanel=new JPanel();
            imageone = new JButton("1");
            imagetwo = new JButton("2");
            imagethree = new JButton("3");
            imagefour = new JButton("4");
            slider = new JSlider();
            buttonPanel.setLayout(new GridLayout(1,4));
            buttonPanel.add(imageone); 
            buttonPanel.add(imagetwo); 
            buttonPanel.add(imagethree); 
            buttonPanel.add(imagefour); 
            buttonPanel.add(slider);
           // sliderPanel.setLayout(new GridLayout(2,4));
         //   sliderPanel.add(slider);
           // .add(slider);
            imageone.addActionListener(ce);
            imagetwo.addActionListener(ce);
            imagethree.addActionListener(ce);
            imagefour.addActionListener(ce);
            slider.setMajorTickSpacing(5);
            slider.setMinorTickSpacing(1);
            slider.setPaintTicks(true);
           // slider.setPaintLabels(true);
            frame.add( buttonPanel, BorderLayout.NORTH);
            frame.setTitle("Edge");
            frame.setSize(950, 620);
            frame.setVisible(true);
            slider.addChangeListener((ChangeListener) ce);
            slider.setEnabled(true);
            

       }

public void stateChanged(ChangeListener ce){
	Edge edgeDetector=new Edge();

    edgeDetector.setSourceImage(sourceImage);
    edgeDetector.setHighThreshold(2); 
    edgeDetector.setWidth(170);
    
        edgeDetector.process();
   
    edgeImage=edgeDetector.getEdgesImage();
    repaint();
}


public void actionPerformed(ActionEvent ce){
    if (ce.getSource()==imageone){


    	sourceImage=Load.getBufferedImage("1.jpg", this);
    	
    	width=sourceImage.getWidth(this);
    	height=sourceImage.getHeight(this);

    	Edge edgeDetector=new Edge();

    	        edgeDetector.setSourceImage(sourceImage);
    	        edgeDetector.setHighThreshold(4); 
    	        edgeDetector.setWidth(170);
    	        
    	            edgeDetector.process();
    	       
    	        edgeImage=edgeDetector.getEdgesImage();
    	        repaint();

    	       savedFile=new File("test.jpg");
   
    	                try {
    	                ImageIO.write(edgeImage,"jpeg",savedFile);
    	                } catch (Exception e) {}


    	
    	repaint();
    }
    if (ce.getSource()==imagetwo){
    
    	sourceImage=Load.getBufferedImage("2.jpg", this);
    	
    	width=sourceImage.getWidth(this);
    	height=sourceImage.getHeight(this);

    	Edge edgeDetector=new Edge();

    	        edgeDetector.setSourceImage(sourceImage);
    	        edgeDetector.setHighThreshold(4); 
    	        edgeDetector.setWidth(170);
    	        
    	            edgeDetector.process();
    	       
    	        edgeImage=edgeDetector.getEdgesImage();
    	        repaint();

    	       savedFile=new File("test.jpg");
    	    
    	                try {
    	                ImageIO.write(edgeImage,"jpeg",savedFile);
    	                } catch (Exception e) {}


    	
    	repaint();
    }
    
    if (ce.getSource()==imagethree){
  
    	sourceImage=Load.getBufferedImage("3.jpg", this);
    	
    	width=sourceImage.getWidth(this);
    	height=sourceImage.getHeight(this);

    	Edge edgeDetector=new Edge();

    	        edgeDetector.setSourceImage(sourceImage);
    	        edgeDetector.setHighThreshold(4); 
    	        edgeDetector.setWidth(170);
    	        
    	            edgeDetector.process();
    	       
    	        edgeImage=edgeDetector.getEdgesImage();
    	        repaint();

    	       savedFile=new File("test.jpg");
    	   
    	                try {
    	                ImageIO.write(edgeImage,"jpeg",savedFile);
    	                } catch (Exception e) {}


    	
    	repaint();
    }
    
    if (ce.getSource()==imagefour){
    	
    	sourceImage=Load.getBufferedImage("4.jpg", this);
    	width=sourceImage.getWidth(this);
    	height=sourceImage.getHeight(this);

    	Edge edgeDetector=new Edge();

    	        edgeDetector.setSourceImage(sourceImage);
    	        edgeDetector.setHighThreshold(3); 
    	        edgeDetector.setWidth(170);
    	        
    	            edgeDetector.process();
    	       
    	        edgeImage=edgeDetector.getEdgesImage();
    	        repaint();

    	       savedFile=new File("test.jpg");
    	     
    	                try {
    	                ImageIO.write(edgeImage,"jpeg",savedFile);
    	                } catch (Exception e) {}
    	
    	repaint();
    }   
  
    
    	
   if (ce.getSource()==loadButton){

		   int returnVal = fc.showOpenDialog(loadButton);
		   if (returnVal == JFileChooser.APPROVE_OPTION) {
		   File file = fc.getSelectedFile();
		   //This is where a real application would open the file.
		   System.out.println("File: " + file.getName() + "."); 
		   } else {
		   System.out.println("Open command cancelled by user.");
		   }
		   System.out.println(returnVal);
		   
   }
}
}



		 //  try {
		//   canvas.load();
	//	   } catch (IOException e1) {
		  // System.out.println("The load does not work");
	//	   }
//    }
		    
		//   }

//}




