
public class ArrayUtilityDriver {
	
	public static void main(String[] args) {
		// Create an ArrayUtility object
		ArrayUtility au = new ArrayUtility();
		System.out.println("Created an ArrayUtility object. We expect"
				+ " the number of elements is 0 and the array is empty.");
		System.out.println("Test for getCurrentSize() and isEmpty() methods");
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is it empty?: " + au.isEmpty() + "\n");
		
		// Add an element, 0
		System.out.println("Test for add(anElement) method");
		System.out.println("Add an element, 0: " + au.add(0));
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is 0 there? " + au.contains(0) + "\n");
		
		// Check if indexOf(anElement) returns -1 when element not in container
		// and if contains(anElement) returns false
		System.out.println("Test for indexOf(anElement) and "
							+ "contains(anElement) methods");
		System.out.println("What is the index of 3? " + au.indexOf(3));
		System.out.println("Does the container contain 3? " + au.contains(3)
							+ "\n");
		
		// Add another element, 3, and check get(index) method and indexOf(anElement)
		// method
		System.out.println("Test for get(index) and indexOf(anElement) method");
		System.out.println("Add an element, 3: " + au.add(3));
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is 3 there? " + au.contains(3));
		System.out.println("Get the element at index 1: " + au.get(1));
		System.out.println("What is the index of 3? " + au.indexOf(3) + "\n");
		
		
		// Add another element 3, check getFrequencyOf() method
		System.out.println("Test getFrequencyOf(anElement)");
		System.out.println("Add another element, 3 " + au.add(3));
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("How many 3 elements are there? " + au.getFrequencyOf(3));
		System.out.println("How many 2 elements are there? " + au.getFrequencyOf(2));
		System.out.println("How many 1 elements are there? " + au.getFrequencyOf(1)
							+ "\n");
		
		// Add another element 5, at index[1] to test add(anElement, index) method
		System.out.println("Test add(anElement, index) method");
		System.out.println("Add another element, 5, at index 1: " + au.add(5, 1));
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is 5 there? " + au.contains(5));
		System.out.println("Get the element at index 1: " + au.get(1) + "\n");
		
		// Test clear method
		System.out.println("Test clear() method");
		System.out.println("Clear the container");
		au.clear();
		System.out.println("Is it empty? " + au.isEmpty());
		System.out.println("Number of elements: " + au.getCurrentSize() + "\n");
		
		// Test edge case: full container, can't add more to it
		System.out.println("Test edge case for both add methods: "
							+ "full container");
		for (int i = 0; i < au.getIntArray().length; i++) {
			System.out.println("Add " + i + " to the container: " + au.add(i));
		}
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Can we add another element to the full" +
							" container? " + au.add(5));
		System.out.println("Can we add another element at index 2 to the full" +
							" container? " + au.add(6,1));
		System.out.println("Clear the container");
		au.clear();
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is the container empty? " + au.isEmpty() + "\n");
		
		// Test edge case: remove from empty container
		System.out.println("Test edge case for all remove methods: "
							+ "empty container");
		System.out.println("Remove 0 from the container: " + au.remove(0));
		System.out.println("Remove the first element: " + au.removeFirst());
		System.out.println("Remove the last element: " + au.removeLast());
		System.out.println("Remove the middle element: " + au.removeMiddle()
							+ "\n");
		
		// Add elements to container, then test remove methods
		System.out.println("Test all remove methods");
		System.out.println("Add 4 to the container: " + au.add(4));
		System.out.println("Remove 4 from the container: " + au.remove(4));
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is 4 in the container? " + au.contains(4));
		// First element should be 0
		System.out.println("Add 0 to the container: " + au.add(0));
		System.out.println("Remove the first element: " + au.removeFirst());
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is 0 in the container? " + au.contains(0));
		System.out.println("Remove the first element: " + au.removeFirst());
		
		// Last element should be 9
		System.out.println("Add 1 to the container: " + au.add(1));
		System.out.println("Add 9 to the container: " + au.add(9));
		System.out.println("Remove the last element: " + au.removeLast());
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Is 9 in the container?: " + au.contains(9));
		System.out.println("Remove the last element: " + au.removeLast());
		
		// Middle element should be 1
		for (int i = 0; i < 3; i++) {
			System.out.println("Add " + i + " to the container " + au.add(i));
		}
		System.out.println("Middle element: " + au.get((au.getCurrentSize()-1)/2));
		System.out.println("Number of elements: " + au.getCurrentSize());
		System.out.println("Remove the middle element: " + au.removeMiddle());
		System.out.println("Is 1 in the container? " + au.contains(1));
		System.out.println("How many 1 elements are in the container? "
							+ au.getFrequencyOf(5));
		System.out.println("Number of elements: " + au.getCurrentSize() + "\n");
		
		// Clear container, fill it up again, then test reverse() method
		System.out.println("Clear the container");
		au.clear();
		for (int i = 0; i < au.getIntArray().length; i++) {
			System.out.println("Add " + i + " to the container: " + au.add(i));
		}
		System.out.println("Number of elements: " + au.getCurrentSize());
		// Create a copy of the container before reversing
		ArrayUtility copy = new ArrayUtility();
		for (int i = 0; i < au.getIntArray().length; i++) {
			copy.add(au.get(i));
		}
		au.reverse();
		// Check several of the items inside to make sure they match
		System.out.println("Is the container reversed? " 
							+ (copy.get(0) == au.get(9) &&
							   copy.get(1) == au.get(8)));
	}
}
