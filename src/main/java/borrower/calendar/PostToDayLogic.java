package borrower.calendar;

public class PostToDayLogic {
	public void execute(CalendarDateBean calendar) {
		ToDayDAO dao = new ToDayDAO();
		dao.create(calendar);
	}
}