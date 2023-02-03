package borrower.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import borrower.advise.Advise;
import dao.SimpleDAO;

public class SelectDAO extends SimpleDAO {
//	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	private static SelectDAO dao = new SelectDAO();
	
	public static SelectDAO getInstance() {
		return dao;
	}
	
	public Advise select(int Id, String strDate) {
		Advise select = new Advise();
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM RECOMMENDED_CROPS WHERE ID = '" + Id + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String type = rs.getString("TYPE");
				int id1 = rs.getInt("PRODUCE_ID1");
				String name1 = rs.getString("PRODUCE_NAME1");
				int id2 = rs.getInt("PRODUCE_ID2");
				String name2 = rs.getString("PRODUCE_NAME2");
				int id3 = rs.getInt("PRODUCE_ID3");
				String name3 = rs.getString("PRODUCE_NAME3");
				String sowStart1 = rs.getString("SOW_START1");
				String sowEnd1 = rs.getString("SOW_END1");
				String sowStart2 = rs.getString("SOW_START2");
				String sowEnd2 = rs.getString("SOW_END2");
				String sowStart3 = rs.getString("SOW_START3");
				String sowEnd3 = rs.getString("SOW_END3");
				String plantingStart1 = rs.getString("PLANTING_START1");
				String plantingEnd1 = rs.getString("PLANTING_END1");
				String plantingStart2 = rs.getString("PLANTING_START2");
				String plantingEnd2 = rs.getString("PLANTING_END2");
				String plantingStart3 = rs.getString("PLANTING_START3");
				String plantingEnd3 = rs.getString("PLANTING_END3");
				String harvestStart1 = rs.getString("HARVEST_START1");
				String harvestEnd1 = rs.getString("HARVEST_END1");
				String harvestStart2 = rs.getString("HARVEST_START2");
				String harvestEnd2 = rs.getString("HARVEST_END2");
				String harvestStart3 = rs.getString("HARVEST_START3");
				String harvestEnd3 = rs.getString("HARVEST_END3");
				select = new Advise(id, type, id1, name1, id2, name2, id3, name3, sowStart1, 
						sowEnd1, sowStart2, sowEnd2, sowStart3, sowEnd3, plantingStart1, plantingEnd1, 
						plantingStart2, plantingEnd2, plantingStart3, plantingEnd3, harvestStart1, 
						harvestEnd1, harvestStart2, harvestEnd2, harvestStart3, harvestEnd3);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return select;
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

