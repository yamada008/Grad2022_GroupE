package Calendar2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.SimpleDAO;

public class Calendar2DAO extends SimpleDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	private static Calendar2DAO dao = new Calendar2DAO();
	
	public static Calendar2DAO getInstance() {
		return dao;
	}
	
	public boolean create(CalendarBean2 Calendar2) {
		Connection db = this.createConnection();
		//PreparedStatement ps = null;
		boolean result = false; 
		try (PreparedStatement ps = db.prepareStatement("INSERT INTO Calendar2(year, month, d, userID, title, text) VALUES(?, ?, ?, ?, ?, ?)")) {
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			ps.setInt(1, Calendar2.getyear());
			ps.setInt(2, Calendar2.getmonth());
			ps.setInt(3, Calendar2.getd());
			ps.setString(4, Calendar2.getuserID());
			ps.setString(5, Calendar2.gettitle());
			ps.setString(6, Calendar2.gettext());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection(db);
		}
		return result;
	}
}