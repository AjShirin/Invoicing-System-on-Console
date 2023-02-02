package invoice.Soloproject;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.List;

public class Main {

	static Stack<Integer> historySatck = new Stack<>();

	public static void main(String[] args) throws Throwable {
		Scanner scanner = new Scanner(System.in);
		Connections conects = new Connections ();
		System.out.println("Enter the connection_Url: ");
		conects.setConnection_url(scanner.next());
		
		System.out.println("Enter the Connection Username: ");
		conects.setUsername(scanner.next());
		
		System.out.println("Enter the Connection Password: ");
		conects.setPassword(scanner.next());

		boolean closeBigMenu = true;
		do {
			Menu.showChoice(1);
			System.out.println("Write the number of the option you want to choose:");
			int menuInput = scanner.nextInt();

			switch (menuInput) {

			case 1:
				historySatck.push(1);

				// creating Item table in sql.
				createTables.createItemTable(conects.getConnection_url(),conects.getUsername(), conects.getPassword() );

				// creating Customer table in sql.
				createTables.createCustomerTable( conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				// creating Shop table in sql.
				createTables.createShopTable( conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				// creating Invoice table in sql.
				createTables.createInvoiceTable(conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				// creating Set_shop in sql.
				// createTables.setingShopNameTable();

				createTables.createInvoiceHeader(conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				break;

			// Since the function is static no need for creating object for the class.
			// Go to Shop Settings.
			case 2:
				historySatck.push(2);
				ShopServices.shop(conects.getConnection_url(),conects.getUsername(), conects.getPassword());
				break;

			// go to Manage Shop Items
			case 3:
				historySatck.push(3);
				ItemServices.Items(conects.getConnection_url(),conects.getUsername(), conects.getPassword());
				break;

			// Create New Invoice
			case 4:
				historySatck.push(4);
				InsertValues.insertInvoiceDetails(conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				break;

			// Report: Statistics (No Of Items, No of Invoices, Total Sales)
			case 5:
				historySatck.push(5);
				ReportStatistic.reportStatistic(conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				break;

			// Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items,
			// Total, Balance)
			case 6:
				historySatck.push(6);
				ReportStatistic.reportAllInvoice(conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				break;

			// Search (1) Invoice (Search by Invoice No and Report All Invoice details with
			// items)
			case 7:
				historySatck.push(7);
				searchInvoice.getSearchInvoiceById(conects.getConnection_url(),conects.getUsername(), conects.getPassword());

				break;

			case 8:
				while (historySatck.empty() == false) {
					System.out.println("The Cases that the user selected and how many time " + historySatck.pop());
				}

				break;

			// Exit
			case 9:

				System.out.println(
						"Are you sure you want to exit? If yes press 1, if No you want to continue with the program press 0 ");

				int exitUserInput = scanner.nextInt();

				if (exitUserInput == 1) {
					System.out.println("Exited from The System Bye See you Again :)!...");
					System.exit(0);
				}

				if (exitUserInput == 0) {
					closeBigMenu = true;
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
