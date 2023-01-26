 package Calendar2;

import java.io.Serializable;

public class CalendarBean implements Serializable {
	private int d_year = 0;
	private int d_month = 0;
	private String d_day = null; //日
	
	private int d_dat = 0;
	
	
	
	public CalendarBean() {}
	public CalendarBean( int d_month, String d_day ) {
//		this.setd_year(d_year);
		this.setd_month(d_month);
		this.setd_day(d_day);//CalendarLis
		
		
	}
	public CalendarBean(int d_year, int d_month, int d_dat) {
		this.setd_year(d_year);
		this.setd_month(d_month);
		this.setd_dat(d_dat);//ToDayList
	}
	
	public void setd_year(int d_year) { this.d_year = d_year; }
	public int getd_year() { return this.d_year; }
	public void setd_month(int d_month) { this.d_month = d_month; }
	public int getd_month() { return this.d_month; }
	public void setd_day(String d_day) { this.d_day = d_day; }
	public String getd_day() { return this.d_day; }
	
	public void setd_dat(int d_det) { this.d_dat = d_dat; }
	public int getd_dat() { return this.d_dat; }
	
	
	public boolean createEntry() {
		CalendarDAO dao = new CalendarDAO();
		return dao.create(this);
	}
	
	
}

