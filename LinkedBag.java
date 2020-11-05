/**
 * A class of bags whose entries are stored in a chain of linked nodes
 * The bag is never full
 * @author Frank M. Carrano
 */
public class LinkedBag<T> implements BagInterface<T> {
	private Node firstNode;
	private int numberOfEntries;
	
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	}// end default constructor
	
	public int getCurrentSize() {
		return numberOfEntries;
	}//end getCurrentSize

	public boolean isEmpty() {
		return numberOfEntries ==0;
	}

	/**
	 * Adds a new entry to this bag/
	 * @param newEntry The object to be added as a new entry.
	 * @return True*/
	public boolean add(T newEntry) {
		//Add to beginning of chain
		Node newNode = new Node(newEntry);
		newNode.setNextNode(firstNode); // make new node reference rest of chain
		firstNode = newNode; //newNode is at beginning of chain
		numberOfEntries++;
		return true;
	}

	public T remove() {
		T result = null;
		if(firstNode != null) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode(); //Remove first node from chain
			numberOfEntries --;
		}//end if
		return result;
	}//end remove()

	public boolean remove(T anEntry) {
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);
		if(nodeN != null) {
			nodeN.setData(firstNode.getData());   //Replace located entry with entry
			                                      //in first Node
			firstNode = firstNode.getNextNode();  //Remove FirstNode
			numberOfEntries--;
			result = true;
		}//end if
		return result;
	}//end remove
	
	//Locates a given anEntry within this bag
	//Returns a reference to the Node containing the entry, if located.
	//or null otherwise
	private Node getReferenceTo(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found &&(currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNextNode();
		}//end while
		return currentNode;
	}//end getReferenceTo

	public void clear() {
		while(!isEmpty())
			remove();
	}//end clear
	/**
	 * Counts the number of times a given entry appears in this bag
	 * @param anEntry The entry to be counted
	 * @return The number of times anEntry appears in the bag
	 */
	public int getFrequencyOF(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		
		while((loopCounter < numberOfEntries) && (currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				frequency ++;
			loopCounter++;
			currentNode = currentNode.getNextNode();
		}//end while
		return frequency;
	}//end getFrequencyOF

	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while(!found &&(currentNode != null)) {
			if(anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = firstNode.getNextNode();
		}//end while
		return found;
	}//end found;

	/**
	 * Retrieves all entries that are in this bag
	 * @return A newly allocated array of all the entries in this bag*/
	public T[] toArray() {
		//The cast is safe because the new array contains null
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries]; //Unchecked cast
		int index = 0;
		Node currentNode = firstNode;
		while( (index < numberOfEntries) && (currentNode != null)){
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		}//end while
		return result;
	}//end toArray
	
	private class Node{
		private T data;
		private Node next;
		private Node(T dataPortion) {
			this(dataPortion, null);
		}// end constructor
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}//end constructors
		
		private T getData() {
			return data;
		}// end get data
		
		private void setData(T newData) {
			data = newData;
		}// end setData
		
		private Node getNextNode() {
			return next;
		}//end getNextNode
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}//end setNextNode
	}//end node

}
