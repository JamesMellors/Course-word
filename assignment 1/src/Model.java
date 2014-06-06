import java.io.*;
import java.util.*;
import java.beans.XMLEncoder; 
import java.beans.XMLDecoder;


public class Model implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -5594670457928726016L;
	private ArrayList<Book> books;
	private ArrayList<Author> authors;
	private transient Scanner input = new Scanner(System.in);

	public Model() {

		books = new ArrayList<Book>();
		authors = new ArrayList<Author>(); 

	}

	public void runApplication() throws IOException, ClassNotFoundException {
		String response = "";
		input = new Scanner(System.in);
		String n;
		String nat;
		String t;
		int p;

		do {
			printMenu();
			response = input.nextLine();

			if (response.equals("1")) { // add book
				System.out.println("Enter new book title");
				t = input.nextLine();
				System.out.println("Enter the price of the book");
				p = Integer.parseInt(input.nextLine());
				

				Book temp = new Book(t, p);
				books.add(temp);
				System.out.println(books.size());

			}

			else if (response.equals("2")) { // save books info
				saveBooks("Books.txt");

			}

			else if (response.equals("3")) { // load books info
				loadBooks("Books.txt");

			}

			else if (response.equals("4")) { // load books info
				saveNewBooks("newBooks.txt");

			}

			else if (response.equals("5")) { // load books info
				loadNewBooks("newBooks.txt");

			}

			else if (response.equals("6")) { // load books info
				System.out.println("Enter new authors name");
				n = input.nextLine();
				System.out.println("Enter new authors nationality");
				nat = input.nextLine();

				Author temp = new Author(n, nat);
				authors.add(temp);
				System.out.println(authors.size());

			}

			else if (response.equals("7")) {
				saveAuthors("Authors.txt");
			}

			else if (response.equals("8")) {
				loadAuthors("Authors.txt");
			}

			else if (response.equals("9")) { // link book to author
				System.out.println("Enter the book you want to link");
				t = input.nextLine();
				System.out.println("Enter this books price");
				p = input.nextInt();
				input.nextLine();
				Book tempbook = new Book(t, p);
				books.add(tempbook);

				System.out.println("Enter authors name to link with this book");
				n = input.nextLine();
				System.out.println("Enter this authors nationality");
				nat = input.nextLine();
				Author tempauth = new Author(n, nat);
				authors.add(tempauth);

				System.out.println("The book " + tempbook + "\n"
						+ "is now linked to the author " + tempauth);

				// line that specifies link
			}

			else if (response.equals("0")) { // link book to author
				printAuthors("");
			}

			else if (response.equals("s")) { // link book to author
				System.out
						.println("Enter the title of the book that you would like to search");
				t = input.nextLine();
				searchAndPrintBook(t);

			}

			else if (response.equals("w")) {
				try {
					write("model.ser");

				} catch (IOException e) {
					System.out.println("...");
				}
			}

			else if (response.equals("r")) {
				Model m = read("model.ser");

			}
			
			else if (response.equals("x")){
				writeXML("modelxml.xml");

		} 
		
		else if (response.equals("b")){
			printBook();
	}
		
		
		else if (response.equals("a")){
			printAuthor();
		}
		}

	
		
		while (!((response.equals("Q") || (response.equals("q")))));
		System.out.println("Thank you and good bye");
	
	}

	

	public void printMenu() {

		System.out.println("=============================================    ");
		System.out.println("         What would you like to do:              ");
		System.out.println("   1 - Add book                                  ");
		System.out.println("   2 - Save book to file                         ");
		System.out.println("   3 - Load books from file                      ");
		System.out.println("   4 - Save newly added books                    ");
		System.out.println("   5 - Load newly added books                    ");
		System.out.println("   6 - Add Author                                ");
		System.out.println("   7 - Save Authors                              ");
		System.out.println("   8 - Load Authors                              ");
		System.out.println("   9 - Link book to a writer                     ");
		System.out.println("   0-  Show Authors from file                    ");
		System.out.println("   s - Search for a book                         ");
		System.out.println("   w - Write to serialization                    ");
		System.out.println("   r - Read file                                 ");
		System.out.println("   x - Write to XML                              ");
		System.out.println("   a - Print Authors                             ");
		System.out.println("   b - print Books                               ");
		System.out.println("   Q - Quit                                      ");
		System.out.println("=============================================    ");

	}

	public void printBook() {
		System.out.println("The books:\n");
		for (Book bookList :books){
			System.out.print(bookList.toString());
			System.out.print("\n");
		}
			
		}
		
	public void printAuthor() {
		System.out.println("The authors:\n");
		for (Author authorList :authors){
			System.out.println(authorList.toString());
			System.out.println("\n");
		
	}

	}

	public void saveBooks(String fileName) throws IOException {
		PrintWriter outfile = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(fileName)));
		outfile.println(books.size());
		for (Book bks : books) {
			outfile.println(bks.toString());

			System.out.println("Saved:" + bks.getTitle());

		}
		outfile.close();
	}

	public void loadBooks(String fileName) throws IOException {
		Scanner infile = new Scanner(new InputStreamReader(new FileInputStream(
				fileName)));
		int num = infile.nextInt();
		for (int i = 0; i < num; i++) {
			String t = infile.next();
			int p = infile.nextInt();

			Book bks = new Book(t, p);
			books.add(bks);

			System.out.println("Loaded:" + bks.toString());

		}
		infile.close();

	}

	// ////////////////////////////////////////////////////////////////// SAVE
	// AND LOAD NEW BOOKS///////////////////////////////////////////
	public void saveNewBooks(String fileName3) throws IOException {
		PrintWriter outfile = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(fileName3)));
		outfile.println(books.size());
		for (Book bks : books) {
			outfile.println(bks.toString());

			System.out.println("Saved new book:" + bks.getTitle());

		}
		outfile.close();
	}

	public void loadNewBooks(String fileName3) throws IOException {
		Scanner infile = new Scanner(new InputStreamReader(new FileInputStream(
				fileName3)));
		int num = infile.nextInt();
		for (int i = 0; i < num; i++) {
			String t = infile.next();
			int p = infile.nextInt();

			Book bks = new Book(t, p);
			books.add(bks);

			System.out.println("Loaded new books:" + bks.toString());

		}
		infile.close();

	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void printAuthors(String name) {
		System.out.println("The Authers in the file are");
		for (Author au : authors) {
			System.out.println(au.toString());
		}

	}

	public void loadAuthors(String fileName2) throws IOException {
		Scanner infile2 = new Scanner(new InputStreamReader(
				new FileInputStream(fileName2)));
		int num = infile2.nextInt();
		for (int i = 0; i < num; i++) {
			String n = infile2.next();
			String nat = infile2.next();

			Author au = new Author(n, nat);
			authors.add(au);

			System.out.println("Loaded:" + au.toString());

		}
		infile2.close();

	}

	public void saveAuthors(String fileName) throws IOException {
		PrintWriter outfile = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(fileName)));
		outfile.println(authors.size());
		for (Author au : authors) {
			outfile.println(au.toString());

			System.out.println("Saved author:" + au.getName());

		}
		outfile.close();
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////=========================================================================================================================

	public void searchAndPrintBook(String title) {

		System.out.println("The book you have searched for:");

		for (Book bks : books) {
			if (title.equals(bks.getTitle())) {
				System.out.println(bks.toString());
				return;
			}

		}

	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////=========================================================================================================================

	public void write(String pathName) throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				pathName));
		oos.writeObject(this);
		oos.close();
	}

	public static Model read(String pathName)  {

		Model result = null;
		
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(
						pathName));
				File f = new File(pathName);
				System.out.println(f.isFile());
				result = (Model) ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		
		
			return result;
		
	}
	
	public void writeXML(String pathname) throws IOException{
		XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream(
		new FileOutputStream(pathname)));
		encoder.writeObject(this); 
		encoder.close();
	}
	
	
	public static Model reader(String pathname) throws IOException {
		Model app = null;
		XMLDecoder decoder = new XMLDecoder(
		new BufferedInputStream(
		new FileInputStream(pathname)));
		app = (Model)decoder.readObject(); 
		decoder.close();
		return app;
		}
	
	

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////=========================================================================================================================

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// /////////////=========================================================================================================================

}
