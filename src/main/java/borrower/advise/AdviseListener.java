package borrower.advise;

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
					+ " (ID INT, TYPE VARCHAR(64), PRODUCE_ID1 INT, PRODUCE_NAME1 VARCHAR(64), "
					+ "PRODUCE_ID2 INT, PRODUCE_NAME2 VARCHAR(64), PRODUCE_ID3 INT, "
					+ "PRODUCE_NAME3 VARCHAR(64), SOW_START1 VARCHAR(64), SOW_END1 VARCHAR(64), "
					+ "SOW_START2 VARCHAR(64), SOW_END2 VARCHAR(64), SOW_START3 VARCHAR(64), "
					+ "SOW_END3 VARCHAR(64), PLANTING_START1 VARCHAR(64), PLANTING_END1 VARCHAR(64), "
					+ "PLANTING_START2 VARCHAR(64), PLANTING_END2 VARCHAR(64), PLANTING_START3 VARCHAR(64), "
					+ "PLANTING_END3 VARCHAR(64), HARVEST_START1 VARCHAR(64), HARVEST_END1 VARCHAR(64), "
					+ "HARVEST_START2 VARCHAR(64), HARVEST_END2 VARCHAR(64), HARVEST_START3 VARCHAR(64), "
					+ "HARVEST_END3 VARCHAR(64), PRIMARY KEY (ID))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS RECOMMENDED_CROPS"
					+ " (ID IDENTITY, TYPE VARCHAR(64), PRODUCE_ID1 INT, PRODUCE_NAME1 VARCHAR(64), "
					+ "PRODUCE_ID2 INT, PRODUCE_NAME2 VARCHAR(64), PRODUCE_ID3 INT, "
					+ "PRODUCE_NAME3 VARCHAR(64), SOW_START1 VARCHAR(64), SOW_END1 VARCHAR(64), "
					+ "SOW_START2 VARCHAR(64), SOW_END2 VARCHAR(64), SOW_START3 VARCHAR(64), "
					+ "SOW_END3 VARCHAR(64), PLANTING_START1 VARCHAR(64), PLANTING_END1 VARCHAR(64), "
					+ "PLANTING_START2 VARCHAR(64), PLANTING_END2 VARCHAR(64), PLANTING_START3 VARCHAR(64), "
					+ "PLANTING_END3 VARCHAR(64), HARVEST_START1 VARCHAR(64), HARVEST_END1 VARCHAR(64), "
					+ "HARVEST_START2 VARCHAR(64), HARVEST_END2 VARCHAR(64), HARVEST_START3 VARCHAR(64), "
					+ "HARVEST_END3 VARCHAR(64))"))
			{
				System.out.println("TestUserDB is READY.");
			} else {
				System.out.println("TestUserDB is NOT READY.");
			}
		}
		dao.create(new Advise(1, "ぐーたら", 9, "キュウリ", 35, "トウモロコシ", 49, "ミズナ", "2023-03-21", "2023-05-20", null, null, null, null, "2023-04-01", "2023-06-30", null, null, null, null, "2023-05-11", "2023-08-20", null, null, null, null));
		dao.create(new Advise(2, "ぐーたら", 17, "シソ", 24, "ズッキーニ", 35, "トウモロコシ", "2023-03-01", "2023-05-31", null, null, null, null, "2023-04-21", "2023-05-31", null, null, null, null, "2023-06-21", "2023-10-31",null, null, null, null));
		dao.create(new Advise(3, "ぐーたら", 41, "パクチー", 48, "ホウレンソウ", 33, "チンゲンサイ", "2023-09-01", "2023-11-10", null, null, null, null, null, null, null, null, null, null, "2023-10-11", "2024-02-28", null, null, null, null));
		dao.create(new Advise(4, "よくばり", 1, "アシタバ", 19, "ジャガイモ", 25, "セロリ", "2023-11-01", "2023-12-20", null, null, "2023-05-01", "2023-06-10", "2024-04-01", "2024-06-20", "2023-08-21", "2023-09-30", "2023-06-11", "2023-08-31", "2024-06-21", "2024-10-31", "2023-11-01", "2023-12-31", "2023-10-01", "2023-11-30"));
		dao.create(new Advise(5, "よくばり", 24, "ズッキーニ", 25, "セロリ", 37, "ニラ", "2023-03-01", "2023-05-31", "2023-05-01", "2023-06-10", "2023-09-11", "2023-10-10", "2023-04-21", "2023-05-31", "2023-06-11", "2023-08-31", "2024-03-01", "2024-03-31", "2023-07-01", "2023-10-20", "2023-10-01", "2023-11-30", "2024-06-01", "2024-09-20"));
		dao.create(new Advise(6, "よくばり", 43, "葉ネギ", 59, "レタス", 46, "ブロッコリー", "2023-03-01", "2023-05-10", "2023-08-11", "2023-08-31", "2023-07-11", "2023-09-20", "2023-06-01", "2023-08-31", "2023-09-01", "2023-09-30", "2023-08-11", "2023-08-31", "2023-09-01", "2023-10-31", "2023-11-01", "2023-12-20", "2023-10-01", "2023-12-31"));
		dao.create(new Advise(7, "せっかち", 54, "ルッコラ", 16, "シシトウ", 21, "シュンギク", "2023-01-10", "2023-02-20", "2023-03-21", "2023-04-10", "2023-09-01", "2023-10-20", null, null, "2023-04-11", "2023-05-31", "2023-09-11", "2023-10-31", "2023-02-21", "2023-03-20", "2023-07-11", "2023-07-20", "2023-11-21", "2023-12-31"));
		dao.create(new Advise(8, "せっかち", 49, "ミズナ", 59, "レタス", 0, null, "2023-04-01", "2023-05-20", "2023-08-11", "2023-08-31", null, null, "2023-04-01", "2023-06-30", "2023-09-01", "2023-09-30", null, null, "2023-05-11", "2023-06-30", "2023-11-01", "2023-12-20", null, null));
		dao.create(new Advise(9, "せっかち", 35, "トウモロコシ", 39, "ハクサイ", 0, null, "2023-03-21", "2023-04-20", "2023-08-11", "2023-09-10", null, null, "2023-04-21", "2023-05-10", "2023-09-11", "2023-10-10", null, null, "2023-06-21", "2023-07-31", "2023-11-01", "2024-01-20",  null, null));
		
		System.out.println("SystemStart..");
	}

}
