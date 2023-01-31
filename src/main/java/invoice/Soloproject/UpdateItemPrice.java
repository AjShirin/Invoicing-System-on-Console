package invoice.Soloproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateItemPrice {

	static final String connection_url = "jdbc:sqlserver://localhost:1433;databaseName=InvoiceGrociares;encrypt=true;trustServerCertificate=true";
	static final String username = "sa";
	static final String password = "root";

	static void updateItemPriceById() throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID Number of the product that you want to Update :");
		int userInputID = scanner.nextInt();

		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			DriverManager.registerDriver(driver);

			con = DriverManager.getConnection(connection_url, username, password);
			
			String sql = "UPDATE Product SET Product_quantity_price = ? WHERE Product_id = ?";
						
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			System.out.println("Enter the The new price of the ID :");
			Float priceUserInput = scanner.nextFloat();
			

			pstmt.setFloat(1, priceUserInput);
			pstmt.setInt(2, userInputID);
			pstmt.executeUpdate();

			String byID = "SELECT * FROM Product WHERE Product_id = ?";

			PreparedStatement pstmt2 = con.prepareStatement(byID);
			pstmt2.setInt(1, userInputID);
			ResultSet rs = pstmt2.executeQuery();
			if (rs.next()) {
				
				String Product_name = rs.getString("Product_name");
				Float Product_unit_price = rs.getFloat("Product_unit_price");
				Float Product_quantity = rs.getFloat("Product_quantity");
				Float Product_quantity_price = rs.getFloat("Product_quantity_price");
				
				System.out.println("Record Updated Successfully :) !!");

				System.out.println("Id :" + userInputID + "||" + " " + "Product Name is:" + Product_name + "||" + " "
						+ "Product Unit Price :" + Product_unit_price + "||" + " " + "Product Quantity :" + Product_quantity + "||"
						+ " " + "Product Quantity Price :" + Product_quantity_price);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	} // End of updateItemPriceById Function
}// End of UpdateItemPrice Class
