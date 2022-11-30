package borrower;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class AdviseListener implements ServletContextListener {
	AdviseDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public AdviseListener() {
		dao = AdviseDAO.getInstance();
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
		dao.execSQL("DROP TABLE RECOMMENDED_CROPS");
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS RECOMMENDED_CROPS"
					+ " (ID INT, PRODUCE_ID1 INT, PRODUCE_NAME1 VARCHAR(64), PRODUCE_ID2 INT, "
					+ "PRODUCE_NAME2 VARCHAR(64), PRODUCE_ID3 INT, PRODUCE_NAME3 VARCHAR(64), "
					+ "SOW_START VARCHAR(64), SOW_END VARCHAR(64), PLANTING_START VARCHAR(64), "
					+ "PLANTING_END VARCHAR(64), HARVEST_START VARCHAR(64), HARVEST_END VARCHAR(64), "
					+ "PRIMARY KEY (ID))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS RECOMMENDED_CROPS"
					+ " (ID IDENTITY, PRODUCE_ID1 INT, PRODUCE_NAME1 VARCHAR(64), PRODUCE_ID2 INT, "
					+ "PRODUCE_NAME2 VARCHAR(64), PRODUCE_ID3 INT, PRODUCE_NAME3 VARCHAR(64), "
					+ "SOW_START VARCHAR(64), SOW_END VARCHAR(64), PLANTING_START VARCHAR(64),"
					+ " PLANTING_END VARCHAR(64), HARVEST_START VARCHAR(64), HARVEST_END VARCHAR(64))"))
			{
				System.out.println("TestUserDB is READY.");
			} else {
				System.out.println("TestUserDB is NOT READY.");
			}
		}
		dao.create(new Advise(1, 9, "キュウリ", 35, "トウモロコシ", 49, "ミズナ", "2023-11-01", "2023-12-20", "2023-04-01", "2023-06-20", "2023-06-21", "2023-10-31"));
		dao.create(new Advise(2, 17, "シソ", 24, "ズッキーニ", 35, "トウモロコシ", "2023-03-21", "2023-05-30", "2023-04-11", "2023-06-20", "2023-06-01", "2023-08-20"));
		dao.create(new Advise(3, 41, "パクチー", 48, "ホウレンソウ", 33, "チンゲンサイ", "2023-04-21", "2023-05-10", "2023-05-01", "2023-05-10", "2023-07-11", "2023-08-10"));
		dao.create(new Advise(4, 1, "アシタバ", 19, "ジャガイモ", 25, "セロリ", null, null, null, null, null, null));
		dao.create(new Advise(5, 24, "ズッキーニ", 25, "セロリ", 37, "ニラ", null, null, null, null, null, null));
		dao.create(new Advise(6, 43, "葉ネギ", 59, "レタス", 46, "ブロッコリー", null, null, null, null, null, null));
		dao.create(new Advise(7, 54, "ルッコラ", 16, "シシトウ", 21, "シュンギク", null, null, null, null, null, null));
		dao.create(new Advise(8, 49, "ミズナ", 59, "レタス", 0, null, null, null, null, null, null, null));
		dao.create(new Advise(9, 35, "トウモロコシ", 39, "ハクサイ", 0, null, null, null, null, null, null, null));
		
		System.out.println("SystemStart..");
	}

}
