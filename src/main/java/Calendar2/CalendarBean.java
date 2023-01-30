 package Calendar2;

import java.io.Serializable;

public class CalendarBean implements Serializable {
	private int d_year = 0;
	private int d_month = 0;
	private String d_day = null; //日
	
	
	private int toyear = 0;
	private int tomonth = 0;
	private int today = 0;
	
	public CalendarBean() {}
	public CalendarBean(int d_year, int d_month, String d_day ) {
		this.setd_year(d_year);
		this.setd_month(d_month);
		this.setd_day(d_day);//CalendarLis
		
		
	}
	public CalendarBean(int toyear, int tomonth,int today ) {
		this.settoyear(toyear);
		this.settomonth(tomonth);
		this.settoday(today);
	}
	
	
	public void setd_year(int d_year) { this.d_year = d_year; }
	public int getd_year() { return this.d_year; }
	public void setd_month(int d_month) { this.d_month = d_month; }
	public int getd_month() { return this.d_month; }
	public void setd_day(String d_day) { this.d_day = d_day; }
	public String getd_day() { return this.d_day; }
	
	public void settoyear(int toyear) { this.toyear = toyear; }
	public int gettoyear() { return this.toyear; }
	public void settomonth(int tomonth) { this.tomonth = tomonth; }
	public int gettomonth() { return this.tomonth; }
	public void settoday(int today) { this.today = today; }
	public int gettoday() { return this.today; }
	
	
	public boolean createEntry() {
		CalendarDAO dao = new CalendarDAO();
		return dao.create(this);
	}
	
	
}

