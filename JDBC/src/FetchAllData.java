import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchAllData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "root";
		String pass = "root";

		String query = "SELECT * FROM students";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		rs.next();
		while (rs.next()) {
			String userData = rs.getInt(1) + " : " + rs.getString(2);
			System.out.println(userData);
		}
		st.close();
		con.close();
	}
}
