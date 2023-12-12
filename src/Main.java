import java.util.Scanner;

public class Main {

	private static CustomSet<Integer> setA = new CustomSet<>();
	private static CustomSet<Integer> setB = new CustomSet<>();
	private static CustomSet<Object> setC = new CustomSet<>();
	private static CustomSet<CustomSet<Integer>> setOps = new CustomSet<>();

	public static void main(String[] args) {
		SetPicker();
	}// end main

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
