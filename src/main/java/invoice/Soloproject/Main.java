package invoice.Soloproject;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.List;

public class Main {
	static Stack<Integer> historySatck = new Stack<>();

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

		boolean closeBigMenu = true;
		do {
			Mainmenu();

			int Menu = scanner.nextInt();
			switch (Menu) {

			case 1:
				historySatck.push(1);

				// creating Item table in sql.
				createTables.createItemTable();

				// creating Customer table in sql.
				createTables.createCustomerTable();

				// creating Shop table in sql.
				createTables.createShopTable();

				// creating Invoice table in sql.
				createTables.createInvoiceTable();

				// creating Set_shop in sql.
				// createTables.setingShopNameTable();

				createTables.createInvoiceHeader();

				break;

			// Since the function is static no need for creating object for the class.
			// Go to Shop Settings.
			case 2:
				historySatck.push(2);
				ShopServices.shop();
				break;

			// go to Manage Shop Items
			case 3:
				historySatck.push(3);
				ItemServices.Items();
				break;

			// Create New Invoice
			case 4:
				historySatck.push(4);
				InsertValues.insertInvoiceDetails();

				break;

			// Report: Statistics (No Of Items, No of Invoices, Total Sales)
			case 5:
				historySatck.push(5);
				ReportStatistic.reportStatistic();

				break;

			// Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items,
			// Total, Balance)
			case 6:
				historySatck.push(6);
				ReportStatistic.reportAllInvoice();

				break;

			// Search (1) Invoice (Search by Invoice No and Report All Invoice details with
			// items)
			case 7:
				historySatck.push(7);
				searchInvoice.getSearchInvoiceById();

				break;

			case 8:
				while (historySatck.empty() == false) {
					System.out.println("The Cases that the user selected and how many time "+historySatck.pop());
				}

				break;

			// Exit
			case 9:
				
				System.out.println("Are you sure you want to exit? If yes press 1, if No you want to continue with the program press 0 ");

				int exitUserInput = scanner.nextInt();

				if (exitUserInput == 1) {
					System.out.println("Exited from The System Bye See you Again :)!...");
					System.exit(0);
				}
				if (exitUserInput == 0) {
					Mainmenu();
				}

				break;

			// If the user entered a number that is not in the menu this message will appear
			default:
				System.out.println(" No such option please enetr another number");
				break;

			}

		} while (closeBigMenu);

	}
}
