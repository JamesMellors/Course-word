/*
 * Created on Nov 28, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package sorting2014;
import java.io.*;
import java.util.*;
/**
 * @author rcs
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
@SuppressWarnings("unchecked")
public class SortDemo {

	public Comparable[] readData(String fileName)
	{
		Comparable[] items;
		File file = new File(fileName);
		BufferedReader reader=null;
		try 
		{
			reader = new BufferedReader(
						 new FileReader(file));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found "+fileName);
			System.exit(0);
		}
		boolean eof = false;
		String inLine=null;
		int numLines=0;
		while (! eof)
		{
			try 
			{
				inLine=reader.readLine();
				if (inLine==null)
				{
					eof=true;
				} else {
					numLines++;
				}
			} catch (IOException e)
			{
			}
		}
		try 
		{
			reader.close();
		} catch (IOException e)
		{
		}
		
		items = new Comparable[numLines];
		
		try 
		{
			reader = new BufferedReader(
						 new FileReader(file));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found "+fileName);
			System.exit(0);
		}
		eof = false;
		inLine=null;
		numLines=0;
		while (! eof)
		{
			try 
			{
				inLine=reader.readLine();
				if (inLine==null)
				{
					eof=true;
				} else {
					items[numLines]=inLine;
					numLines++;
				}
			} catch (IOException e)
			{
			}
		}
		try 
		{
			reader.close();
		} catch (IOException e)
		{
		}
		
		return items;	
	}
	
	public long testOne(String type, Comparable[] items)
	{
		long start;
		long finish;
		long timeTaken = 0;
		Sorter s = SortFactory.getSorter(type);
		if (s != null)
		{
			start=Calendar.getInstance().getTimeInMillis();
			s.sort(items,0);
			finish=Calendar.getInstance().getTimeInMillis();
			timeTaken=finish-start;
		} else {
			System.out.println("Failed loading the sorter, no sorting will happen.");
		}
		return timeTaken;
	}
	
	public void printSortedArray(Comparable[] items)
	{
		for (int i=0; i<items.length; i++)
		{
			System.out.println(items[i]);
		}
	}
	
	public String testAll(String filename)
	{
		String sortTypes[] = {"MergeSort","QuickSort"		
							 ,"SelectionSort","BubbleSort"};
		long timeTaken[] = new long[sortTypes.length];
		StringBuffer retLine=new StringBuffer();
		for (int i= 0; i<sortTypes.length;i++)
		{
			Comparable[] items=this.readData(filename);
			if (items.length>10000 && i>1) break;
			timeTaken[i]=
				this.testOne("sorting."+sortTypes[i],items);
			retLine.append(sortTypes[i]+"\t"+timeTaken[i]+"\n");
		}
		return retLine.toString();
	}

	public String testEverything()
	{
		String filenames [] ={"test3.dat",
							  "test3a.dat","test3b.dat",
							  "test4.dat",
							  "test4a.dat","test4b.dat",
							  "test5.dat",
							  "test5a.dat"
							  ,"test5b.dat",
							  "test6.dat"
							  ,"test6a.dat"
							
							  };
		String sortTypes[] = {"QuickSort",
//		                      "OptimisedQuickSort",
//							  "TreeSort"		
//							 ,"SelectionSort","BubbleSort"
							 };
		long timeTaken = 99999999;
		StringBuffer retLine=new StringBuffer();
		for (int i= 0; i<sortTypes.length;i++)
		{
			retLine.append(sortTypes[i]);
			for (int j=0; j<filenames.length;j++)
			{

				Comparable[] items=this.readData(filenames[j]);
				if (items.length>10000 && i>3) break;
				if (items.length>100000 && i>2) break;
				timeTaken=
					this.testOne("sorting."+sortTypes[i],items);
				retLine.append(","+timeTaken);
			}
			retLine.append("\n");
		}
		return retLine.toString();
		
	}
	
	public static void main(String[] args) {
		SortDemo sd = new SortDemo();
		Comparable[] items=sd.readData("test4b.dat");
		System.out.println(sd.testOne("sorting2014.QuickSort",items));
		
	//	sd.printSortedArray(items); 
//		System.err.println(Runtime.getRuntime().maxMemory());
//		System.out.println(sd.testAll("test6.dat"));
//		System.out.println(sd.testEverything());
//		System.out.println(sd.testOne("sorting.OptimisedQuickSort",items));
//		sd.printSortedArray(items);
	}
}
