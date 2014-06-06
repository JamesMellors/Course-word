package uk.ac.aber.dcs.cs12420.roladex;
import java.io.*;
import java.util.*;

/**
 * Holds information about a set of contacts. 
 * 
 * @author Lynda Thomas (ltt@aber.ac.uk)
 * @author Chris Loftus (cwl@aber.ac.uk)
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class Roladex
{
    /** List of contacts in the Roladex. */
	private ArrayList<Contact> contacts;

    /** Filename for the stored list of contacts. */ 
    private String fileName;
    
    /**
     * Creates a Roladex and initialises it with an empty list of contacts. 
     */
    public Roladex()    {
        contacts=new ArrayList<Contact>(20);
    }
    
    /**
     * Adds a contact. 
     * @param c The contact to be added. 
     */
    public void add(Contact c) {
        contacts.add(c);
    }
    
    /** 
     * Displays information about this Roladex to the output stream. The output
     * includes the filename and the list of contacts.  
     */
    public void printout(){
         System.out.println("My "+fileName+ " contacts are:");
         for (Contact c:contacts) {
             System.out.println(c.toString());
         }
    }
    
    /** 
     * Loads the list of contacts from a filename. The method prompts 
     * the user for a filename and attempts to load a list of contacts from the file. 
     * 
     * @throws IOException if there is a problem reading the file. 
     */
    public void load()  throws IOException{
         //read from file
        Scanner in = new Scanner(System.in);
        System.out.print("Which file will you be using? ");
        fileName=in.next();
        Scanner infile = 
            new Scanner(new InputStreamReader (new FileInputStream
            (fileName)));
         int num=infile.nextInt();
         for (int i=0;i<num;i++) {
             String n=infile.next();
             String p=infile.next();
             Contact c=new Contact(n,p);
             contacts.add(c);
            }
          infile.close();
        }
    
      /** 
       * Saves the details to a file. 
       * 
       * @throws IOException if there is an error writing the details to file. 
       */
      public void save() throws IOException{
         
    	 PrintWriter outfile = new PrintWriter(new OutputStreamWriter 
            (new FileOutputStream(fileName)));
         outfile.println(contacts.size());
         for (Contact c:contacts) {
             outfile.println(c.toString()); //or c.getName() and c.getPhone() 
         }
         outfile.close();
      }
     
      /**
       * Finds a contact that matches the specified contact. 
       * 
       * @param who The specified contact that contains the name that is to 
       * located in the list.
       *  
       * @return The contact, if found or the value <code>null</code> if 
       * no match was found. 
       */
      public Contact find(Contact who) {
         for (Contact c:contacts) {
            if (c.equals(who)) 
               return c;
         }
         return null;
      }
     
      /** 
       * Sorts the list of contacts so that they are in alphabetic order 
       * based on the name of the contact.  
       */
      public void sort() {
         Collections.sort(contacts);
      }
}
