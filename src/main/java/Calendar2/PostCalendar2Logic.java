package Calendar2;

public class PostCalendar2Logic {
	public void execute(CalendarBean calendar) {
		CalendarDAO dao = new CalendarDAO();
		dao.create(calendar);
	}
}
