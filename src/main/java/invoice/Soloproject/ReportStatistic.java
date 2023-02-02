package invoice.Soloproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportStatistic {
//	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
//	static final String username = "sa";
//	static final String password = "root";

	public static void reportStatistic(String connection_url, String username, String password) throws Throwable {

		String statisticReportSql = "select count (*) As Total_Items, (Select count(*)from Invoice_detail) As Total_Of_Invoice, SUM (Product_quantity_price) As Total_Sales From Product";

		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(connection_url, username, password);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(statisticReportSql);

			while (result.next()) {

				String Total_Items = result.getString("Total_Items");
				String Total_Of_Invoice = result.getString("Total_Of_Invoice");
				String total_quantity_Item_Price = result.getString("Total_Sales");

				System.out.println("Total Items  :" + Total_Items + "||" + " " + "Total Number of invoice :"
						+ Total_Of_Invoice + "||" + " " + "Total Sales :" + total_quantity_Item_Price);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	} // End of reportStatistic Function

	public static void reportAllInvoice(String connection_url, String username, String password) throws Throwable {

		String reportAllInvoiceSql = "SELECT Invoice_detail.Invoice_id As Number_of_Invoice, Invoice_detail.Invoice_date,Customer.Customer_full_name As Customer_name ,Customer.Number_of_items,Customer.Paid_amount As Total,Customer.Balance FROM Invoice_detail JOIN Customer ON Customer.Customer_id=Invoice_detail.Invoice_id";

		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(connection_url, username, password);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(reportAllInvoiceSql);

			while (result.next()) {

				Integer Number_of_Invoice = result.getInt("Number_of_Invoice");
				String Invoice_date = result.getString("Invoice_date");
				String Customer_name = result.getString("Customer_name");
				Integer Number_of_items = result.getInt("Number_of_items");
				Float Total = result.getFloat("Total");
				Float Balance = result.getFloat("Balance");

				System.out.println("Number Of Invoice  :" + Number_of_Invoice + " " + "||" + " " + " Invoice Date :"
						+ Invoice_date + " " + "||" + " " + "Customer Name :" + Customer_name + "||" + " "
						+ "Number Of Items: " + Number_of_items + " " + "||" + " " + " Total: " + Total + " " + "||"
						+ " " + "Balance:" + " " + Balance);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	} // End of reportAllInvoice Function

}// End of ReportStatistic Class