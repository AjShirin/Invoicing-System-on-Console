package invoice.Soloproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTables {

	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
	static final String username = "sa";
	static final String password = "root";

	public static void createItemTable() throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createItemsTabelSQL = "CREATE TABLE Product " + "(Product_id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ " Product_name VARCHAR(100) , " + " Product_unit_price FLOAT , "
					+ " Product_quantity INTEGER , " + " Product_quantity_price INTEGER)";

			stmt.executeUpdate(createItemsTabelSQL);
			System.out.println("Item Table Created Successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createHotelTable Function

	public static void createCustomerTable() throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createItemsTabelSQL = "CREATE TABLE Customer " + "(Customer_id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ " Customer_full_name VARCHAR(250) , " + " Customer_phone_numer VARCHAR (12) , "
					+ " invoice_date Date , " + " Number_of_items INTEGER , "
					+ " Total_amount FLOAT, " + "Paid_amount FLOAT, " + " Balance FLOAT)";

			stmt.executeUpdate(createItemsTabelSQL);
			System.out.println("Customer Table Created Successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createCustomerTable Function
	
	public static void createShopTable() throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createShopTabelSQL = "CREATE TABLE Shop_detail " + "(Shop_id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ " Shop_name VARCHAR(100) , " + " Shop_tel_numer VARCHAR (10) , "
					+ " Shop_email TEXT , " + " Shop_website TEXT ) ";
	

			stmt.executeUpdate(createShopTabelSQL);
			System.out.println("Shop Table Created Successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createShopTable Function
	
	public static void createInvoiceTable() throws IOException {
		// Open a connection
		try (Connection conn = DriverManager.getConnection(connection_url, username, password);
				Statement stmt = conn.createStatement();) {
			String createInvoiceTabelSQL = "CREATE TABLE Invoice_detail " + "(Invoice_id INTEGER PRIMARY KEY IDENTITY(1,1), "
					+ "Shop_id INTEGER, " + "Customer_id INTEGER,"
					+ " FOREIGN KEY (Shop_id) REFERENCES Shop_details(Shop_id), " + " Invoice_date Date , "
				    + " FOREIGN KEY (Customer_id) REFERENCES Customers(Customer_id)) ";
	

			stmt.executeUpdate(createInvoiceTabelSQL);
			System.out.println("Invoice details Table Created Successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// close createInvoiceTable Function

} // End of class create tables
