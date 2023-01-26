package Calendar2;

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
		try (PreparedStatement ps = db.prepareStatement("INSERT INTO Calendar2(d_year, month, d) VALUES(?, ?, ?)")) {
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			ps.setInt(1, Calendar.getd_year());
			ps.setInt(2, Calendar.getd_month());
			ps.setString(3, Calendar.getd_day());
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