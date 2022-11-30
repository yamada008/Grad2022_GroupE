package borrower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;

public class AdviseDAO extends SimpleDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private static AdviseDAO dao = new AdviseDAO();
	
	public static AdviseDAO getInstance() {
		return dao;
	}
	
	public List<Advise> findAll() {
		List<Advise> adviseList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM RECOMMENDED_CROPS ORDER BY ID ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int id1 = rs.getInt("PRODUCE_ID1");
				String name1 = rs.getString("PRODUCE_NAME1");
				int id2 = rs.getInt("PRODUCE_ID2");
				String name2 = rs.getString("PRODUCE_NAME2");
				int id3 = rs.getInt("PRODUCE_ID3");
				String name3 = rs.getString("PRODUCE_NAME3");
				String sowStart = rs.getString("SOW_START");
				String sowEnd = rs.getString("SOW_END");
				String plantingStart = rs.getString("PLANTING_START");
				String plantingEnd = rs.getString("PLANTING_END");
				String harvestStart = rs.getString("HARVEST_START");
				String harvestEnd = rs.getString("HARVEST_END");
				Advise advise = new Advise(id, id1, name1, id2, name2, id3, name3, sowStart, sowEnd, 
						plantingStart, plantingEnd, harvestStart, harvestEnd);
				adviseList.add(advise);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return adviseList;
	} 
	
	public boolean create(Advise advise) {
		try(Connection conn = this.createConnection()){ //DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//	Statement stmt = conn.createStatement();
			String sql = "INSERT INTO RECOMMENDED_CROPS(PRODUCE_ID1, PRODUCE_NAME1, PRODUCE_ID2, "
					+ "PRODUCE_NAME2, PRODUCE_ID3, PRODUCE_NAME3, SOW_START, SOW_END, "
					+ "PLANTING_START, PLANTING_END, HARVEST_START, HARVEST_END) "
					+ "VALUES(?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setInt(1, advise.getId());
			pStmt.setInt(1, advise.getId1());
			pStmt.setString(2, advise.getName1());
			pStmt.setInt(3, advise.getId2());
			pStmt.setString(4, advise.getName2());
			pStmt.setInt(5, advise.getId3());
			pStmt.setString(6, advise.getName3());
	        pStmt.setString(7, advise.getSowStart());
	        pStmt.setString(8, advise.getSowEnd());
	        pStmt.setString(9, advise.getPlantingStart());
	        pStmt.setString(10, advise.getPlantingEnd());
	        pStmt.setString(11, advise.getHarvestStart());
	        pStmt.setString(12, advise.getHarvestEnd());
	        
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

