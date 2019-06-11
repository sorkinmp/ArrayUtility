

public interface UtilityInterface <T> {
	
	/**
	 * Gets the current number of elements in the array
	 * @return An integer, number of elements currently 
	 * in the array
	 */
	public int getCurrentSize();
	
	/**
	 * Checks whether the array is empty
	 * @return True if the array is empty (has no elements)
	 * and false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Checks whether the array has the specified element
	 * @param anElement - the given object (element)
	 * @return True if the array contains anElement, and
	 * false otherwise
	 */
	public boolean contains(T anElement);
	
	/**
	 * Gets the object at the specified index
	 * @param index - an integer index of the array
	 * @return The object at the specified index if it is
	 * a valid index, and null otherwise
	 */
	public T get(int index);
	
	/** 
	 * Gets the index of first occurrence of the specified
	 * element in the array
	 * @param anElement - the given object (element)
	 * @return An integer, index in the array if found,
	 * and -1 otherwise
	 */
	public int indexOf(T anElement);
	
	/**
	 * Find the frequency of a given element
	 * @param anElement - the given object (element)
	 * @return The total number of times the given element
	 * is in the array
	 */
	public int getFrequencyOf(T anElement);
	
	/**
	 * Adds an element to the first available
	 * location/index of the array
	 * @param anElement - the element to add to the array
	 * @return True, if it can add the element to the array.
	 * False, otherwise
	 */
	public boolean add(T anElement);
	
	/**
	 * Adds an element to the specified location/index of the array.
	 * If it is already occupied then shift the elements to
	 * the right by one position and add the new element.
	 * @param anElement - the element to add to the array
	 * @param index - the index or location to add the element
	 * @return True, if it can add the element to the array.
	 * False, otherwise.
	 */
	public boolean add(T anElement, int index);
	
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
	public boolean remove(T anElement);
	
	/**
	 * Removes the first element from the array if there is any.
	 * @return True, if it can remove the first element from the array.
	 * False, otherwise.
	 */
	public boolean removeFirst();
	
	/**
	 * Removes the last element from the array if there is any.
	 * @return True, if it can remove the last element from the array.
	 * False, otherwise.
	 */
	public boolean removeLast();
	
	/**
	 * Removes the middle element from the array if there is any.
	 * If the number of elements is even then it removes the element
	 * at index = (number of elements-1)/2. If there are 6 elements
	 * in the array then it removes the element at index (6-1)/2=2
	 * (integer division).
	 * @return True, if it can remove the middle element from the array.
	 * False, otherwise.
	 */
	public boolean removeMiddle();
	
	/**
	 * Reverses the current order of the elements in the array.
	 */
	public void reverse();
	
	/**
	 * Removes all elements from the array.
	 */
	public void clear();
}
