package controller;

import java.util.List;

public class GetControllerListLogic {
	public List<ControllerBean> execute(){
		ControllerDAO dao = new ControllerDAO();
		List<ControllerBean> ControllerList = dao.findAll(); 
		return ControllerList;
	}
}
