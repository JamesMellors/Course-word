import java.io.*;

import java.io.IOException;
import java.util.Scanner;


public class Main  {

	public static void main (String args[]) throws IOException, ClassNotFoundException{
		Scanner in=new Scanner(System.in);
        System.out.print("do you want to load a file (or start from scratch)? OR x for xml y/n/x ");
        String response=in.nextLine();
        Model app;
        if (response.equals("y")){
            app=Model.read("model.ser");
            
            if (app==null)
                 app=new Model();
        }
        
        else if (response.equals("x")){
        	app=Model.reader("modelxml.xml");
        	app.runApplication();
        }
        else
            app=new Model();
        app.runApplication();
	
    }
	
}
