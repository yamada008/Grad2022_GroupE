package borrower.calendar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class CalendarTestListener implements ServletContextListener {
	CalendarDateDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public CalendarTestListener() {
		dao = CalendarDateDAO.getInstance();
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
		dao.execSQL("DROP TABLE Calendar2");
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS Calendar2"
					+ " (id INT NOT NULL AUTO_INCREMENT,num int, d_year int, d_month int, d_day VARCHAR(64),  PRIMARY KEY(id))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS Calendar2"
					+ " (id INT NOT NULL AUTO_INCREMENT,num int, d_year int, d_month int, d_day VARCHAR(64),  PRIMARY KEY(id))")) {
				System.out.println("calendarDB is READY.");
			} else {
				System.out.println("calendarDB is NOT READY.");
			}
		}
//		dao.create(new CalendarDateBean(2023, 1, "1"));

		System.out.println("SystemStart..");
	}

}