package borrower.calendar;

import java.util.List;

public class GetToDayListLogic {
	public List<CalendarDateBean> execute(){
		ToDayDAO dao = new ToDayDAO();
		List<CalendarDateBean> ToDayList = dao.findAll(); 
		return ToDayList;
	}
}