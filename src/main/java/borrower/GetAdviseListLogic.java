package borrower;

import java.util.List;

public class GetAdviseListLogic {
	public List<Advise> execute(String Date, String Type) {
		AdviseDAO dao = new AdviseDAO();
		List<Advise> adviseList = dao.findAll(Date, Type);
		return adviseList;
	}
}
