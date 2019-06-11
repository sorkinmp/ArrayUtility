/**
 * 
 * @author Matthew Sorkin
 * @version 1.0
 * 
 * 
 */

public class ArrayUtility implements UtilityInterface<Integer> {

	// Variables
	private Integer[] intArray;
	private int last = 0;
	public static final int DEFAULT_CAPACITY = 10;

	// Constructors

	/**
	 * Default constructor which initializes the
	 * array with the default capacity.
	 */
	public ArrayUtility() {
		intArray = new Integer[DEFAULT_CAPACITY];
	}

	/**
	 * Parameterized constructor which initializes
	 * the array with the specified capacity
	 * @param capacity - an integer that describes
	 * the desired size of the array.
	 */
	public ArrayUtility(int capacity) {
		intArray = new Integer[capacity];
	}

	// Methods

	/**
	 * Gets the current number of elements in the array
	 * @return An integer, number of elements currently 
	 * in the array
	 */
	@Override
	public int getCurrentSize() {
		return last;
	}

	/**
	 * Checks whether the array is empty
	 * @return True if the array is empty (has no elements)
	 * and false otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (last > 0) {
			return false;
		}
		return true;
	}

	/**
	 * Checks whether the array has the specified element
	 * @param anElement - the given integer (element)
	 * @return True if the array contains anElement, and
	 * false otherwise
	 */
	@Override
	public boolean contains(Integer anElement) {
		for(int i = 0; i < intArray.length; i++) {
			if (anElement.equals(intArray[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the object at the specified index
	 * @param index - an integer index of the array
	 * @return The object at the specified index if it is
	 * a valid index, and null otherwise
	 */
	@Override
	public Integer get(int index) {
		if (intArray[index] != null) {
			return intArray[index];
		}
		return null;
	}

	/** 
	 * Gets the index of first occurrence of the specified
	 * element in the array
	 * @param anElement - the given object (element)
	 * @return An integer, index in the array if found,
	 * and -1 otherwise
	 */
	@Override
	public int indexOf(Integer anElement) {
		for (int i = 0; i < last; i++) {
			if (intArray[i] != null) {
				if (intArray[i].equals(anElement)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Find the frequency of a given element
	 * @param anElement - the given object (element)
	 * @return The total number of times the given element
	 * is in the array
	 */
	@Override
	public int getFrequencyOf(Integer anElement) {
		int count = 0;
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] != null) {
				if (intArray[i].equals(anElement)) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Adds an element to the first available
	 * location/index of the array
	 * @param anElement - the element to add to the array
	 * @return True, if it can add the element to the array.
	 * False, otherwise
	 */
	@Override
	public boolean add(Integer anElement) {
		if (intArray.length == last) {
			return false;
		}
		// Add to last space
		intArray[last] = anElement;
		last++;
		return true;
	}

	/**
	 * Adds an element to the specified location/index of the array.
	 * If it is already occupied then shift the elements to
	 * the right by one position and add the new element.
	 * @param anElement - the element to add to the array
	 * @param index - the index or location to add the element
	 * @return True, if it can add the element to the array.
	 * False, otherwise.
	 */
	@Override
	public boolean add(Integer anElement, int index) {
		// False if array is full
		if (last == intArray.length) {
			return false;
		}
		// True if index has nothing in it and can be added
		// If true, this should be the index of "last" variable
		if (intArray[index] == null) {
			intArray[index] = anElement;
			last++;
			return true;
		}
		for (int i = index; i < intArray.length-1; i++) {
			intArray[i+1] = intArray[i];
		}
		intArray[index] = anElement;
		last++;
		return true;
	}

	/**
	 * Removes the first occurrence of the specified element.
	 * If it is not the last element then you have to shift
	 * all the elements after 'index' to the left by one
	 * position to make sure that there are no empty space
	 * between the elements.
	 * @param anElement - the element to remove from the array.
	 * @return True, if it can remove the element from the array.
	 * False, otherwise.
	 */
	@Override
	public boolean remove(Integer anElement) {
		// If the array is empty
		if (isEmpty()) {
			return false;
		}
		// If it doesn't contain anElement
		if (!contains(anElement)) {
			return false;
		}
		if (indexOf(anElement) == intArray.length-1) {
			intArray[intArray.length-1] = null;
		}
		int removed = indexOf(anElement);
		for (int i = removed; i <= last; i++) {
			intArray[i] = intArray[i+1];
		}
		last--;
		return true;
	}

	/**
	 * Removes the first element from the array if there is any.
	 * @return True, if it can remove the first element from the array.
	 * False, otherwise.
	 */
	@Override
	public boolean removeFirst() {
		// If array is empty
		if (isEmpty()) {
			return false;
		}
		// Remove first element
		if (last == 1) {
			intArray[0] = null;
			last--;
			return true;
		}
		// Shift elements so no blank spaces in between
		intArray[0] = null;
		for (int i = 0; i < last-1; i++) {
			intArray[i] = intArray[i+1];
		}
		last--;
		return true;
	}

	/**
	 * Removes the last element from the array if there is any.
	 * @return True, if it can remove the last element from the array.
	 * False, otherwise.
	 */
	@Override
	public boolean removeLast() {
		// If its empty
		if (isEmpty()) {
			return false;
		}
		intArray[last-1] = null;
		last--;
		return true;
	}

	/**
	 * Removes the middle element from the array if there is any.
	 * If the number of elements is even then it removes the element
	 * at index = (number of elements-1)/2. If there are 6 elements
	 * in the array then it removes the element at index (6-1)/2=2
	 * (integer division).
	 * @return True, if it can remove the middle element from the array.
	 * False, otherwise.
	 */
	@Override
	public boolean removeMiddle() {
		// If array is empty
		if (isEmpty()) {
			return false;
		}
		if (last == 1) {
			intArray[0] = null;
			last--;
			return true;
		}
		int middle = (last-1)/2;
		// Replace middle with null, shift elements to the left
		intArray[middle] = null;
		for (int i = middle + 1; i < last; i++) {
			intArray[i-1] = intArray[i];
		}
		last--;
		return true;
	}

	/**
	 * Reverses the current order of the elements in the array.
	 */
	@Override
	public void reverse() {
		Integer[] intArrayReverse = new Integer[intArray.length];
		for (int i = 0, j = last-1; i < last && j > -1; i++, j--) {
			intArrayReverse[i] = intArray[j];
		}
		for (int i = 0; i < last; i++) {
			intArray[i] = intArrayReverse[i];
		}
	}

	/**
	 * Removes all elements from the array.
	 */
	@Override
	public void clear() {
		// Loop to clear array
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = null;
		}
		last = 0;
	}

	/**
	 * Gets the array from the intArray object
	 * @return the array
	 */
	public Integer[] getIntArray() {
		return intArray;
	}
}
