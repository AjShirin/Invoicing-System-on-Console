package invoice.Soloproject;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {

	// creating function for the main menu
	public static void Mainmenu() {
		List<String> menu = Arrays.asList("==== Welcome to the Main Menu ==== \n" + " 1)  Create all Tables \n"
				+ " 2)  Shop Settings \n" + " 3)  Manage Shop Items  \n" + " 4)  Create New Invoice \n"
				+ " 5)  Report: Statistics (No Of Items, No of Invoices, Total Sales)\n"
				+ " 6)  Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance)\n"
				+ " 7)  Search (1) Invoice (Search by Invoice No and Report All Invoice details with items)\n"
				+ " 8)  Program Statistics (Print each Main Menu Item with how many number selected)\n" + " 9)  Exit");

		for (String bigmenu : menu) {
			System.out.println(bigmenu);
			System.out.println("\n");
			System.out.println("Write the number of the option you want to choose:");
		}
	}

	public static void main(String[] args) throws Throwable {

		Scanner scanner = new Scanner(System.in);

		do {
			Mainmenu();

			int Menu = scanner.nextInt();
			switch (Menu) {
			
			
			case 1:
				
				// creating Item table in sql.
				createTables.createItemTable();
				
				// creating Customer table in sql.
				createTables.createCustomerTable();
				
				// creating Shop table in sql.
				createTables.createShopTable();
				
				// creating Invoice table in sql.
				createTables.createInvoiceTable();
								
			break;

			// Since the function is static no need for creating object for the class.
			// Go to Shop Settings.
			case 2:
				ShopServices.shop();
				break;

			// go to Manage Shop Items
			case 3:
				ItemServices.Items();
				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;

			case 7:

				break;

			case 8:

				break;

			case 9:

				break;
		
			// If the user entered a number that is not in the menu this message will appear
			default:
				System.out.println(" No such option please enetr another number");
				break;

			}

		} while (true);

	}
}
