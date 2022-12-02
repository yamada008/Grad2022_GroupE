package borrower;

import java.util.List;

public class GetCropsListLogic {
	public List<Advise> execute(String strDate) {
		AdviseDAO dao = new AdviseDAO();
		List<Advise> cropsList = dao.search(strDate);
		return cropsList;
	}
}
