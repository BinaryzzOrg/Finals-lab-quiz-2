public class CustomSet<Type> {
	// class fields
	private Object[] elements;
	private int size;
	private int defaultSize;

	// constructor
	public CustomSet() {
		defaultSize = 5;
		size = 0;
		elements = new Object[defaultSize];
	}// end constructor

	// getter setters
	public Object[] getElements() {
		return elements;
	}// end method

	public void setElements(Object[] elements) {
		this.elements = elements;
	}// end method

	public int getSize() {
		return size;
	}// end method

	public void setSize(int size) {
		this.size = size;
	}// end method

	// ==========SETS OPERATIONS==========//

	/**
	 * The Add method, Adds an element to the set after checking if it's already
	 * present. If the element is found, the provided prompt message is printed, and
	 * the method returns without adding the element again. Otherwise, the element
	 * is added to the set.
	 *
	 */
	public <T> void Add(T key, String prompt) {
		if (Contains(key)) {
			System.out.print(prompt);
			return;
		} // end if

		CheckArrayCapacity();
		elements[size++] = key;
	}// end method

	// overload for intersection method
	/*
	 * This method performs an add operation in the context of the Intersection
	 * method. It adds the specified key to the passed on set (A or B set) only if
	 * the key is found in in the pass on set (A or B set); otherwise, it prints the
	 * specified prompt.
	 */
	public <T> void Add(String prompt, T key, CustomSet<T> set) {
		if (Contains(key, set.getElements(), set.getSize())) {
			CheckArrayCapacity();
			elements[size++] = key;
			return;
		} // end if
		System.out.print(prompt);
	}// end method

	// overload for difference
	/*
	 * This add method is for the Difference operation. It checks if the key is
	 * present in set (A or B set), and if found, prints the provided prompt. If the
	 * key is not found, it adds the key to the current set.
	 */
	public <T> void Add(String prompt, CustomSet<T> set, T key) {
		// overload of Contains
		if (Contains(key, set.getElements(), set.getSize())) {
			System.out.print(prompt);
			return;
		} // end if

		CheckArrayCapacity();
		elements[size++] = key;
	}// end method

	/*
	 * The Remove method removes the specified key from the set. It iterates through
	 * the elements array to find the key. If the key is found, it sets the
	 * elementFound to true and then it calls the DeleteElement method, that takes
	 * in the current index. from there, it delete that index and moves all the
	 * right side elements to the left. If the key is not found, it prints a notice
	 * indicating that the element was not found in the set.
	 */
	public void Remove(Type key) {
		boolean elementFound = false;
		for (int index = 0; index < size; index++) {
			if (key.equals(elements[index])) {
				elementFound = true;
				DeleteElement(index);
				break;
			} // end if
		} // end for

		if (!elementFound) {
			//@formatter:off
			System.out.println("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Notice: \n" +
							"┇ The element " + key + " was not found in the set \n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			//@formatter:on
		} // end if
	}// end method

	// custom method
	/*
	 * The DeleteElement, Deletes an element from the array at the specified index.
	 * If the last element is to be deleted, It first check if the left of it is
	 * null and if that index is equal to the elements length. If it is, the program
	 * sets the last element to null. If any other element is to be deleted, it
	 * shifts elements from right to left to fill the gap.
	 */
	public void DeleteElement(int indexOutSide) {
		if (indexOutSide + 1 == elements.length) {
			elements[indexOutSide] = null;
			size--;
			return;
		} // end if

		/*
		 * if element to be deleted is anything BUT the last index. iterate, starting on
		 * the element that would get deleted
		 */
		for (int index = indexOutSide; index < size; index++) {
			elements[index] = elements[index + 1];
		} // end if
		size--;
	}// end method

	// Union
	/*
	 * This method performs the union operation on two sets A and B, merging all
	 * elements without duplicates into a new set C. The method uses a CustomSet to
	 * represent the resulting set.
	 */
	public <T> CustomSet<T> Union(T[] A, T[] B, int sizeOfA, int sizeOfB) {
		CustomSet<T> setC = new CustomSet<>();// create the setC

		for (int indexA = 0; indexA < sizeOfA; indexA++) {// iterate setA and put it on setC
			setC.Add(A[indexA], "");
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {// iterate setB ond put it on setC
			setC.Add(B[indexB], "");// each iteration, the add method handles the duplicates
		} // end for

		return setC;
	}// end method

	// Intersection
	/*
	 * Performs the intersection operation on sets A and B to create set C. Common
	 * elements present in both sets A and B are added to set C.
	 */
	public <T> CustomSet<T> Intersection(T[] A, T[] B, int sizeOfA, int sizeOfB) {
		CustomSet<T> tempSet = new CustomSet<>();// create tempSet to compare from
		CustomSet<T> setC = new CustomSet<>();// this is where the final results go

		for (int indexA = 0; indexA < sizeOfA; indexA++) {// iterate setA
			tempSet.Add(A[indexA], "");// add used here is the non overload
		} // end for

		for (int indexB = 0; indexB < sizeOfB; indexB++) {// iterate setB
			setC.Add("", B[indexB], tempSet);// this add is the overload add, and handles comparing
		} // end for

		// prints setC
		return setC;
	}// end method

	// Difference

	/*
	 * Performs the set difference operation on sets A and B to create set C.
	 * Elements in set A that are not present in set B are added to set C.
	 */
	public <T> CustomSet<T> Difference(T[] A, T[] B, int sizeOfA, int sizeOfB) {
		CustomSet<T> tempSet = new CustomSet<>();// create tempSet to compare from
		CustomSet<T> setC = new CustomSet<>();// this is where the final results go

		for (int indexB = 0; indexB < sizeOfB; indexB++) {// iterate set B
			tempSet.Add(B[indexB], "");// add used here is the non overload
		} // end for

		for (int indexA = 0; indexA < sizeOfA; indexA++) {// iterate set A
			setC.Add("", tempSet, A[indexA]);// this add is the overload add, and handles comparing
		} // end for

		return setC;
	}// end method

	// ==========OTHER METHODS USED==========//

	// contains method
	/*
	 * contains method Checks if the specified key is present in the elements array.
	 * It iterates through the elements array to check if the key is present. Check
	 * if the current element is equal to the provided key. If key the is found,
	 * return true and If key was not found in the loop, return false.
	 */
	public <T> boolean Contains(T key) {
		for (int index = 0; index < size; index++) {
			if (key == elements[index]) {
				return true;
			} // end if
		} // end for

		return false;
	}// end method

	// overload contains for intersection, difference.
	/*
	 * Contains overloaded method to check for the presence of an element in a
	 * specified set. The size of the set needs to be provided to perform the check.
	 * It iterates through the set to check for the presence of the specified
	 * element. If the element is found, return true otherwise, it returns false
	 */
	public <T> boolean Contains(T key, T[] set, int sizeOfSet) {
		for (int index = 0; index < sizeOfSet; index++) {
			if (key == set[index]) {
				return true;
			} // end if
		} // end for
		return false;
	}// end method

	// checks and expands the array
	/*
	 * This method checks if the array is full. If it is, it expands the array by
	 * creating a temporary array with double the size, copying existing elements to
	 * the temporary array, and then assigning the expanded array as the new
	 * elements array.
	 */
	public void CheckArrayCapacity() {
		if (elements.length == size) {
			Object[] tempArray = new Object[size * 2];

			for (int index = 0; index < size; index++) {
				tempArray[index] = elements[index];
			} // end for
			elements = tempArray;
		} // end if
	}// end method

	// displays the set elements
	/*
	 * Displays the elements of the set in a formatted manner. The displayed format
	 * includes a section header and each element enclosed in square brackets.
	 * Separate elements in a row using arrows, creating a visual representation of
	 * the set.
	 */
	public void Display(String set) {
		//@formatter:off
			System.out.print("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Display: Set "+ set +"\n"+
							"┇ ");
		//@formatter:on
		for (int index = 0; index < size; index++) {
			System.out.print("[" + elements[index] + "]" + " -> ");
		} // end for
//		System.out.print("(" + size + "/" + elements.length + ")\n");// optional
		System.out.print("\n⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
	}// end method
}// end class
