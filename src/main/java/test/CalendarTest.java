//package test;
////
////import javax.servlet.ServletContextEvent;
////import javax.servlet.ServletContextListener;
////import javax.servlet.annotation.WebListener;
////
////import Calendar.CalendarBean;
////import Calendar.CalendarDAO;
////
/////**
//// * Application Lifecycle Listener implementation class UserListener
//// *
//// */
////@WebListener
////public class CalendarTest implements ServletContextListener {
////	CalendarDAO dao = null;
////
////	/**
////	 * Default constructor. 
////	 */
////	public CalendarTest() {
////		dao = CalendarDAO.getInstance();
////	}
////
////	/**
////	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
////	 */
////	public void contextDestroyed(ServletContextEvent arg0) {
////		dao = null;
////		System.out.println("SystemStop..");
////	}
////
////	/**
////	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
////	 */
////	public void contextInitialized(ServletContextEvent arg0) {
////		if (System.getenv("DATABASE_URL") != null) {
////			dao.execSQL("CREATE TABLE IF NOT EXISTS calendar"
////					+ " (id INT NOT NULL AUTO_INCREMENT, d VARCHAR(64), userID VARCHAR(64), title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))");
////		} else {
////			if (dao.execSQL("CREATE TABLE IF NOT EXISTS calendar"
////					+ " (id INT NOT NULL AUTO_INCREMENT, d VARCHAR(64), userID VARCHAR(64), title VARCHAR(64), text VARCHAR(65535), PRIMARY KEY(id))")) {
////				System.out.println("calendarDB is READY.");
////			} else {
////				System.out.println("calendarDB is NOT READY.");
////			}
////		}
////		dao.create(new CalendarBean("2023-01-01", "borrower", "種まき","本文"));
////
////		System.out.println("SystemStart..");
////	}
////
////}