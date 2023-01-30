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
		Integer Product_quantity = scanner.nextInt();
		
		System.out.println("Enter Product quantity price (The unit is OMR)");
		Float Product_quantity_price = scanner.nextFloat();
		
		
		// Inserting data using SQL query
		String inserItemSql = "insert into Product values('" + product_name + "','" + Product_unit_price + "','" + Product_quantity + "', '"
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
	
	public static void insertCustomerDetails() throws Throwable {

		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String username = "sa";
		String password = "root";

		// Entering the data
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Customer Full Name");
		String Customer_full_name = scanner.next();
					
		System.out.println("Enter Customer phone number");
		String Customer_phone_number = scanner.next();

		System.out.println("Enter Invoice Date (The format should be YYYY-MM-DD) ");
		String invoice_date = scanner.next();
		
		System.out.println("Enter Number of Items");
		Integer Number_of_items = scanner.nextInt();
		
		System.out.println("Enter Total amount");
		Float Total_amount = scanner.nextFloat();
		
		System.out.println("Enter paid amount");
		Float Paid_amount = scanner.nextFloat();
		
		
		System.out.println("Enter Balance");
		Float Balance = scanner.nextFloat();
		
		
		// Inserting data using SQL query
		String insertCustomerSql = "insert into Customer values('" + Customer_full_name + "','" + Customer_phone_number + "','" + invoice_date + "', '"
				+ Number_of_items + "','"+Total_amount+"','"+Paid_amount+"','"+	Balance+ "')";

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
			int m = st.executeUpdate(insertCustomerSql);
			if (m >= 1)
				System.out.println("Customer Details Inserted successfully : " + insertCustomerSql);
			else
				System.out.println("Customer Details Insertion failed");

			// Closing the connections
			con.close();
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	} // End of insertCustomerDetails function
	
	public static void insertInvoiceDetails() throws Throwable {

		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";

		// Username and password to access DB
		// Custom initialization
		String username = "sa";
		String password = "root";

		// Entering the data
		Scanner scanner = new Scanner(System.in);
		

		System.out.println("Enter Shop ID");
		Integer Shop_id = scanner.nextInt();
					
		System.out.println("Enter Customer ID");
		Integer Customer_id = scanner.nextInt();
		
		System.out.println("Enter Item ID");
		Integer Item_id = scanner.nextInt();
		
		System.out.println("Enter Invoice Date (The format should be YYYY-MM-DD)");
		String Invoice_date = scanner.next();
		
		
		// Inserting data using SQL query
		String insertCustomerSql = "insert into Invoice_detail values('" + Shop_id + "','" + Customer_id + "','" + Item_id + "', '"
				+ Invoice_date+ "')";

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
			int m = st.executeUpdate(insertCustomerSql);
			if (m >= 1)
				System.out.println("Invoice Details Inserted successfully : " + insertCustomerSql);
			else
				System.out.println("Invoice Details Insertion failed");

			// Closing the connections
			con.close();
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	} // End of insertInvoiceDetails function
	
}// End of InsertValues class 
