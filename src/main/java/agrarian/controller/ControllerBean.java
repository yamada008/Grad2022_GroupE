package agrarian.controller;
import java.io.Serializable;

public class ControllerBean implements Serializable {
	private int id = 0;
	private String userId = null;		// ユーザーID
	private String name = null;			// 名前
	private String word  = null;		// 住所
	private String breadth = null;		// 広さ
	private String filename = null;		// 画像
	private int judg = 0;				// 貸し出しているか
	
	public ControllerBean() {}
	public ControllerBean(int id, String userId, String name, String word, String breadth, String filename, int judg ) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.word = word;
		this.breadth = breadth;
		this.filename = filename;
		this.judg = judg;
	}
	
	void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	
	void setUserId(String userId) { this.userId = userId; }
	public String getUserId() { return this.userId; }
	
	void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	
	void setWord(String word) { this.word = word; }
	public String getWord() { return this.word; }
	
	void setBreadth(String breadth) { this.breadth = breadth; }
	public String getBreadth() { return this.breadth; }
	
	void setFilename(String filename) { this.filename = filename; }
	public String getFilename() { return this.filename; }
	
	void setJudg(int judg) { this.judg = judg; }
	public int getJudg() { return this.judg; }
	
}