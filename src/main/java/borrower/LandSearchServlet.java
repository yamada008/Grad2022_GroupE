package borrower;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agrarian.controller.ControllerBean;
import agrarian.controller.GetControllerListLogic;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/land_search")
public class LandSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LandSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 農地一覧を取得して、リクエストスコープに保存
		GetControllerListLogic getControllerListLogic = new GetControllerListLogic();
		List<ControllerBean> ControllerList = getControllerListLogic.execute();
		req.setAttribute("ControllerList", ControllerList);
		
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/landSearch.jsp").forward(req, resp);
	}
}
