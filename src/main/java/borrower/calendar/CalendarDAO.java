package borrower.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.SimpleDAO;

public class CalendarDAO extends SimpleDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	private static CalendarDAO dao = new CalendarDAO();
	
	public static CalendarDAO getInstance() {
		return dao;
	}
	
	public boolean create(CalendarBean Calendar) {
		Connection db = this.createConnection();
		//PreparedStatement ps = null;
		boolean result = false; 
		try (PreparedStatement ps = db.prepareStatement("INSERT INTO Calendar(d, userID, title, text) VALUES(?, ?, ?, ?)")) {
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			ps.setString(1, Calendar.getd());
			ps.setString(2, Calendar.getuserID());
			ps.setString(3, Calendar.gettitle());
			ps.setString(4, Calendar.gettext());
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