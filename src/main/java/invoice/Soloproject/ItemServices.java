package invoice.Soloproject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ItemServices {
	public static void Items() throws Throwable {
		
		boolean goPrevious = true;
		
		do {
		List<String> menuItemsList = Arrays.asList(
				"==== Welcome to the Item Services Menue ==== \n" + " 1)  Add Items \n" + " 2)  Delete Items  \n"
						+ " 3)  Change Item Price \n" + " 4)  Report All Items \n" + " 5)  Go Back");
		for (String itemsMenu : menuItemsList) {
			System.out.println(itemsMenu);
			System.out.println("\n");
			System.out.println("Write the number of the option you want to choose:");
		}

		Scanner scanner = new Scanner(System.in);
	

			int itemMenuChoice = scanner.nextInt();
			switch (itemMenuChoice) {

			// Add Items based on user input
			case 1:
				InsertValues.addItems();

				break;

			// Delete Items by user Input where they select the item ID
			case 2:
				DeleteValue.deletePoductById();

				break;

			case 3:
				UpdateItemPrice.updateItemPriceById();

				break;

			case 4:

				break;

			// go back to the Main menu function
			case 5:
				goPrevious = false;

				break;

			// If the user entered a number that is not in the menu this message will appear
			default:
				System.out.println(" No such option please enetr another number");
				break;

			}

		} while (goPrevious);

	}
}
