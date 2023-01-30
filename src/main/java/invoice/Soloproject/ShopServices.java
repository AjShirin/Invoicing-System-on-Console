package invoice.Soloproject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShopServices {
	public static void shop() throws Throwable {

		boolean goPrevious = true;

		do {
			List<String> menueShopList = Arrays.asList("==== Welcome to the Shop Services Menu ==== \n "
					+ "1)  Load Data for Shop Details \n" + " 2) Load Data for Item details \n"
					+ " 3) Load for Customer details \n" + " 4) Load for Invoice details \n" + " 5)  Set Shop Name \n"
					+ " 6)  Set Invoice Header (Tel / Fax / Email / Website) \n" + " 7)  Go Back");

			for (String shopSmallMenu : menueShopList) {
				System.out.println(shopSmallMenu);
				System.out.println("\n");
				System.out.println("Write the number of the option you want to choose:");
			}

			Scanner scanner = new Scanner(System.in);

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
