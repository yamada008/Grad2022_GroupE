package borrower.produce;

public class PostProduceLogic {
	public void execute(Produce produce) {
		ProduceDAO dao = new ProduceDAO();
		dao.create(produce);
	}
}
