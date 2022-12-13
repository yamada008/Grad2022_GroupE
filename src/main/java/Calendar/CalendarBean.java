package Calendar;


import java.io.Serializable;

public class CalendarBean implements Serializable {
	private String d = null;
	private String userID = null;
	private String title = null;
	private String text = null;
	
	
	public CalendarBean() {}
	public CalendarBean(String d, String userID, String title, String text) {
		this.setd(d);
		this.setuserID(userID);
		this.settitle(title);
		this.settext(text);
	}
	
	public void setd(String d) { this.d = d; }
	public String getd() { return this.d; }
	public void setuserID(String userID) { this.userID = userID; }
	public String getuserID() { return this.userID; }
	public void settitle(String title) { this.title = title; }
	public String gettitle() { return this.title; }
	public void settext(String text) {this.text = text; }
	public String gettext() {return this.text;}
	
	
}
