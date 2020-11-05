public class ArratBagDemo {

	public static void main(String[] args) {
		//adding to an initiallay empty bag with sufficient capacity
		System.out.println("Testing an initially empty bag with"+
					"the capacity to hold at least 6 strings: ");
		BagInterface<String> aBag = new ArrayBag<>();
		String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
		testAdd(aBag, contentsOfBag1);
		
		//Filling an initially empty bag to capacity
		System.out.println("\ntesting an initially empty bag that " + "will be filled to capacity: ");
		aBag = new ArrayBag<>(7);
		String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
		testAdd(aBag, contentsOfBag2);
		
	}
	//test add
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
