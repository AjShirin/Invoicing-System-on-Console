package invoice.Soloproject;

import java.util.Scanner;

public class ShopServices {
	public static void shop() throws Throwable {

		boolean closeMenuShopList = true;

		do {
			Scanner scanner = new Scanner(System.in);
			
			Menu.showChoice(2);
			System.out.println("Write the number of the option you want to choose:");
			int shopMenuChoice = scanner.nextInt();
		
	
			switch (shopMenuChoice) {

			// Insert Shop Detail With user Input.
			case 1:
				InsertValues.insertShop();
				break;

			// Insert Item Detail With user Input.
			case 2:
				InsertValues.insertItem();
				break;

			// Load for Customer details with user Input
			case 3:
				InsertValues.insertCustomerDetails();

				break;

			// Load for Invoice details with user Input
			case 4:
				InsertValues.insertInvoiceDetails();

				break;

			// Set Shop Name
			case 5:
				InsertValues.insertShop();
				break;

			// Set Invoice Header (Tel / Fax / Email / Website)
			case 6:
				InsertValues.insertInvoiceHeaderDetail();
				
				break;

			// go back to the Main menu function
			case 7:
				closeMenuShopList = false;

				break;

			// If the user entered a number that is not in the menu this message will appear
			default:
				System.out.println(" No such option please enetr another number");
				break;
			}

		} while (closeMenuShopList);

	}
}
