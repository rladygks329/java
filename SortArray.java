
public class SortArray<T> {
	public static <T extends Comparable<? super T>> 
		void selectionSort(T [] a, int n) 
	{
		for(int index = 0; index < n-1; index++)
		{
			int indexOfNextSmallest = getIndexOfSmallest(a,index,n-1);
			swap(a, index, indexOfNextSmallest);
		}
	}
	public static<T extends Comparable<? super T>>
		void insertionSort(T[] a, int first, int last) 
	{
		if(first < last) 
		{
			insertionSort(a,first,last-1);
			insertInOrder(a[last],a,first,last-1);
		}
	}
	private static<T extends Comparable<? super T>>
		void insertInOrder(T anEntry, T[] a, int begin, int end)
	{
		if(anEntry.compareTo(a[end])>-1) {
			a[end+1] = anEntry;
		}
		else if(begin < end)
		{
			a[end+1] = a[end];
			insertInOrder(anEntry, a, begin, end-1);
		}
		else {
			a[end+1]=a[end];
			a[end] = anEntry;
		}
	}
	private static <T extends Comparable<? super T>>
		int partition(T[] a, int first, int last)
		{
			int middle = first + (last-first)/2;
			
			//sort first middle last
			if(a[first].compareTo(a[middle]) == 1) {
				swap(a,first,middle);
			}
			if(a[first].compareTo(a[last]) == 1) {
				swap(a,first,last);
			}
			if(a[middle].compareTo(a[last]) == 1) {
				swap(a,middle,last);
			}
			
			// smaller middle larger
			//move pivot last-1
			swap(a,middle,last);
			int pivotIndex = last;
			T pivot = a[pivotIndex];
			
			int indexFromLeft = first+1;
			int indexFromRight = last-1;
			boolean done = false;
			while(!done) {
				while(a[indexFromLeft].compareTo(pivot) == -1)// -1 더 작을때
					indexFromLeft++;
				while(a[indexFromRight].compareTo(pivot) == 1)//1 더클때
					indexFromRight--;
				if(indexFromLeft < indexFromRight)
				{
					swap(a,indexFromLeft,indexFromRight);
					indexFromLeft++;
					indexFromRight--;
				}
				else
					done = true;
			}
			swap(a,pivotIndex,indexFromLeft);
			pivotIndex = indexFromLeft;
			return pivotIndex;
		}
	public static <T extends Comparable<? super T>>
		void quickSort(T[] a, int first, int last) 
	{
		if(last - first+1 < 3) {
			if(a[first].compareTo(a[last]) == 1) {
				swap(a,first,last);
			}
		}
		else{
			int pivotIndex = partition(a,first,last);
			quickSort(a,first,pivotIndex -1);
			quickSort(a,pivotIndex +1,last);
		}
	}
	private static <T extends Comparable<? super T>>
		int getIndexOfSmallest(T[] a, int first, int last)
	{
		T min = a[first];
		int indexOfMin = first;
		for(int i=first+1; i <= last; i++)
		{
			if(a[i].compareTo(min) < 0) 
			{
				min = a[i];
				indexOfMin = i;
			}
		}
		return indexOfMin;
	}
	static void swap(Object[] a, int i, int j) 
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}//end swap
}
