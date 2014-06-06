package sorting2014;

public class SelectionSort implements Sorter {
	
	@SuppressWarnings("unchecked")
	public void sort(Comparable[] items, int cutoff)
	{
		Comparable t;
		
	  for (int i=items.length-1; i>0; i--)
	  {
		  int min = 0;
		  int j;
		  //makes array and then only sorts though data that has not been sorted until
		  //it can't move values anymore
		  for (j = 1; j <=i; j++)
		  {
			  if (items[j].compareTo(items[min]) > 0)
			  {
				  min = j;
			  }
		  }
	  t = items[min];
	  items[min] = items[i];
	  items[i] = t;
	  }
	}
}