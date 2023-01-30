package Calendar2;

import java.util.List;

public class GetCalendar2ListLogic {
	public List<CalendarBean> execute(){
		CalendarDAO dao = new CalendarDAO();
		List<CalendarBean> CalendarList = dao.findAll(); 
		return CalendarList;
	}
}
