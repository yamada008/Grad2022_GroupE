package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import Calendar2.ToDayDAO;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class ToDayListener implements ServletContextListener {
	ToDayDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public ToDayListener() {
		dao = ToDayDAO.getInstance();
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
		dao.execSQL("DROP TABLE ToDay");
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS ToDay"
					+ " (id INT NOT NULL AUTO_INCREMENT, toyear int, tomonth int, today int,  PRIMARY KEY(id))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS ToDay"
					+ " (id INT NOT NULL AUTO_INCREMENT,toyear int, tomonth int, today int,  PRIMARY KEY(id))")) {
				System.out.println("calendarDB is READY.");
			} else {
				System.out.println("calendarDB is NOT READY.");
			}
		}
//		dao.create(new CalendarBean(2023, 1, 2));

		System.out.println("SystemStart..");
	}

}