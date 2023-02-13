package controller;
import java.io.Serializable;

public class ControllerBean implements Serializable {
	private String id = null;
	private String name = null;
	private String word  = null;
	private String breadth = null;
	private String filename = null;
	private int judg = 0;
	
	public ControllerBean() {}
	public ControllerBean(String id, String name, String word, String breadth, String filename, int judg ) {
		this.id = id;
		this.name = name;
		this.word = word;
		this.breadth = breadth;
		this.filename = filename;
		this.judg = judg;
	}
	
	void setId(String id) { this.id = id; }
	public String getId() { return this.id; }
	
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