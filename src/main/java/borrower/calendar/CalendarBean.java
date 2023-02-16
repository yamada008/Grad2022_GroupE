package borrower.calendar;

import java.io.Serializable;

public class CalendarBean implements Serializable {
	private int id = 0;
	private int startYear = 0;		// 作業の開始年
	private int startMonth = 0;		// 作業の開始月
	private int startD = 0;			// 作業の開始日
	private int endYear = 0;		// 作業の終了年
	private int endMonth = 0;		// 作業の終了月
	private int endD = 0;			// 作業の終了日
	private String userID = null;	// 作業を行うユーザーのID
	private String name = null;		// 作物名
	private String title = null;	// 作業内容
	private String text = null;		// 作業の説明
	
	private String sow = null;		// 種まき
	private String planting = null;	// 植付
	private String harvest = null;	// 収穫
	
	
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
	public CalendarBean(String sow, String planting, String harvest) {
		this.sow = sow;
		this.planting = planting;
		this.harvest = harvest;
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
	public void setSow(String sow) {this.sow = sow; }
	public String getSow() {return this.sow;}
	public void setPlanting(String planting) {this.planting = planting; }
	public String getPlanting() {return this.planting;}
	public void setHarvest(String harvest) {this.harvest = harvest; }
	public String getHarvest() {return this.harvest;}
	
	
//	public boolean createEntry() {
//		CalendarDAO dao = new CalendarDAO();
//		return dao.create(this);
//	}
	
	
}