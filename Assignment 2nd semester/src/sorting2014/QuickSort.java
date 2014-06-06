package sorting2014;

//Code referenced & edited from stackoverfmin.com

public class QuickSort implements Sorter {
	
	@SuppressWarnings("unchecked")
	public void sort(Comparable[] items, int cutoff)
	{
		quickSort(items, 0 , items.length-1);
	}
	private static int partition(Comparable[] items, int f, int l) {
		Comparable pivot = items[f];//Here the pivot is made to then compare it to the values 
	    int min = f + 1;
	    int max = l;

	    while (max > min) {
//It is comparing the small values to the pivot
	        while (min < max && items[min].compareTo(pivot) < 0) {
	            min++;
	        }

//it is comaring the big values to the pivot
	        while (min < max && items[max].compareTo(pivot) >= 0) {
	            max--;
	        }


	        if (max > min) {
	            Comparable temp = items[max];
	            items[max] = items[min];
	            items[min] = temp;
	        }
	    }
	    while (max > f && items[max].compareTo(pivot) >= 0) {
	        max--;
	    }

	    if (pivot.compareTo(items[max]) > 0) {
	        items[f] = items[max];
	        items[max] = pivot;
	        return max;
	    } else {
	        return f;
	    }

	}

	private static void quickSort(Comparable[] items, int f, int l) {
	    if (l > f) {
	        int pivotIndex = partition(items, f, l);
	        quickSort(items, f, pivotIndex - 1);
	        quickSort(items, pivotIndex + 1, l);
	    }
	}
	}