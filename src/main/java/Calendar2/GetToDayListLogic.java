package Calendar2;

import java.util.List;

public class GetToDayListLogic {
	public List<CalendarBean> execute(){
		ToDayDAO dao = new ToDayDAO();
		List<CalendarBean> ToDayList = dao.findAll(); 
		return ToDayList;
	}
}
