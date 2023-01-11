package borrower.calendar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class CalcListener implements ServletContextListener {
	CalcDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public CalcListener() {
		dao = CalcDAO.getInstance();
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
			dao.execSQL("CREATE TABLE IF NOT EXISTS EXTRACT"
					+ " (ID INT, PRODUCE_ID INT, PRODUCE_NAME VARCHAR(64), SOW_START VARCHAR(64), "
					+ "PLANTING_START VARCHAR(64), HARVEST_START VARCHAR(64), PRIMARY KEY (ID))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS EXTRACT"
					+ " (ID IDENTITY, PRODUCE_ID INT, PRODUCE_NAME VARCHAR(64), "
					+ "SOW_START VARCHAR(64), PLANTING_START VARCHAR(64), HARVEST_START VARCHAR(64))"))
			{
				System.out.println("TestUserDB is READY.");
			} else {
				System.out.println("TestUserDB is NOT READY.");
			}
		}
		dao.create(new Search());
		
		System.out.println("SystemStart..");
	}

}
