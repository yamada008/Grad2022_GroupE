package borrower;

import java.util.List;

public class GetProduceListLogic {
	public List<Produce> execute() {
		ProduceDAO dao = new ProduceDAO();
		List<Produce> produceList = dao.findAll();
		return produceList;
	}
}
