package borrower.calendar;

public class PostCalendarLogic {
	public void execute(CalendarBean calendarBean) {
		CalendarDAO dao = new CalendarDAO();
		dao.create(calendarBean);
	}
}
