package borrower.calendar;

import java.io.Serializable;

public class CalendarBean implements Serializable {
	private int id = 0;
	private int startYear = 0;
	private int startMonth = 0;
	private int startD = 0;
	private int endYear = 0;
	private int endMonth = 0;
	private int endD = 0;
	private String userID = null;
	private String name = null;
	private String title = null;
	private String text = null;
	
	
	public CalendarBean() {}
	public CalendarBean(int id, int startYear, int startMonth, int startD, int endYear, int endMonth, 
			int endD, String userID, String name, String title, String text) {
		this.id = id;
		this.startYear = startYear;
		this.startMonth = startMonth;
		this.startD = startD;
		this.endYear = endYear;
		this.endMonth = endMonth;
		this.endD = endD;
		this.userID = userID;
		this.name = name;
		this.title = title;
		this.text = text;
	}
	
	public void setId(int id) { this.id = id; }
	public int getId() { return this.id; }
	public void setStartYear(int startYear) { this.startYear = startYear; }
	public int getStartYear() { return this.startYear; }
	public void setStartMonth(int startMonth) { this.startMonth = startMonth; }
	public int getStartMonth() { return this.startMonth; }
	public void setStartD(int startD) { this.startD = startD; }
	public int getStartD() { return this.startD; }
	public void setEndYear(int endYear) { this.endYear = endYear; }
	public int getEndYear() { return this.endYear; }
	public void setEndMonth(int endMonth) { this.endMonth = endMonth; }
	public int getEndMonth() { return this.endMonth; }
	public void setEndD(int endD) { this.endD = endD; }
	public int getEndD() { return this.endD; }
	public void setUserID(String userID) { this.userID = userID; }
	public String getUserID() { return this.userID; }
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	public void setTitle(String title) { this.title = title; }
	public String getTitle() { return this.title; }
	public void setText(String text) {this.text = text; }
	public String getText() {return this.text;}
	
	
//	public boolean createEntry() {
//		CalendarDAO dao = new CalendarDAO();
//		return dao.create(this);
//	}
	
	
}