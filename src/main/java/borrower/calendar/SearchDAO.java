package borrower.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import borrower.advise.Advise;
import dao.SimpleDAO;

public class SearchDAO extends SimpleDAO {
	
	private static SearchDAO dao = new SearchDAO();
	
	public static SearchDAO getInstance() {
		return dao;
	}
	
	public List<Advise> search(int strId) {
		List<Advise> searchList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// 選択されたおすすめ作物IDと同じものを取得する
			String sql = "SELECT * FROM RECOMMENDED_CROPS WHERE ID = " + strId;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			// データベースの値を取得し、リストに格納する
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
				Advise advise = new Advise(id, type, id1, name1, id2, name2, id3, name3, sowStart1, 
						sowEnd1, sowStart2, sowEnd2, sowStart3, sowEnd3, plantingStart1, plantingEnd1, 
						plantingStart2, plantingEnd2, plantingStart3, plantingEnd3, harvestStart1, 
						harvestEnd1, harvestStart2, harvestEnd2, harvestStart3, harvestEnd3);
				searchList.add(advise);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return searchList;
	}
	
	public boolean create(Advise advise) {
		try(Connection conn = this.createConnection()){ //DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//	Statement stmt = conn.createStatement();
			// データベースに値を格納する
			String sql = "INSERT INTO RECOMMENDED_CROPS(TYPE, PRODUCE_ID1, PRODUCE_NAME1, PRODUCE_ID2, "
					+ "PRODUCE_NAME2, PRODUCE_ID3, PRODUCE_NAME3, SOW_START1, SOW_END1, SOW_START2, "
					+ "SOW_END2, SOW_START3, SOW_END3, PLANTING_START1, PLANTING_END1, PLANTING_START2, "
					+ "PLANTING_END2, PLANTING_START3, PLANTING_END3, HARVEST_START1, HARVEST_END1, "
					+ "HARVEST_START2, HARVEST_END2, HARVEST_START3, HARVEST_END3) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//pStmt.setInt(1, advise.getId());
			pStmt.setString(1, advise.getType());
			pStmt.setInt(2, advise.getId1());
			pStmt.setString(3, advise.getName1());
			pStmt.setInt(4, advise.getId2());
			pStmt.setString(5, advise.getName2());
			pStmt.setInt(6, advise.getId3());
			pStmt.setString(7, advise.getName3());
	        pStmt.setString(8, advise.getSowStart1());
	        pStmt.setString(9, advise.getSowEnd1());
	        pStmt.setString(10, advise.getSowStart2());
	        pStmt.setString(11, advise.getSowEnd2());
	        pStmt.setString(12, advise.getSowStart3());
	        pStmt.setString(13, advise.getSowEnd3());
	        pStmt.setString(14, advise.getPlantingStart1());
	        pStmt.setString(15, advise.getPlantingEnd1());
	        pStmt.setString(16, advise.getPlantingStart2());
	        pStmt.setString(17, advise.getPlantingEnd2());
	        pStmt.setString(18, advise.getPlantingStart3());
	        pStmt.setString(19, advise.getPlantingEnd3());
	        pStmt.setString(20, advise.getHarvestStart1());
	        pStmt.setString(21, advise.getHarvestEnd1());
	        pStmt.setString(22, advise.getHarvestStart2());
	        pStmt.setString(23, advise.getHarvestEnd2());
	        pStmt.setString(24, advise.getHarvestStart3());
	        pStmt.setString(25, advise.getHarvestEnd3());
	        
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
