package borrower.calendar;

public class PostSelectLogic {
	public void execute(CalendarBean calendar) {
		SelectDAO dao = new SelectDAO();
		dao.create(calendar);
	}
}
