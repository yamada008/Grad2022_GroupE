package borrower.calendar;

public class PostCalcLogic {
	public void execute(Search search) {
		CalcDAO dao = new CalcDAO();
		dao.create(search);
	}
}
