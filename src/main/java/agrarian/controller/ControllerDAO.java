package agrarian.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;



public class ControllerDAO extends SimpleDAO {
	// Singletonパターン（GoFデザインパターン）
	// 用途：一つのインスタンスを共有する、複数のインスタンス生成を認めない
	private static ControllerDAO dao = new ControllerDAO(); // 唯一のインスタンス
	
//	ControllerDAO() {} // privateにすることで、外部からアクセスできなくなる
//	ControllerBean returnAb = new ControllerBean();
	public static ControllerDAO getInstance() { // staticメソッドでインスタンス（へのポインタ）を得る
		return dao;
	}
	public List<ControllerBean> findAll() {
		List<ControllerBean> ControllerList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM Controllerdb";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			// データベースの値を取得し、リストに格納する
			while (rs.next()) {
				int id = rs.getInt("ID");
				String userId = rs.getString("USERID");
				String name = rs.getString("NAME");
				String word = rs.getString("WORD");
				String breadth = rs.getString("BREADTH");
				String filename = rs.getString("FILENAME");
				int judg = rs.getInt("JUDG");
				ControllerBean controller = new ControllerBean(id, userId, name, word, breadth, filename, judg);
				ControllerList.add(controller);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return ControllerList;
	} 
	public boolean create(ControllerBean controller) {
		Connection db = this.createConnection();
		//PreparedStatement ps = null;
		boolean result = false;
		// データベースに値を格納する
		try (PreparedStatement ps = db.prepareStatement("INSERT INTO Controllerdb(USERID, NAME, WORD, BREADTH, FILENAME, JUDG) VALUES(?, ?, ?, ?, ?, ?)")) {
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			ps.setString(1, controller.getUserId());
			ps.setString(2, controller.getName());
			ps.setString(3, controller.getWord());
			ps.setString(4, controller.getBreadth());
			ps.setString(5, controller.getFilename());
			ps.setInt(6, controller.getJudg());
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