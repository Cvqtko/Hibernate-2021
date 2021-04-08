import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPreparedValues {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/aliens";
		String uname = "root";
		String pass = "root";

		int userId = 5;
		String username = "Pesho";

		String query = "INSERT INTO students (user_id, name) values (?,?)";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, userId);
		st.setString(2, username);
		int count = st.executeUpdate();

		System.out.println(count + " row/s affected");
		st.close();
		con.close();
	}
}