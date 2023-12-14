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

	// add method
	public <T> void Add(T key, String prompt) {
		if (Contains(key)) {// check if key is available in set
			System.out.print(prompt);
			return;// return if it is
		} // end if

		CheckArrayCapacity();// calls method to expand object array
		// if key is not in set yet, add it to elements object array
		elements[size++] = key;
	}// end method

	// overload for intersection method
	/*
	 * basically a flipped add, where instead of skipping when a key is found, it
	 * adds it instead
	 */
	public <T> void Add(String prompt, T key, CustomSet<T> setTemp) {
		// this is the overload contains that needs the setsTemp elements and size
		if (Contains(key, setTemp.getElements(), setTemp.getSize())) {// if key is found in set
			CheckArrayCapacity();// handles the expanding of array
			elements[size++] = key;// add key to elements
			return;
		} // end if
			// if not found, print the prompt string
		System.out.print(prompt);
	}// end method

	// overload for difference
	/*
	 * this add method is like the non overload add but this needs the tempSet as
	 * parameter to compare to
	 */
	public <T> void Add(String prompt, CustomSet<T> setTemp, T key) {
		// overload of contains
		if (Contains(key, setTemp.getElements(), setTemp.getSize())) {// if key is found
			System.out.print(prompt);
			return;// return if found
		} // end if

		CheckArrayCapacity();// handles the expanding of array
		elements[size++] = key;// add key to elements
	}// end method

	// remove
	public void Remove(Type key) {
		boolean elementFound = false;
		for (int index = 0; index < size; index++) {
			System.out.println("key: " + key);
			System.out.println("Index: " + index + " element: " + elements[index]);
			if (key.equals(elements[index])) {
				System.out.println("It found it");
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
	public void DeleteElement(int indexOutSide) {
		// if the last element in the array is to be deleted
		if (indexOutSide + 1 == elements.length) {// check if index is out of bound
			elements[indexOutSide] = null;// make last element null
			size--;// decrease size
			return;// terminate method
		} // end if

		/*
		 * if element to be deleted is anything BUT the last index. iterate, starting on
		 * the element that would get deleted
		 */
		for (int index = indexOutSide; index < size; index++) {
			elements[index] = elements[index + 1];// move the elements of right side to left
		} // end if
		size--;// decrease size
	}// end method

	// Union
	// everything from A and B merged and put it to C. With no duplicates
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
	// elements that are both in A and B are put to set C
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
	// all elements in A not in B are put to set C
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
	public <T> boolean Contains(T key) {// check if key is available in set
		for (int index = 0; index < size; index++) {// iterate trough the elements array
			if (key == elements[index]) {// if key is found
				return true;// return true
			} // end if
		} // end for

		return false;// if key was not found, return false
	}// end method

	/*
	 * new parameter, the method needs to know the size of set that is using this
	 * method.
	 */
	// overload contains for intersection, difference.
	public <T> boolean Contains(T key, T[] set, int sizeOfSet) {
		for (int index = 0; index < sizeOfSet; index++) {// iterate trough the elements array
			if (key == set[index]) {
				return true;
			} // end if
		} // end for
		return false;
	}// end method

	// checks and expands the array
	public void CheckArrayCapacity() {
		if (elements.length == size) {// if array is full
			Object[] tempArray = new Object[size * 2];// expand it

			for (int index = 0; index < size; index++) {// iterate to the array
				tempArray[index] = elements[index];// put the elements on the temporary expanded array
			} // end for
			elements = tempArray;// make the expanded array be the new elements
		} // end if
	}// end method

	// displays the set elements
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
