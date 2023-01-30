package invoice.Soloproject;

import java.sql.*;
import java.util.*;

public class InsertValues {
	public static void insertShop() throws Throwable {

		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String username = "sa";
		String password = "root";

		// Entering the data
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Shop Name");
		String shop_name = scanner.next();

		System.out.println("Enter Shop Telephone Number");
		String Shop_tel_number = scanner.next();

		System.out.println("Enter Shop Email");
		String Shop_email = scanner.next();

		System.out.println("Enter Shop Website");
		String Shop_website = scanner.next();

		// Inserting data using SQL query
		String inserShopSql = "insert into Shop_detail values('" + shop_name + "','" + Shop_tel_number + "','" + Shop_email + "', '"
				+ Shop_website + "')";

		// Connection class object
		Connection con = null;

		// Try block to check for exceptions
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SocialFamilyTree;integratedSecurity=true;");
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(connection_url, username, password);

			// Creating a statement
			Statement st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(inserShopSql);
			if (m >= 1)
				System.out.println("Inserted successfully : " + inserShopSql);
			else
				System.out.println("Insertion failed");

			// Closing the connections
			con.close();
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	} // End of insertShop function
	
	public static void insertItem() throws Throwable {

		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String username = "sa";
		String password = "root";


		// Entering the data
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Product Name");
		String product_name = scanner.next();
					
		System.out.println("Enter Product unit price (The unit is OMR)");
		Float Product_unit_price = scanner.nextFloat();

		System.out.println("Enter Product quantity ");
		String Product_quantity = scanner.next();
		
		System.out.println("Enter Product quantity price (The unit is OMR)");
		Float Product_quantity_price = scanner.nextFloat();
		
		

		// Inserting data using SQL query
		String inserItemSql = "insert into Shop_detail values('" + product_name + "','" + Product_unit_price + "','" + Product_quantity + "', '"
				+ Product_quantity_price + "')";

		// Connection class object
		Connection con = null;

		// Try block to check for exceptions
		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SocialFamilyTree;integratedSecurity=true;");
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(connection_url, username, password);

			// Creating a statement
			Statement st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(inserItemSql);
			if (m >= 1)
				System.out.println("Products Inserted successfully : " + inserItemSql);
			else
				System.out.println("Products Insertion failed");

			// Closing the connections
			con.close();
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	} // End of insertItem function
	
}// End of InsertValues class 
