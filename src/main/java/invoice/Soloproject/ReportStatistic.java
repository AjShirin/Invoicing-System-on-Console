package invoice.Soloproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportStatistic {
	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
	static final String username = "sa";
	static final String password = "root";

	public static void reportStatistic() throws Throwable {
		
		String statisticReportSql = "select count (*) As Total_Items, (Select count(*)from Invoice_detail) As Total_Of_Invoice, SUM (Product_quantity_price) As total_quantity_Item_Price From Product";

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
				String total_quantity_Item_Price = result.getString("total_quantity_Item_Price");
				

				System.out.println("Total Items  :" + Total_Items + "||" + " " + "Total Number of invoice :" + Total_Of_Invoice + "||" + " "
						+ "Total price :" + total_quantity_Item_Price);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	} // End of reportStatistic Function

}// End of ReportStatistic Class