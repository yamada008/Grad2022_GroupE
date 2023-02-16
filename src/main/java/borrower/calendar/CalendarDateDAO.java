package borrower.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;

public class CalendarDateDAO extends SimpleDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	private static CalendarDateDAO dao = new CalendarDateDAO();
	
	public static CalendarDateDAO getInstance() {
		return dao;
	}
	
	public List<CalendarDateBean> findAll(){
		List<CalendarDateBean> CalendarList = new ArrayList<CalendarDateBean>();
		try(Connection conn = this.createConnection()){
			String sql = "select * from Calendar2";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery(); 
		
			// データベースの値を取得し、リストに格納する
			while(rs.next()) {
				int num = rs.getInt("num");
				int d_year = rs.getInt("d_year");
				int d_month = rs.getInt("d_month");
				String d_day = rs.getString("d_day");
				CalendarDateBean mc = new CalendarDateBean(num,d_year,d_month,d_day);
				CalendarList.add(mc);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return CalendarList;
	}
	
	public boolean create(CalendarDateBean calendar) {
		// データベースに値を格納する
		try( Connection conn = this.createConnection()){
			String sql = "INSERT INTO Calendar2(num,d_year, d_month, d_day) VALUES(?,?,?,?)" ;
				//pStmt = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, calendar.getnum());
				
				pStmt.setInt(2, calendar.getd_year());
				pStmt.setInt(3, calendar.getd_month());
				pStmt.setString(4, calendar.getd_day());
				
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