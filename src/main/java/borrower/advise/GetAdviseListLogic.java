package borrower.advise;

import java.util.List;

public class GetAdviseListLogic {
	public List<Advise> execute(String strDate, String Type) {
		AdviseDAO dao = new AdviseDAO();
		List<Advise> adviseList = dao.findAll(strDate, Type);
		return adviseList;
	}
}
