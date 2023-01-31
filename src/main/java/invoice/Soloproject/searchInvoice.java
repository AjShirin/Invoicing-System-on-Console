package invoice.Soloproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class searchInvoice {
	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
	static final String username = "sa";
	static final String password = "root";

	public static void getSearchInvoiceById() {

		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(connection_url, username, password);
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Invoice ID  that you want search for ? ");
			int invoiceNumber = scanner.nextInt();
			int count = 0;
			String invoiceSearchSql = "SELECT * from Invoice_detail INNER JOIN Product ON Invoice_detail.Item_id=Product.Product_id where Invoice_id ='"
					+ invoiceNumber + "'";

			ResultSet rs = st.executeQuery(invoiceSearchSql);
			while (rs.next() && count <= invoiceNumber) {

				Integer Invoice_id = rs.getInt("Invoice_id");
				Integer Shop_id = rs.getInt("Shop_id");
				Integer Customer_id = rs.getInt("Customer_id");
				Integer Item_id = rs.getInt("Item_id");
				String Invoice_date = rs.getString("Invoice_date");
				Integer Product_id = rs.getInt("Product_id");
				String Product_name = rs.getString("Product_name");
				Float Product_unit_price = rs.getFloat("Product_unit_price");
				Float Product_quantity = rs.getFloat("Product_quantity");
				Float Product_quantity_price = rs.getFloat("Product_quantity_price");

				System.out.println("Id :" + Invoice_id + "||" + " " + "Shop ID :" + Shop_id + "||" + " "
						+ "Customer ID :" + Customer_id + "||" + " " + "Item ID :" + Item_id + "||" + " "
						+ "Invoice date :" + Invoice_date + "||" + "\n " + "Item ID: " + Product_id + "||" + " "
						+ "Product Name:" + " " + Product_name + "||" + " " + "Item Unit Price:" + " "
						+ Product_unit_price + "" + "||" + "Item Quantity" + " " + Product_quantity + " " + "||"
						+ " Item Quantity Price: " + Product_quantity_price);
				count++;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}// End OF getSearchInvoiceById Function

}// End of class searchInvoice
