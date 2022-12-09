package borrower.calendar;

import borrower.advise.Advise;

public class PostSearchLogic {
	public void execute(Advise advise) {
		SearchDAO dao = new SearchDAO();
		dao.create(advise);
	}
}
