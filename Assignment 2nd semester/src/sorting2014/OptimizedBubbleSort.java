package sorting2014;



	public class OptimizedBubbleSort implements Sorter {

		
		@SuppressWarnings("unchecked")
		public void sort(Comparable[] items, int cutoff) {
			Comparable temp;
			boolean opt = false;
			for (int i=0; i<items.length-1; i++)
			{
				opt=false;
				for (int j=0; j<items.length-1-i; j++)
				{
					if (items[j].compareTo(items[j+1])>0)
					{
						temp=items[j+1];
						items[j+1]=items[j];
						items[j]=temp;
						opt = true;
					}
				}
				if (opt == false)
				{
					break;
				}
			}
			
		}
	}


