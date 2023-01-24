//package test;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import borrower.calendar.CalendarBean;
//import borrower.calendar.CalendarDAO;
//
///**
// * Application Lifecycle Listener implementation class UserListener
// *
// */
//@WebListener
//public class CalendarTest implements ServletContextListener {
//	CalendarDAO dao = null;
//
//	/**
//	 * Default constructor. 
//	 */
//	public CalendarTest() {
//		dao = CalendarDAO.getInstance();
//	}
//
//	/**
//	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
//	 */
//	public void contextDestroyed(ServletContextEvent arg0) {
//		dao = null;
//		System.out.println("SystemStop..");
//	}
//
//	/**
//	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
//	 */
//	public void contextInitialized(ServletContextEvent arg0) {
//		if (System.getenv("DATABASE_URL") != null) {
//			dao.execSQL("CREATE TABLE IF NOT EXISTS calendartbl"
//					+ " (id INT NOT NULL AUTO_INCREMENT, startyear INT, startmonth INT, startd INT, "
//					+ "endyear INT, endmonth INT, endd INT, userID VARCHAR(64), name VARCHAR(64), "
//					+ "title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))");
//		} else {
//			if (dao.execSQL("CREATE TABLE IF NOT EXISTS calendartbl"
//					+ " (id INT NOT NULL AUTO_INCREMENT, startyear INT, startmonth INT, startd INT, "
//					+ "endyear INT, endmonth INT, endd INT, userID VARCHAR(64), name VARCHAR(64), "
//					+ "title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))")) {
//				System.out.println("calendarDB is READY.");
//			} else {
//				System.out.println("calendartestDB is NOT READY.");
//			}
//		}
//		dao.create(new CalendarBean(1, 2023, 01, 01, 2023, 01, 31, "borrower", "トマト", "種まき","本文"));
//
//		System.out.println("SystemStart..");
//	}
//
//}