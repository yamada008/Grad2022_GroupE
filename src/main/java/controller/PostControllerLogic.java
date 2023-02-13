package controller;

public class PostControllerLogic {
	public void execute(ControllerBean controller) {
		ControllerDAO dao = new ControllerDAO();
		dao.create(controller);
	}
}
