import java.sql.*;
public class RetrieveContents {
	static final String D_B_URL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";
	static final String QUERY = "SELECT name, email, country FROM users";

	public static void main(String[] args) {
		//open a connection 
		try(Connection conn = DriverManager.getConnection(D_B_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);) {
			//Extract data from Result Set
			while(rs.next()) {
				//Retrieve by column name
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Country: " + rs.getString("country"));
				System.out.println();
			}//end while
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
	}//end main
}//end class
