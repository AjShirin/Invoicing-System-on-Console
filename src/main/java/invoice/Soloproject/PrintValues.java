package invoice.Soloproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintValues {
	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
	static final String username = "sa";
	static final String password = "root";

	public static void reportAllItems() throws Throwable {

		
		String sql = "SELECT * FROM Product";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(connection_url, username, password);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {

				Integer Product_id = result.getInt("Product_id");
				String Product_name = result.getString("Product_name");
				Float Product_unit_price = result.getFloat("Product_unit_price");
				Float Product_quantity_price = result.getFloat("Product_quantity_price");
				Integer Product_quantity = result.getInt("Product_quantity");
				Integer Shop_id = result.getInt("Shop_id");

				System.out.println("Id :" + Product_id + "||" + " " + "Product Name is:" + Product_name + "||" + " "
						+ "Product Unit Price :" + Product_unit_price + "||" + " " + "Product Quantity Price :"
						+ Product_quantity_price + "||" + " " + "Product Quantity :" + Product_quantity + "||" + " "
						+ "From Shop Id " + " " + Shop_id);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	} // End of reportAllItems Function

}// End of PrintValues Class