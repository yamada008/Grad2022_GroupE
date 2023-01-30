package Calendar2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;

public class ToDayDAO extends SimpleDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	private static ToDayDAO dao = new ToDayDAO();
	
	public static ToDayDAO getInstance() {
		return dao;
	}
	public List<CalendarBean> findAll(){
		List<CalendarBean> ToDayList = new ArrayList<CalendarBean>();
		try(Connection conn = this.createConnection()){
			String sql = "select * from ToDay";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery(); 
		
			while(rs.next()) {
				int toyear = rs.getInt("toyear");
				int tomonth = rs.getInt("tomonth");
				int today = rs.getInt("today");
				CalendarBean mc = new CalendarBean(toyear,tomonth,today);
				ToDayList.add(mc);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ToDayList;
	}
	
	public boolean create(CalendarBean calendar) {
		try( Connection conn = this.createConnection()){
			String sql = "INSERT INTO ToDay(toyear, tomonth, today) VALUES(?,?,?)" ;
				//pStmt = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, calendar.gettoyear());
				pStmt.setInt(2, calendar.gettomonth());
				pStmt.setInt(3, calendar.gettoday());
				
				int result = pStmt.executeUpdate();
				if(result != 1) {
					return false;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			
				return false;
			}
		return true;
			
		
		//PreparedStatement pStmt = null;
		
		
	}
}