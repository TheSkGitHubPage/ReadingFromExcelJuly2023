package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler {

	private static String selectAllCustomers = "select * from customers";
	private static String insertNewCustomer = "insert into customers (name, address, phone) values ('auto2', 'addr2', '11112')";

	public static void main(String[] args) throws ClassNotFoundException {

		// url/ file location
		// db nanme
		// username, password
		String url = "C:\\Users\\itune\\";
		String dbName = "databasedemo.db";
		String connectionString = "jdbc:sqlite:" + url + dbName;
		
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection(connectionString);
			Statement statement = conn.createStatement();
//			statement.execute(insertNewCustomer);
			
			ResultSet results = statement.executeQuery(selectAllCustomers);
			
			while(results.next()) {
				String name = results.getString(2);
				String address = results.getString(3);
				String phone = results.getString(4);
				System.out.println("Name: " + name + ", Address: " + address + ", Phone: " + phone);
			}
			
			System.out.println("Executed the query successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL command failed: " + e.getMessage());

		}

	}
}