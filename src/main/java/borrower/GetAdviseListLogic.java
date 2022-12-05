package borrower;

import java.util.List;

public class GetAdviseListLogic {
	public List<Advise> execute(String strDate) {
		AdviseDAO dao = new AdviseDAO();
		List<Advise> adviseList = dao.findAll(strDate);
		return adviseList;
	}
}
