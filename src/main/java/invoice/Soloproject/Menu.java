package invoice.Soloproject;

import java.util.Arrays;
import java.util.List;

public class Menu {
	public static void showChoice(Integer choice) {
		List<String> mainMenue = Arrays.asList("==== Welcome to the Main Menu ==== \n" + " 1)  Create all Tables \n"
				+ " 2)  Shop Settings \n" + " 3)  Manage Shop Items  \n" + " 4)  Create New Invoice \n"
				+ " 5)  Report: Statistics (No Of Items, No of Invoices, Total Sales)\n"
				+ " 6)  Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance)\n"
				+ " 7)  Search (1) Invoice (Search by Invoice No and Report All Invoice details with items)\n"
				+ " 8)  Program Statistics (Print each Main Menu Item with how many number selected)\n" + " 9)  Exit");

		List<String> menueShopList = Arrays.asList("==== Welcome to the Shop Services Menu ==== \n "
				+ "1)  Load Data for Shop Details \n" + " 2) Load Data for Item details \n"
				+ " 3) Load for Customer details \n" + " 4) Load for Invoice details \n" + " 5)  Set Shop Name \n"
				+ " 6)  Set Invoice Header (Tel / Fax / Email / Website) \n" + " 7)  Go Back");

		List<String> menuItemsList = Arrays.asList(
				"==== Welcome to the Item Services Menue ==== \n" + " 1)  Add Items \n" + " 2)  Delete Items  \n"
						+ " 3)  Change Item Price \n" + " 4)  Report All Items \n" + " 5)  Go Back");

		switch (choice) {
		case 1:
			displayMenuList(mainMenue);
			break;
		case 2:
			displayMenuList(menueShopList);
			break;
		case 3:
			displayMenuList(menuItemsList);
			break;

		}// End of switch case

	} // End of showChoice function 

	public static void displayMenuList(List<String> display) {
		for (String menues : display) {
			System.out.println(menues);
		} // End of for each loop
	} // End of displayMenuList function

} // end of class Menu
