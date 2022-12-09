package borrower.produce;

import java.util.List;

public class GetProduceListLogic {
	public List<Produce> execute(String strDate) {
		ProduceDAO dao = new ProduceDAO();
		List<Produce> produceList = dao.findAll(strDate);
		return produceList;
	}
}
