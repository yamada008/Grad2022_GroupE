package borrower.calendar;

public class PostCalendarDateLogic {
	public void execute(CalendarDateBean calendar) {
		CalendarDateDAO dao = new CalendarDateDAO();
		dao.create(calendar);
	}
}