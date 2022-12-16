package borrower.calendar;

import java.util.List;

public class GetCalcListLogic {
	public List<Search> execute() {
		CalcDAO dao = new CalcDAO();
		List<Search> extractList = dao.extract();
		return extractList;
	}
}
