package Calendar2;

public class PostToDayLogic {
	public void execute(CalendarBean calendar) {
		ToDayDAO dao = new ToDayDAO();
		dao.create(calendar);
	}
}
