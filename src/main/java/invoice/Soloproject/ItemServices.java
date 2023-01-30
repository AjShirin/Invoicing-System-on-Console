package invoice.Soloproject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ItemServices {
	public static void Items() throws Throwable {
		List<String> menuItemsList = Arrays.asList(
				"==== Welcome to the Item Services Menue ==== \n" + "[1]  Add Items \n" + "[2]  Delete Items  \n"
						+ "[3]  Change Item Price\n" + "[4]  Report All Items \n" + "[5]  Go Back");
		for (String itemsMenu : menuItemsList) {
			System.out.println(itemsMenu);
			System.out.println("\n");
			System.out.println("Write the number of the option you want to choose:");
		}

		Scanner sc = new Scanner(System.in);
		boolean previous = true;

		do {

			int subMenu = sc.nextInt();
			switch (subMenu) {

			case 1:
				System.out.println("worked");

				break;

			case 2:

				break;

			case 3:

				break;

			// go back to the Main menu function
			case 4:
				previous = false;

				break;

			// If the user entered a number that is not in the menu this message will appear
			default:
				System.out.println(" No such option please enetr another number");
				break;

			}

		} while (previous);

	}
}
