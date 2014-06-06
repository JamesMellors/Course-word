import java.io.*;



public class Author implements Serializable {

	private String name;
	private String nationality;
	
	
	
	public Author(String n, String nat){
		name=n;
		nationality=nat;
	}
		
	
	public void setName(String name) {
		this.name = name;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
public Author() {}

	public String getName() {
		
		return name;
	}
		
	
	public String getNationality(){
		return nationality;
	}
	
	public String toString(){
		
		return "" +name+ "\n" +nationality+ "";
	}
	
}
