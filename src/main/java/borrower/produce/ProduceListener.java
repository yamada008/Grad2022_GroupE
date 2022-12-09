package borrower.produce;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class ProduceListener implements ServletContextListener {
	ProduceDAO dao = null;

	/**
	 * Default constructor. 
	 */
	public ProduceListener() {
		dao = ProduceDAO.getInstance();
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
		dao.execSQL("DROP TABLE PRODUCE");
		if (System.getenv("DATABASE_URL") != null) {
			dao.execSQL("CREATE TABLE IF NOT EXISTS PRODUCE"
					+ " (PRODUCE_ID INT, PRODUCE_NAME VARCHAR(64), SOW_START VARCHAR(64), "
					+ "SOW_END VARCHAR(64), PLANTING_START VARCHAR(64), PLANTING_END VARCHAR(64), "
					+ "HARVEST_START VARCHAR(64), HARVEST_END VARCHAR(64), PRIMARY KEY (PRODUCE_ID))");
		} else {
			if (dao.execSQL("CREATE TABLE IF NOT EXISTS PRODUCE"
					+ " (PRODUCE_ID INT, PRODUCE_NAME VARCHAR(64), SOW_START VARCHAR(64), "
					+ "SOW_END VARCHAR(64), PLANTING_START VARCHAR(64), PLANTING_END VARCHAR(64), "
					+ "HARVEST_START VARCHAR(64), HARVEST_END VARCHAR(64))")) {
				System.out.println("TestUserDB is READY.");
			} else {
				System.out.println("TestUserDB is NOT READY.");
			}
		}
		dao.create(new Produce(1, "アシタバ", "2023-11-01", "2023-12-20", "2024-04-01", "2024-06-20", "2024-06-21", "2024-10-31"));
		dao.create(new Produce(2, "インゲンマメ", "2023-03-21", "2023-05-30", "2023-04-11", "2023-06-20", "2023-06-01", "2023-08-20"));
		dao.create(new Produce(3, "エダマメ", "2023-04-21", "2023-05-10", "2023-05-01", "2023-05-10", "2023-07-11", "2023-08-10"));
		dao.create(new Produce(4, "オクラ", "2023-04-01", "2023-04-10", "2023-05-01", "2023-05-10", "2023-06-01", "2023-09-20"));
		dao.create(new Produce(5, "カブ", "2023-02-21", "2023-03-10", null, null, "2023-04-21", "2023-05-20"));
		dao.create(new Produce(6, "カブ", "2023-04-11", "2023-04-30", null, null, "2023-05-21", "2023-06-30"));
		dao.create(new Produce(7, "カブ", "2023-09-01", "2023-09-20", null, null, "2023-11-01", "2024-02-28"));
		dao.create(new Produce(8, "カボチャ", "2023-03-11", "2023-05-20", "2023-05-01", "2023-06-20", "2023-07-01", "2023-09-10"));
		dao.create(new Produce(9, "キュウリ", "2023-04-01", "2023-04-20", "2023-04-21", "2023-05-10", "2023-06-01", "2023-08-20"));
		dao.create(new Produce(10, "ゴーヤ", "2023-03-21", "2023-05-31", "2023-04-21", "2023-06-20", "2023-07-21", "2023-10-10"));
		dao.create(new Produce(11, "ゴボウ", "2023-03-21", "2023-06-10", null, null, "2023-07-11", "2023-09-10"));
		dao.create(new Produce(12, "ゴボウ", "2023-09-01", "2023-10-31", null, null, "2023-11-11", "2024-01-10"));
		dao.create(new Produce(13, "コマツナ", "2023-03-01", "2023-11-30", null, null, "2023-04-01", "2023-01-20"));
		dao.create(new Produce(14, "サツマイモ", null, null, "2023-05-11", "2023-06-20", "2023-10-01", "2023-11-10"));
		dao.create(new Produce(15, "サトイモ", "2023-03-11", "2023-04-10", "2023-04-11", "2023-05-20", "2023-10-01", "2023-11-10"));
		dao.create(new Produce(16, "シシトウ", "2023-03-21", "2023-04-10", "2023-04-11", "2023-05-31", "2023-07-11", "2023-07-20"));
		dao.create(new Produce(17, "シソ", "2023-04-01", "2023-05-31", "2023-05-01", "2023-05-31", "2023-07-01", "2023-10-31"));
		dao.create(new Produce(18, "ジャガイモ", null, null, "2023-02-21", "2023-03-10", "2023-06-01", "2023-07-10"));
		dao.create(new Produce(19, "ジャガイモ", null, null, "2023-08-21", "2023-09-30", "2023-11-01", "2023-12-31"));
		dao.create(new Produce(20, "シュンギク", "2023-03-21", "2023-04-30", "2023-04-11", "2023-05-10", "2023-05-11", "2023-06-20"));
		dao.create(new Produce(21, "シュンギク", "2023-09-01", "2023-10-20", "2023-09-11", "2023-10-30", "2023-11-21", "2023-12-31"));
		dao.create(new Produce(22, "葉ショウガ", null, null, "2023-04-01", "2023-04-30", "2023-07-21", "2023-08-20"));
		dao.create(new Produce(23, "根ショウガ", null, null, "2023-04-01", "2023-04-30", "2023-10-21", "2023-10-30"));
		dao.create(new Produce(24, "ズッキーニ", "2023-03-01", "2023-05-31", "2023-04-21", "2023-05-31", "2023-07-01", "2023-10-20"));
		dao.create(new Produce(25, "セロリ", "2023-05-01", "2023-06-10", "2023-06-11", "2023-08-31", "2023-10-01", "2023-11-30"));
		dao.create(new Produce(26, "ソラマメ", "2023-01-11", "2023-02-10", "2023-02-11", "2023-02-28", "2023-05-01", "2023-06-10"));
		dao.create(new Produce(27, "ソラマメ", "2023-10-01", "2023-10-10", "2023-11-01", "2023-11-10", "2024-05-11", "2024-06-10"));
		dao.create(new Produce(28, "ダイコン", "2023-02-21", "2023-03-10", null, null, "2023-04-21", "2023-05-20"));
		dao.create(new Produce(29, "ダイコン", "2023-04-11", "2023-04-30", null, null, "2023-05-21", "2023-06-30"));
		dao.create(new Produce(30, "ダイコン", "2023-08-21", "2023-09-30", null, null, "2023-10-21", "2023-12-10"));
		dao.create(new Produce(31, "タマネギ", "2023-09-01", "2023-09-30", "2023-11-01", "2023-11-30", "2024-05-01", "2024-05-31"));
		dao.create(new Produce(32, "チンゲンサイ", "2023-04-11", "2023-05-31", null, null, "2023-05-11", "2023-07-10"));
		dao.create(new Produce(33, "チンゲンサイ", "2023-09-01", "2023-10-31", null, null, "2023-11-01", "2024-01-31"));
		dao.create(new Produce(34, "トウガン", "2023-03-11", "2023-04-20", "2023-04-11", "2023-05-20", "2023-08-11", "2023-09-30"));
		dao.create(new Produce(35, "トウモロコシ", "2023-03-21", "2023-04-20", "2023-04-21", "2023-05-10", "2023-06-21", "2023-07-31"));
		dao.create(new Produce(36, "ニラ", "2023-03-11", "2023-03-31", "2023-05-11", "2023-06-20", "2023-08-11", "2023-10-20"));
		dao.create(new Produce(37, "ニラ", "2023-09-11", "2023-10-10", "2024-03-01", "2024-03-31", "2024-06-01", "2024-09-20"));
		dao.create(new Produce(38, "ニンニク", null, null, "2023-09-11", "2023-10-10", "2024-05-21", "2024-06-30"));
		dao.create(new Produce(39, "ハクサイ", "2023-08-11", "2023-09-10", "2023-09-11", "2023-10-10", "2023-11-01", "2024-01-20"));
		dao.create(new Produce(40, "パクチー", "2023-04-01", "2023-07-31", null, null, "2023-06-01", "2023-10-31"));
		dao.create(new Produce(41, "パクチー", "2023-09-01", "2023-10-31", null, null, "2023-11-01", "2024-02-28"));
		dao.create(new Produce(42, "バジル", "2023-04-11", "2023-06-20", "2023-05-11", "2023-07-10", "2023-06-11", "2023-10-20"));
		dao.create(new Produce(43, "葉ネギ", "2023-03-01", "2023-05-10", "2023-06-01", "2023-08-31", "2023-09-01", "2023-10-31"));
		dao.create(new Produce(44, "パプリカ", "2023-02-01", "2023-03-10", "2023-05-01", "2023-05-31", "2023-07-01", "2023-10-31"));
		dao.create(new Produce(45, "ブロッコリー", "2023-02-01", "2023-03-31", "2023-03-01", "2023-04-30", "2023-04-21", "2023-06-20"));
		dao.create(new Produce(46, "ブロッコリー", "2023-07-11", "2023-08-20", "2023-08-11", "2023-08-31", "2023-10-01", "2023-12-31"));
		dao.create(new Produce(47, "ホウレンソウ", "2023-03-11", "2023-05-20", null, null, "2023-06-01", "2023-07-10"));
		dao.create(new Produce(48, "ホウレンソウ", "2023-09-01", "2023-11-10", null, null, "2023-10-11", "2023-12-20"));
		dao.create(new Produce(49, "ミズナ", "2023-04-01", "2023-05-20", "2023-04-01", "2023-06-30", "2023-05-11", "2023-06-30"));
		dao.create(new Produce(50, "ミズナ", "2023-09-01", "2023-10-20", "2023-09-01", "2023-11-10", "2023-12-01", "2024-01-31"));
		dao.create(new Produce(51, "ミョウガ", "2023-02-11", "2023-02-20", "2023-03-21", "2023-04-20", "2023-08-21", "2023-09-10"));
		dao.create(new Produce(52, "モロヘイヤ", "2023-04-01", "2023-06-20", "2023-05-01", "2023-06-30", "2023-07-01", "2023-10-10"));
		dao.create(new Produce(53, "ラッカセイ", "2023-05-01", "2023-06-10", "2023-06-01", "2023-07-10", "2023-09-11", "2023-10-20"));
		dao.create(new Produce(54, "ルッコラ", "2023-01-11", "2023-02-20", null, null, "2023-02-21", "2023-03-20"));
		dao.create(new Produce(55, "ルッコラ", "2023-05-11", "2023-06-20", null, null, "2023-06-21", "2023-07-20"));
		dao.create(new Produce(56, "ルッコラ", "2023-09-01", "2023-09-30", null, null, "2023-10-01", "2023-10-20"));
		dao.create(new Produce(57, "ルバーブ", "2023-03-21", "2023-04-30", "2023-06-11", "2023-07-20", "2024-05-01", "2024-06-30"));
		dao.create(new Produce(58, "レタス", "2023-02-11", "2023-03-20", "2023-04-01", "2023-04-30", "2023-05-21", "2023-06-30"));
		dao.create(new Produce(59, "レタス", "2023-08-11", "2023-08-31", "2023-09-01", "2023-09-30", "2023-11-01", "2023-12-20"));

		System.out.println("SystemStart..");
	}

}
