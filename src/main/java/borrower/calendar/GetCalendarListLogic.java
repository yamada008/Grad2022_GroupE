package borrower.calendar;

import java.util.List;

public class GetCalendarListLogic {
	public List<CalendarBean> execute() {
		CalendarDAO dao = new CalendarDAO();
		List<CalendarBean> selectList = dao.findAll();
		return selectList;
	}
}