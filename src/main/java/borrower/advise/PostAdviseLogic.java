package borrower.advise;

public class PostAdviseLogic {
	public void execute(Advise advise) {
		AdviseDAO dao = new AdviseDAO();
		dao.create(advise);
	}
}
