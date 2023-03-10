package invoice.Soloproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTables {

//	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
//	static final String username = "sa";
//	static final String password = "root";

	public static void createItemTable(String connection_url, String username, String password) throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createItemsTabelSQL = "CREATE TABLE Product " + "(Product_id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ " Product_name VARCHAR(100) , " + " Product_unit_price FLOAT , " + " Product_quantity INTEGER , "
					+ " Product_quantity_price FLOAT,"+"Shop_id INTEGER,"+"FOREIGN KEY (Shop_id) REFERENCES Shop_detail(shop_id))";

			stmt.executeUpdate(createItemsTabelSQL);
			System.out.println("Item Table Created Successfully.. :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createHotelTable Function

	public static void createCustomerTable(String connection_url, String username, String password) throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createCustomerTabelSQL = "CREATE TABLE Customer "
					+ "(Customer_id INTEGER PRIMARY KEY IDENTITY(1,1), " + " Customer_full_name VARCHAR(250) , "
					+ " Customer_phone_number VARCHAR (12) , " + " invoice_date Date , " + " Number_of_items INTEGER , "
					+ " Total_amount FLOAT, " + "Paid_amount FLOAT, " + " Balance FLOAT)";

			stmt.executeUpdate(createCustomerTabelSQL);
			System.out.println("Customer Table Created Successfully.. :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createCustomerTable Function

	public static void createShopTable(String connection_url, String username, String password) throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createShopTabelSQL = "CREATE TABLE Shop_detail " + "(shop_id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ " Shop_name VARCHAR(100)) ";

			stmt.executeUpdate(createShopTabelSQL);
			System.out.println("Shop Table Created Successfully.. :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createShopTable Function

	public static void createInvoiceTable(String connection_url, String username, String password) throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createInvoiceTabelSQL = "CREATE TABLE Invoice_detail "
					+ "(Invoice_id INTEGER PRIMARY KEY IDENTITY(1,1), " + " Shop_id INTEGER, " + "Customer_id INTEGER,"
					+ "Item_id INTEGER," + " FOREIGN KEY (Shop_id) REFERENCES Shop_detail(shop_id), "
					+ " Invoice_date Date , " + " FOREIGN KEY (Customer_id) REFERENCES Customer(Customer_id), "
					+ "FOREIGN KEY (Item_id) REFERENCES Product(Product_id)) ";

			stmt.executeUpdate(createInvoiceTabelSQL);
			System.out.println("Invoice details Table Created Successfully.. :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createInvoiceTable Function
	
			public static void createInvoiceHeader(String connection_url, String username, String password) throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createInvoiceTabelSQL = "CREATE TABLE Invoice_header_detail "
					+ "(Invoice_header_id INTEGER PRIMARY KEY IDENTITY(1,1), " + " Shop_tel_number VARCHAR (10), " + "Shop_email TEXT,"
					+ "Shop_website VARCHAR(100)," + " FOREIGN KEY (Shop_header_id) REFERENCES Shop_detail(shop_id), "
					+ " Shop_Fax VARCHAR(100)," + "Shop_header_id INTEGER) ";

			stmt.executeUpdate(createInvoiceTabelSQL);
			System.out.println("Invoice details Table Created Successfully.. :)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createInvoiceHeader Function
			
			
} // End of class create tables
