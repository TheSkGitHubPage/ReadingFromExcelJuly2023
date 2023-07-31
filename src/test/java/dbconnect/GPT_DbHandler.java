package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GPT_DbHandler {

    private static String selectAllCustomers = "select * from customers";
    private static String insertNewCustomer = "INSERT INTO customers(name, address, phone) VALUES('auto2', 'addr2', '11112')";

    public static void main(String[] args) {

        String url = "jdbc:sqlite:C:\\Users\\itune\\databasedemo.db"; // Update the URL here
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(url);
            Statement statement = conn.createStatement();

            // Create the customers table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS customers ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "address TEXT,"
                    + "phone TEXT"
                    + ")";
            statement.execute(createTableQuery);

            // Execute the insert query
            statement.execute(insertNewCustomer);
            System.out.println("Executed the query successfully");

            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found");
        } catch (SQLException e) {
            System.out.println("SQL command failed: " + e.getMessage());
        }
    }
}
