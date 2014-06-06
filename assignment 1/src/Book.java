import java.io.*;

public class Book implements Serializable {

	private String title;
	private int price;
	private Author writer;
	
	
		
	
	public void setTitle(String title) {
		this.title = title;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public void setWriter(Author writer) {
		this.writer = writer;
	}
public Book() {}


	public Book(String t, int p){
		title=t;
		price=p;
	}
	
	
	
	public String getTitle() {
		
		return title;
	}
	
	
	
	public int getPrice(){
		return price;
	}
	
	
	public Author getWriter() {
		return writer;
	}

	
	
	public String toString(){
		
		return title+ "\n" +price;
	}
	
	
}

	
	

