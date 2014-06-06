import java.util.Arrays;
public class Array2d {
	

	public void main(String[] args) {
 	   char[] letters = new char[5];
        for (char c :letters) {
        	System.out.println("'" + c + "' '\0' " +
        Character.getNumericValue('\0'));
        }
       boolean[] values = new boolean[5];
        for (boolean b: values) {
     	   System.out.println(b);
        }
        boolean[] [] gridData;
        int rows = 4;
        int columns =3;
        gridData = new boolean[rows][columns];
        
        for(int row = 0; row < 4; row++) {
 	System.out.println(" Data at:" +row+ "" +columns+ "" + gridData[row] [columns]);
 	gridData [row] [columns] = true;
 }
	}
}

