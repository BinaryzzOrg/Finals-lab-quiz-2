import java.util.Scanner;

public class Main {

	// class fields
	private static CustomSet<Integer> setA = new CustomSet<>();
	private static CustomSet<Integer> setB = new CustomSet<>();
	private static CustomSet<Object> setC = new CustomSet<>();
	private static CustomSet<CustomSet<Integer>> setOps = new CustomSet<>();

	public static void main(String[] args) {
		SetPicker();// calls the SetPicker method at the start of program
	}// end main

	/*
	 * The setPicker method, calls the PrintSetPicker method that prints out the
	 * choices for the user to choose on. This method scans the user input to see if
	 * the user wants to modify set A,set B, or do the sets operations like the
	 * union and difference...
	 * 
	 * This method also handles the missinputs of the user and loops the method if
	 * it detects one.
	 */
	public static void SetPicker() {
		System.out.print(PrintSetPicker());

		switch (CheckUserInput(PrintSetPicker())) {
		case 1:
			MenuChoices(setA, true, false);
			break;
		case 2:
			MenuChoices(setB, false, true);
			break;
		case 3:
			SetOperation();
			break;
		case 4:// exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		default:
			// @formatter:off
			System.out.println("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Error:			    ┇\n" +
							"┇ Input is not a valid Set Choices. ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Msg: 				    ┇\n" +
							"┇ \033[3mPlease enter only 1 to 4 as input\033[0m	┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			// @formatter:on
			break;
		}// end switch

		SetPicker();
	}// end method

	/*
	 * The MenuChoices method contains the following operations: add, remove,
	 * display, back, exit. The method, receives the parameters, set, isSetA, and
	 * isSetB for the operations to use.
	 * 
	 * This method calls the PrintMenuChoices that prints out the choices for
	 * modifying the elements of the set that is choosen by the user.
	 * 
	 * MenuChoices method also handles missinputs of the user and loops if it
	 * detects one.
	 */
	public static void MenuChoices(CustomSet<Integer> set, boolean isSetA, boolean isSetB) {
		System.out.print(PrintMenuChoices());

		switch (CheckUserInput(PrintMenuChoices())) {
		case 1:// add
			System.out.print("Enter key to add 》 ");

			//@formatter:off
			set.Add(CheckUserInput("Enter Key to add 》 "), "\n" +
									"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
									"┇ Notice:			   ┇\n" +
									"┇ \033[3mElement is already in the set.\033[0m    ┇\n" +
									"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
			//@formatter:on
			set.Display();
			break;
		case 2:// remove
			if (set.getSize() <= 0) {
				//@formatter:off
				System.out.println("\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
								"┇ Notice:			   ┇\n" +
								"┇ \033[3mSet is already empty.\033[0m	   ┇\n" +
								"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
				//@formatter:on
				break;
			} // end if

			System.out.print("Enter key to remove 》 ");
			set.Remove(CheckUserInput("Enter key to remove 》 "));
			set.Display();
			break;
		case 3:// display
			set.Display();
			break;
		case 4:// <- back
			return;
		case 5:// exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		default:
			// @formatter:off
			System.out.println("\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Error:			    ┇\n" +
							"┇ Input is not a valid Menu choice. ┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
							"┇ Msg: 				    ┇\n" +
							"┇ \033[3mPlease enter only 1 to 5 as input\033[0m	┇\n" +
							"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			// @formatter:on
			break;
		}// end switch

		if (isSetA) {
			MenuChoices(setA, isSetA, isSetB);
		} else {
			MenuChoices(setB, isSetA, isSetB);
		} // end if else
	}// end method

	/*
	 * SetOperation method handles the operations: union, intersection, and
	 * difference. This method first checks to see if set A OR set B is empty, if it
	 * is, this method wont run. next it calls the PrintSetOperations method that
	 * prints out the choices of operations that the user is able to choose and do.
	 * 
	 * This method also can handle missinputs and loops when it detects one. It also
	 * returns each operations results and puts it on another CustomSet class called
	 * setC, which is called in the printSets method.
	 * 
	 */
	public static void SetOperation() {
		if (IsSetEmpty()) {
			return;
		} // end if

		System.out.print(PrintSetOperations());

		switch (CheckUserInput(PrintSetOperations())) {
		case 1:// union
			setC = setOps.Union(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			printSets("Union");
			break;
		case 2:// intersection
			setC = setOps.Intersection(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			printSets("Intersection");
			break;
		case 3:// difference
			setC = setOps.Difference(setA.getElements(), setB.getElements(), setA.getSize(), setB.getSize());
			printSets("Difference");
			break;
		case 4:// <- back
			return;
		default:
			System.out.println("invalid input");
			break;
		}// switch

		SetOperation();
	}// end method

	/*
	 * Now this methods function is simple, it basically scans the input of user and
	 * firsts check if it is an integer, once that is confirmed by the condition,
	 * this integer input will now be stored in the key variabale and sent back to
	 * the other method that is using this CheckUserInput.
	 * 
	 * Now if the input was not an int then it would print out an error, and tells
	 * the user to enter an integer value next time. The prompt parameter is for
	 * different scenarios of printing needed for certain menus.
	 */
	public static int CheckUserInput(String prompt) {
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextInt()) {
			int key = sc.nextInt();
			return key;
		} // end if

		// @formatter:off
			System.out.println("\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Error:			    ┇\n" +
						"┇ Input is not an integer value.    ┇\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Msg: 				    ┇\n" +
						"┇ \033[3mPlease enter integer/s input only\033[0m	┇\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
		// @formatter:on
		System.out.print(prompt);
		return CheckUserInput(prompt);
	}// end if

	/*
	 * This method simply returns a string of the menu for choosing a set that the
	 * user also sees on the first time they run the code. This method is also seen
	 * passed on, in parameters of methods that uses the String prompt.
	 */
	public static String PrintSetPicker() {
		String SetPickerAsString =
		//@formatter:off
				 		"\n" + 
						"{Choose a Set/Operations}\n"+ 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Set A		┃\n" +
						"┃ 【 2 】 Set B 		┃\n" + 
						"┃ 【 3 】 Set Operations 	┃\n" + 
						"┃ 【 4 】 Exit 		┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ";
		//@formatter:on
		return SetPickerAsString;
	}// end method

	/*
	 * This method, like the one at the top, also just returns a menu of operations
	 * that the user chooses on when modifying sets elements
	 */
	public static String PrintMenuChoices() {
		String MenuChoicesAsString =
		//@formatter:off
						"\n" + 
						"  {Normal Operations}\n"+ 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Add		┃\n" +
						"┃ 【 2 】 Remove 		┃\n" + 
						"┃ 【 3 】 Display 		┃\n" + 
						"┃ 【 4 】 <- Back 		┃\n" + 
						"┃ 【 5 】 Exit 		┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ";
		//@formatter:on
		return MenuChoicesAsString;
	}// end method

	/*
	 * This method, like the others above, also returns a string of menu that is
	 * used to show user what Sets Operations they can use.
	 */
	public static String PrintSetOperations() {
		String SetOperations =
		//@formatter:off
						"\n" + 
						"	{Sets Operations}\n"+ 
						"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
						"┃ 【 1 】 Union (A ∪ B)          ┃\n" +
						"┃ 【 2 】 Intersection (A ∩ B)   ┃\n" + 
						"┃ 【 3 】 Difference (A − B)     ┃\n" +
						"┃ 【 4 】 <-Back                 ┃\n" + 
						"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
						"》 ";
		//@formatter:on
		return SetOperations;
	}// end method

	/*
	 * printSets is used when printing the results of the Sets Operations This
	 * method prints Set A elements, Set B elements and the result of the operation,
	 * Set C.
	 */
	public static void printSets(String prompt) {

		// @formatter:off
			System.out.print("\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ \033[3mSet Operation: " + prompt + "\033[0m\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
		// @formatter:on
		System.out.print("Set A: ");
		setA.Display();
		System.out.print("Set B: ");
		setB.Display();
		System.out.print("Set C: ");
		setC.Display();
	}// end method

	/*
	 * This method returns a string and that is used for error printing, it prints
	 * the warning if the user tried to use Sets Operations and Set A or Set B is
	 * empty. It tells the user what set is empty and tells them to add elements to
	 * that specific set.
	 */
	public static String PrintSetIsEmpty(String set) {
		String SetsIsEmpty =
		// @formatter:off
					"\n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Error:			     ┇\n" +
					"┇ Set " + set + " is empty. 		     ┇\n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Msg: 				     ┇\n" +
					"┇ \033[3mPlease add elements in set " + set + " first\033[0m	┇\n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n";
				// @formatter:on
		return SetsIsEmpty;
	}// end method

	/*
	 * IsSetEmpty is used to check set A and B if they are empty, if they are then
	 * return true, if not then return false. It calls the PrintSetIsEmpty method
	 * and pass in the string A or B for the PrintSetIsEmpty to use and indicate in
	 * the error printing which set is empty.
	 */
	public static boolean IsSetEmpty() {
		if (setA.getSize() == 0) {
			System.out.print(PrintSetIsEmpty("A"));
			return true;
		} else if (setB.getSize() == 0) {
			System.out.print(PrintSetIsEmpty("B"));
			return true;
		} // end

		return false;
	}// end method

}// end class
