import java.sql.*;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "root";
		String pass = "root";

		String query = "SELECT name FROM students WHERE user_id = 3";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);

		rs.next();
		String name = rs.getString("name");
		System.out.println(name);

		st.close();
		con.close();
	}
}
