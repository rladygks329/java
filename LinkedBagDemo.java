/**
 * A test of the method add, toArray, isEmpty, and getCurrentSize,
 * as defined in the first draft of the class LinkedBag
 * @author rladygks329
 */
public class LinkedBagDemo {
	public static void main(String [] args) {
		System.out.println("Creating empty bag.");
		BagInterface<String> aBag = new LinkedBag<>();
		testIsEmpty(aBag, true);
		displayBag(aBag);
		
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
	}// end main
	//tests the method isEmpty
	//Precondition: IF the bag is empty, the parameter empty should be true;
	//otherwise it should be false
	private static void testIsEmpty(BagInterface<String> bag, boolean empty) {
		System.out.print("\nTesting is Empty with ");
		if(empty)
			System.out.println("an Empty bag: ");
		else
			System.out.println("a bag that is not empty");
		
		System.out.println("isEmpty finds the bag");
		if(empty && bag.isEmpty())
			System.out.println("empty is Ok");
		else if(empty)
			System.out.println("not empty, but it is: Error.");
		else if(!empty && bag.isEmpty())
			System.out.println(" empty, but it is not Error. ");
		else
			System.out.println("not Empty: OK.");
	}// end testIsEmpty
	
	private static void testAdd(BagInterface<String>aBag, 
			String[] contents) 
	{
		System.out.println("Adding the following " + contents.length + " stings to bag: ");
		for (int index = 0; index < contents.length; index++) {
			if(aBag.add(contents[index])) {
				System.out.print(contents[index] + " ");
			}
			else
				System.out.println("\nUnable to add "+ contents[index] + " to the bag");
		}
		displayBag(aBag);
	}
	//Tests the method toArray while displaying the bag
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains the following strings(s): ");
		Object[] bagArray = aBag.toArray();
		for(int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		}
		System.out.println();
	}
}
