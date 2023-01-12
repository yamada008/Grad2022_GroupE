package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import Calendar2.Calendar2DAO;
import Calendar2.CalendarBean2;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class Calendar2Listener implements ServletContextListener {
	Calendar2DAO dao = null;

	/**
	 * Default constructor. 
	 */
	public Calendar2Listener() {
		dao = Calendar2DAO.getInstance();
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
			dao.execSQL("CREATE TABLE IF NOT EXISTS calendar2"
					+ " (id INT NOT NULL AUTO_INCREMENT, year INT, month INT, d INT, userID VARCHAR(64), title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS calendar2"
					+ " (id INT NOT NULL AUTO_INCREMENT, year INT, month INT, d INT, userID VARCHAR(64), title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))")) {
				System.out.println("calendarDB is READY.");
			} else {
				System.out.println("calendarDB is NOT READY.");
			}
		}
		dao.create(new CalendarBean2(2023, 1, 1, "borrower", "種まき","本文"));

		System.out.println("SystemStart..");
	}

}