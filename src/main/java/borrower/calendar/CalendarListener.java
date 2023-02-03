package borrower.calendar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class CalendarListener implements ServletContextListener {
	CalendarDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public CalendarListener() {
		dao = CalendarDAO.getInstance();
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
		dao.execSQL("DROP TABLE calendartbl");
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS calendartbl"
					+ " (id INT NOT NULL AUTO_INCREMENT, startyear INT, startmonth INT, startd VARCHAR(64), "
					+ "endyear INT, endmonth INT, endd VARCHAR(64), userID VARCHAR(64), name VARCHAR(64), "
					+ "title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS calendartbl"
					+ " (id INT NOT NULL AUTO_INCREMENT, startyear INT, startmonth INT, startd VARCHAR(64), "
					+ "endyear INT, endmonth INT, endd VARCHAR(64), userID VARCHAR(64), name VARCHAR(64), "
					+ "title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))")) {
				System.out.println("calendarDB is READY.");
			} else {
				System.out.println("calendartestDB is NOT READY.");
			}
		}
//		dao.create(new CalendarBean(1, 2023, 1, 1, 2023, 1, 10, "borrower", "トマト", "種まき", "本文"));
//		dao.create(new CalendarBean(2, 2023, 1, 7, 2023, 1, 20, "borrower", "トマト", "植付", "本文"));

		System.out.println("SystemStart..");
	}

}