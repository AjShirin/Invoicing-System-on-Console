package invoice.Soloproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteValue {

	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
	static final String username = "sa";
	static final String password = "root";

	public static void deletePoductById() throws IOException {
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(connection_url, username, password);
			Statement st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the ID Number of the Item you want to Delete :");
			int userInputID = sc.nextInt();

			String deleteItemSQL = "DELETE FROM Product WHERE Product_id = '" + userInputID + "'";
			
			// Executing the Sql Statement "deleteItemSQL"
			st.executeUpdate(deleteItemSQL);

			System.out.println("Record :" + userInputID + " " + "deleted Successfully!! :)");

		} catch (Exception ex) {
			System.err.println(ex);
		}
	}// End of deletePoductById Function

} // End of Class DeleteValue
