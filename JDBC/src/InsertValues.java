import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertValues {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "root";
		String pass = "root";

		String query = "INSERT INTO students (user_id, name) values (4, \"Moni\"); ";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		Statement st = con.createStatement();
		int count = st.executeUpdate(query);

		System.out.println(count + " row/s affected");
		st.close();
		con.close();
	}
}