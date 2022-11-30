package borrower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;

public class ProduceDAO extends SimpleDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	private static ProduceDAO dao = new ProduceDAO();
	
	public static ProduceDAO getInstance() {
		return dao;
	}
	
	public List<Produce> findAll() {
		List<Produce> produceList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM PRODUCE ORDER BY PRODUCE_ID ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("PRODUCE_ID");
				String name = rs.getString("PRODUCE_NAME");
				String sowStart = rs.getString("SOW_START");
				String sowEnd = rs.getString("SOW_END");
				String plantingStart = rs.getString("PLANTING_START");
				String plantingEnd = rs.getString("PLANTING_END");
				String harvestStart = rs.getString("HARVEST_START");
				String harvestEnd = rs.getString("HARVEST_END");
				Produce produce = new Produce(id, name, sowStart, sowEnd, plantingStart, 
						plantingEnd, harvestStart, harvestEnd);
				produceList.add(produce);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return produceList;
	} 
	
	public boolean create(Produce produce) {
		try(Connection conn = this.createConnection()){ //DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//	Statement stmt = conn.createStatement();
			String sql = "INSERT INTO PRODUCE( PRODUCE_ID, PRODUCE_NAME, SOW_START, SOW_END, "
					+ "PLANTING_START, PLANTING_END, HARVEST_START, HARVEST_END) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, produce.getId());
			pStmt.setString(2, produce.getName());
	        pStmt.setString(3, produce.getSowStart());
	        pStmt.setString(4, produce.getSowEnd());
	        pStmt.setString(5, produce.getPlantingStart());
	        pStmt.setString(6, produce.getPlantingEnd());
	        pStmt.setString(7, produce.getHarvestStart());
	        pStmt.setString(8, produce.getHarvestEnd());
	        
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

