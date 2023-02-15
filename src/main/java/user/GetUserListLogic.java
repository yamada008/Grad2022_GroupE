package user;

import java.util.List;

public class GetUserListLogic {
	public List<UserBean> execute() {//データベースの値をリストに入れる
		UserDAO dao = new UserDAO();
		List<UserBean> UserList = dao.findAll();
		return UserList;
	}
}
