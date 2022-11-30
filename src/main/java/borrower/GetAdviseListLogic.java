package borrower;

import java.util.List;

public class GetAdviseListLogic {
	public List<Advise> execute() {
		AdviseDAO dao = new AdviseDAO();
		List<Advise> adviseList = dao.findAll();
		return adviseList;
	}
}
