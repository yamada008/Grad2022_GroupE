package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import user.UserBean;
import user.UserDAO;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class UserTestListener implements ServletContextListener {
	UserDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public UserTestListener() {
		dao = UserDAO.getInstance();
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		dao = null;
		System.out.println("SystemStop..");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS usertbl"
					+ " (id IDENTITY, realName VARCHAR(64), userID VARCHAR(64), passwd VARCHAR(64), isOwner boolean)");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS usertbl"
					+ " (id IDENTITY, realName VARCHAR(64), userID VARCHAR(64), passwd VARCHAR(64), isOwner boolean)")) {
				System.out.println("TestUserDB is READY.");
			} else {
				System.out.println("TestUserDB is NOT READY.");
			}
		}
		UserBean bean = new UserBean("地主", "agrarian", "adminpass");
		bean.setOwner(true);
		dao.create(bean);
		dao.create(new UserBean("借り手", "borrower", "adminpass"));

		System.out.println("SystemStart..");
	}

}
