package borrower.calendar;

import java.util.List;

public class GetCalendarDateListLogic {
	public List<CalendarDateBean> execute(){
		CalendarDateDAO dao = new CalendarDateDAO();
		List<CalendarDateBean> CalendarDateList = dao.findAll(); 
		return CalendarDateList;
	}
}