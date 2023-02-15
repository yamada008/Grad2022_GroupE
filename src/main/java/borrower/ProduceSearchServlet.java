package borrower;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProduceSearchServlet
 */
@WebServlet("/produce_search")
public class ProduceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduceSearchServlet() {
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
		
//		GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
//		List<Advise> adviseList = getAdviseListLogic.execute();
//		req.setAttribute("adviseList", adviseList);
		
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		
		req.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
//		HttpSession session = req.getSession();
//		 Advise advise = (Advise) session.getAttribute("advise");
//        
//        PostAdviseLogic postAdviseLogic = new PostAdviseLogic();
//        postAdviseLogic.execute(advise);
//
//		GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
//		List<Advise> adviseList = getAdviseListLogic.execute();
//		req.setAttribute("adviseList", adviseList);
        
        req.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(req, resp);
		
	}

}
