package uk.ac.aber.dcs.cs12420.roladex;
import java.io.*;
import java.util.*;

/**
 * Manages a list of contacts and presents a menu to allow the 
 * user to query and update the list of contacts. 
 * 
 * @author Lynda Thomas (ltt@aber.ac.uk)
 * @author Chris Loftus (cwl@aber.ac.uk)
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class RoladexApplication
{
	/** The roladex */ 
	private Roladex roladex;

	/** Reads keyboard input */ 
	private Scanner in;

	/** 
	 * Creates a new RoladexApplication and attempts to load information from a file.
	 * 
	 * @throws IOException if there is an error loading the information.  
	 */ 
	public RoladexApplication() throws IOException    {
		System.out.println("*** WELCOME TO MY ROLADEX APPLICATION **");
		roladex=new Roladex();
		roladex.load();
		in=new Scanner(System.in);
	}

	/** 
	 * Controls the operations once the application has started. A menu is 
	 * displayed and the user is prompted to select an option. Once an option 
	 * has been selected, the appropriate action is activated.  
	 * 
	 * @throws IOException
	 */
	public void runApp()throws IOException  { 
		char ch;
		do{
			this.printMenu();
			String choice=in.next();
			ch=choice.charAt(0);
			switch (ch) {
			case 'C': case 'c':
				roladex=new Roladex();
				System.out.println("**created brand new roladex");
				break;
			case 'L': case 'l':
				roladex.load();
				break;
			case 'N': case 'n':
				Contact c=new Contact();
				c.readKeyboard();
				roladex.add(c);
				System.out.println("**added contact");
				break;
			case 'P': case 'p':
				roladex.printout();
				break;
			case 'F': case 'f':
				this.find();    //moved code into method for prettiness
				break;  
			case 'D': case 'd':
				roladex.sort();
				break;
			case 'Q': case 'q':
				System.out.println("saving roladex in file");
				roladex.save();
				break;
			default:
				System.out.println("That is not a choice!");
			}
			
		} while ((ch !='Q')&(ch !='q'));
	}

	/** 
	 * Displays the menu for the application. 
	 */
	public void printMenu() {
		System.out.println("\n\n\n *** MENU ***");
		System.out.println("Enter first letters to pick a function:");
		System.out.println("'C' to create a brand new roladex - will lose old one");
		System.out.println("'L' to load a file into roladex");
		System.out.println("'N' to create a New Contact and add");
		System.out.println("'P' to print out whole Roladex");
		System.out.println("'F' to find someone's phone");
		System.out.println("'D' to sort on name");
		System.out.println("could also sort, remove, change");
		System.out.println("'Q' to quit " );
		System.out.print("Type here: ");
	}

	/** 
	 * 
	 */
	public void find() {
		Contact oneToFind=new Contact();
		System.out.print("Who do you want to find? ");
		String n=in.next();
		oneToFind.setName(n);
		Contact found=roladex.find(oneToFind);
		if (found==null)
			System.out.println("cannot find");
		else
			System.out.println("phone number is "+found.getPhone());
	}

    /** 
     * Runs the application. 
     * 
     * @param args A list of command line arguments.
     *  
     * @throws IOException if there is an error processing a file in the 
     * application.  
     */
	public static void main(String args[]) throws IOException {
		RoladexApplication app=new RoladexApplication();
		app.runApp();
		System.out.println("end of program");
	}
}
