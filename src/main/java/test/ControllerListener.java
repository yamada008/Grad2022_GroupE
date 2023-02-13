package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.ControllerDAO;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class ControllerListener implements ServletContextListener {
	ControllerDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public ControllerListener() {
		dao = ControllerDAO.getInstance();
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
//		dao.execSQL("DROP TABLE Controllerdb");
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS Controllerdb"
					+ " (id INT NOT NULL AUTO_INCREMENT,  userID VARCHAR(64),name VARCHAR(64), word VARCHAR(64), breadth VARCHAR(64), filename VARCHAR(65535), judg int)");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS Controllerdb"
					+ " (id INT NOT NULL AUTO_INCREMENT, userID VARCHAR(64),name VARCHAR(64), word VARCHAR(64), breadth VARCHAR(64), filename VARCHAR(65535), judg int)")) {
				System.out.println("Controllerdb is READY.");
			} else {
				System.out.println("Controllerdb is NOT READY.");
			}
		}
//		UserBean bean = new UserBean("地主", "agrarian", "adminpass");
//		bean.setOwner(true);
//		dao.create(bean);
		//dao.create(new ControllerBean("agrarian", "大原太郎", "千葉県柏市末広町10-1", "3畝","NoImage",0));

		System.out.println("SystemStart..");
	}

}