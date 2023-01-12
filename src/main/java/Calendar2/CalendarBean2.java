
package Calendar2;



import java.io.Serializable;

public class CalendarBean2 implements Serializable {
	private int year = 0;
	private int month = 0;
	private int d = 0;
	private String userID = null;
	private String title = null;
	private String text = null;
	
	
	public CalendarBean2() {}
	public CalendarBean2(int year, int month, int d, String userID, String title, String text) {
		this.setyear(year);
		this.setmonth(month);
		this.setd(d);
		this.setuserID(userID);
		this.settitle(title);
		this.settext(text);
	}
	
	public void setyear(int year) { this.year = year; }
	public int getyear() { return this.year; }
	public void setmonth(int month) { this.month = month; }
	public int getmonth() { return this.month; }
	public void setd(int d) { this.d = d; }
	public int getd() { return this.d; }
	public void setuserID(String userID) { this.userID = userID; }
	public String getuserID() { return this.userID; }
	public void settitle(String title) { this.title = title; }
	public String gettitle() { return this.title; }
	public void settext(String text) {this.text = text; }
	public String gettext() {return this.text;}
	
	
	public boolean createEntry() {
		Calendar2DAO dao = new Calendar2DAO();
		return dao.create(this);
	}
	
	
}