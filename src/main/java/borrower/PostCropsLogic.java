package borrower;

public class PostCropsLogic {
	public void execute(Advise advise) {
		AdviseDAO dao = new AdviseDAO();
		dao.Comparison(advise);
	}
}
