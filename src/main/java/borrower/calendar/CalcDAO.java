package borrower.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;

public class CalcDAO extends SimpleDAO {
	
	private static CalcDAO dao = new CalcDAO();
	
	public static CalcDAO getInstance() {
		return dao;
	}
	
//	public int input(Search search) {
//		int count = 0;
//		
//		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
//			this.execSQL("INSERT INTO EXTRACT VALUES('" 
//					+ search.getId() + "', '" + search.getType() + "', '"
//					+ search.getId1() + "', '" + search.getName1() + "', '"
//					+ search.getId2() + "', '" + search.getName2() + "', '"
//					+ search.getId3() + "', '" + search.getName3() + "', '"
//					+ search.getSowStart1() + "', '" + search.getSowEnd1() + "', '"
//					+ search.getSowStart2() + "', '" + search.getSowEnd2() + "', '"
//					+ search.getSowStart3() + "', '" + search.getSowEnd3() + "', '"
//					+ search.getPlantingStart1() + "', '" + search.getPlantingEnd1() + "', '"
//					+ search.getPlantingStart2() + "', '" + search.getPlantingEnd2() + "', '"
//					+ search.getPlantingStart3() + "', '" + search.getPlantingEnd3() + "', '"
//					+ search.getHarvestStart1() + "', '" + search.getHarvestEnd1() + "', '"
//					+ search.getHarvestStart2() + "', '" + search.getHarvestEnd2() + "', '"
//					+ search.getHarvestStart3() + "', '" + search.getHarvestEnd3() + "')");
//			
//			
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		return count;
//	}
	
	public List<Search> extract() {
		List<Search> extractList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM EXTRACT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int produceId = rs.getInt("PRODUCE_ID");
				String name = rs.getString("PRODUCE_NAME");
				String sowStart = rs.getString("SOW_START");
				String plantingStart = rs.getString("PLANTING_START");
				String harvestStart = rs.getString("HARVEST_START");
				Search search = new Search(id, produceId, name, sowStart, plantingStart, harvestStart);
				extractList.add(search);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return extractList;
	}
	
	public boolean create(Search search) {
		try(Connection conn = this.createConnection()){ //DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//	Statement stmt = conn.createStatement();
			String sql = "INSERT INTO EXTRACT(PRODUCE_ID, PRODUCE_NAME, SOW_START, "
					+ "PLANTING_START, HARVEST_START) VALUES(?, ?, ?, ?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setInt(1, advise.getId());
			pStmt.setInt(1, search.getProduceId());
			pStmt.setString(2, search.getName());
	        pStmt.setString(3, search.getSowStart());
	        pStmt.setString(4, search.getPlantingStart());
	        pStmt.setString(5, search.getHarvestStart());
	        
	        int result = pStmt.executeUpdate();
	        if (result != 1) {
	        	return false;
	        }
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
