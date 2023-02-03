package borrower.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;

public class CalendarDAO extends SimpleDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	private static CalendarDAO dao = new CalendarDAO();
	
	public static CalendarDAO getInstance() {
		return dao;
	}
	
	public List<CalendarBean> findAll() {
		List<CalendarBean> selectList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM CALENDARTBL";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int startYear = rs.getInt("STARTYEAR");
				int startMonth = rs.getInt("STARTMONTH");
				int startD = rs.getInt("STARTD");
				int endYear = rs.getInt("ENDYEAR");
				int endMonth = rs.getInt("ENDMONTH");
				int endD = rs.getInt("ENDD");
				String userID = rs.getString("USERID");
				String name = rs.getString("NAME");
				String title = rs.getString("TITLE");
				String text = rs.getString("TEXT");
				CalendarBean calendarBean = new CalendarBean(id, startYear, startMonth, startD, endYear, 
						endMonth, endD, userID, name, title, text);
				selectList.add(calendarBean);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return selectList;
	}
	
	public boolean create(CalendarBean calendar) {
		try(Connection conn = this.createConnection()){
		//PreparedStatement ps = null;
		String sql ="INSERT INTO CALENDARTBL(STARTYEAR, STARTMONTH, STARTD, ENDYEAR, ENDMONTH, ENDD, USERID, "
				+ "NAME, TITLE, TEXT) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, calendar.getStartYear());
			pStmt.setInt(2, calendar.getStartMonth());
			pStmt.setInt(3, calendar.getStartD());
			pStmt.setInt(4, calendar.getEndYear());
			pStmt.setInt(5, calendar.getEndMonth());
			pStmt.setInt(6, calendar.getEndD());
			pStmt.setString(7, calendar.getUserID());
			pStmt.setString(8, calendar.getName());
			pStmt.setString(9, calendar.getTitle());
			pStmt.setString(10, calendar.getText());
			
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}