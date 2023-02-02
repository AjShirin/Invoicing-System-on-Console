package invoice.Soloproject;

import java.util.Scanner;

public class ItemServices {
	public static void Items() throws Throwable {
		
		boolean closeMenuItemList = true;
		
		do {
			Scanner scanner = new Scanner(System.in);
		
			Menu.showChoice(3);
			System.out.println("Write the number of the option you want to choose:");
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

			// Change Item Price By User Input
			case 3:
				UpdateItemPrice.updateItemPriceById();

				break;

			// Report All Items
			case 4:
				PrintValues.reportAllItems();

				break;

			// go back to the Main menu function
			case 5:
				closeMenuItemList = false;

				break;

			// If the user entered a number that is not in the menu this message will appear
			default:
				System.out.println(" No such option please enetr another number");
				break;

			}

		} while (closeMenuItemList);

	}
}
