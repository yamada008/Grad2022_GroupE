package agrarian;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agrarian.controller.ControllerBean;
import agrarian.controller.GetControllerListLogic;
import user.Bean;

/**
 * Servlet implementation class AgrarianServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  req.setCharacterEncoding("UTF-8");
		  resp.setContentType("text/html;charset=UTF-8");
		  GetControllerListLogic getControllerListLogic = new GetControllerListLogic();
		  List<ControllerBean> ControllerList = getControllerListLogic.execute();
		  req.setAttribute("ControllerList", ControllerList);
		
		  List<Bean> List = new ArrayList<Bean>();
		  List.add(new Bean("agrarian"));
		  req.setAttribute("List", List);
		  
		  req.getRequestDispatcher("WEB-INF/jsp/Agrarian/result3.jsp").forward(req, resp);
	  }
}
