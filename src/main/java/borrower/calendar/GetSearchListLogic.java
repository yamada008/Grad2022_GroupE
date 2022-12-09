package borrower.calendar;

import java.util.List;

import borrower.advise.Advise;

public class GetSearchListLogic {
	public List<Advise> execute(String strId) {
		SearchDAO dao = new SearchDAO();
		List<Advise> searchList = dao.search(strId);
		return searchList;
	}
}
