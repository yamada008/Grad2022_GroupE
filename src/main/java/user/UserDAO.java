package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SimpleDAO;



public class UserDAO extends SimpleDAO {
	// Singletonパターン（GoFデザインパターン）
	// 用途：一つのインスタンスを共有する、複数のインスタンス生成を認めない
	private static UserDAO dao = new UserDAO(); // 唯一のインスタンス
	
	UserDAO() {} // privateにすることで、外部からアクセスできなくなる
	 UserBean returnAb = new UserBean();
	public static UserDAO getInstance() { // staticメソッドでインスタンス（へのポインタ）を得る
		return dao;
	}
	
	public List<UserBean> findAll() {
		List<UserBean> UserList = new ArrayList<>();
		
		try (Connection conn = this.createConnection()){//DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM usertbl";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				
				String name = rs.getString("REALNAME");
				String id = rs.getString("USERID");
				String pass = rs.getString("PASSWD");
				
				UserBean user = new UserBean(name, id, pass );
				UserList.add(user);
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		return UserList;
	} 
	
	public boolean create(UserBean user) {
		Connection db = this.createConnection();
		//PreparedStatement ps = null;
		boolean result = false;
		try (PreparedStatement ps = db.prepareStatement("INSERT INTO usertbl(realName, userID, passwd, isOwner) VALUES(?, ?, ?, ?)")) {
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			ps.setString(1, user.getRealName());
			ps.setString(2, user.getUserId());
			ps.setString(3, user.getPass());
			ps.setBoolean(4, user.isOwner());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection(db);
		}
		return result;
	}

//	public String find(String id, String pass) {
//		return "ほげ";
//	}


	public String find(String userId, String pass) {
		Connection db = this.createConnection();
		PreparedStatement ps = null;
		String result = null;
		try {
			ps = db.prepareStatement("SELECT * FROM usertbl WHERE userID=? AND passwd=?");
			ps.setString(1, userId);
			ps.setString(2, pass);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				result = rst.getString("realName");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
			}
			this.closeConnection(db);
		}

		return result;
	}
	
	public boolean getOwner(String id) {
		Connection db = this.createConnection();
		//PreparedStatement ps = null;
		boolean result = false;
		try (PreparedStatement ps = db.prepareStatement("SELECT isOwner FROM usertbl WHERE userId =?")) {
			//(PreparedStatement ps = db.prepareStatement("INSERT INTO sample(realName, userID, passwd, isAuth, isOwner) VALUES(?, ?, ?, ?)")) {
			//ps = db.prepareStatement("INSERT INTO user(realName, userID, passwd) VALUES(?, ?, ?)");
			ps.setString(1, id);
			//ps.executeUpdate();
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				result = rst.getBoolean("isOwner");
			}//result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeConnection(db);
		}
		return result;
	}

}