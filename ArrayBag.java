

import java.util.Arrays;

public class ArrayBag<T> implements BagInterface<T> {
	
	private T[] bag;
	private int numberOfEntries;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 1000;
	
	
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	public ArrayBag(int desiredCapacity) {
		if(desiredCapacity <= MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempbag = (T[])new Object[desiredCapacity];
			bag = tempbag;
			numberOfEntries = 0;
			initialized = true;
		}
		else
			throw new IllegalStateException("Attemp to create bag"+
					"whose capacity exceeds "+
					"allowed maximum");
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}
	
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	public boolean add(T newEntry) {
		checkInitialization();
		if(isArrayFull()) {
			doubleCapacity();
		}
		else {//assertion result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return true;
	}//end add
	
	public T remove() {
		checkInitialization();
		T result = removeEntry(numberOfEntries -1);
		return result;
	}
	
	public boolean remove(T anEntry) {
		checkInitialization();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}
	
	public void clear() {
		checkInitialization();
		while(!isEmpty()) {
			remove();
		}
	}//end clear
	
	public int getFrequencyOF(T entry) {
		checkInitialization();
		int counter = 0;
		for(int index = 0; index < numberOfEntries; index++) {
			if(entry.equals(bag[index])) {
				counter += 1;
			}//end if
		}//end for
		return counter;
	}//end getFrequencyOf
	
	public boolean contains(T entry) {
		checkInitialization();
		return getIndexOf(entry) > -1;
	}
	/** Retirves all entries that are in this bag
	 * @return A newly allocated array of all the entries in the bag
	 */
	public T[] toArray() {
		//the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for( int index =0; index<numberOfEntries; index++) {
			result[index] = bag[index];
		}
		return result;
	}
	
	//Return true if bag is full. or false if not
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	}
	private void checkInitialization() {
		if(!initialized) {
			throw new SecurityException("ArrayBag object is not initialized"+
					"properly");
		}
	}
	private int getIndexOf(T anEntry) {
		checkInitialization();
		int where = -1;
		int index = 0;
		boolean stillLooking = true;
		while(stillLooking && (index < numberOfEntries)) {
			if(anEntry.equals(bag[index])) {
				stillLooking = false;
				where = index;
			}//end if
			index++;
		}//end while
		//assertion if where is in the array bag, and it
		//equals bag[where]; otherwise anEntry is not the array
		return where;
	}//end get indexOF
	
	private T removeEntry(int givenIndex) {
		T result = null;
		if((givenIndex >= 0) && !isEmpty()) {
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries-1];
			
			bag[numberOfEntries-1] = null;
			numberOfEntries--;
		}//end if
		return result;
	}//end T removeEntry(givenIndex)
	
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a bag whose "+
					"capacity exeeds allowed " +
					"maxinum of " + MAX_CAPACITY); 
		}
	}
	
	private void doubleCapacity() {
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
		
	}
}//end ArrayBag
