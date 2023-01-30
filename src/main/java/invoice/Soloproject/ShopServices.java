package invoice.Soloproject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShopServices {
	public static void shop() throws Throwable {
		List<String> menueShopList = Arrays
				.asList("==== Welcome to the Shop Services Menu ==== \n " + " 1)  Load Data \n" + " 2)  Set Shop Name\n"
						+ " 3)  Set Invoice Header (Tel / Fax / Email / Website \n" + " 4)  Go Back");

		for (String shopSmallMenu : menueShopList) {
			System.out.println(shopSmallMenu);
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
