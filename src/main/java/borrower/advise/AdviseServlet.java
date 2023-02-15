package borrower.advise;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/advise")
public class AdviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public AdviseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
    	String strDate = req.getParameter("start_date");
    	String Type = req.getParameter("type");
    	int i = 1;

    	GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
		List<Advise> adviseList = getAdviseListLogic.execute(strDate, Type);
		req.setAttribute("adviseList", adviseList);
		req.setAttribute("startDate", strDate);
		req.setAttribute("i", i);
		
		String id = req.getParameter("id");
		req.setAttribute("id", id);

		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/Borrower/advise.jsp");
		dispatcher.forward(req, resp);
        
//        if(adviseList != null) {
//       	 req.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(req, resp);
//        } else {
//       	 req.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(req, resp);
//        }

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
		 resp.setContentType("text/html;charset=UTF-8");
		 
		 HttpSession session = req.getSession();
		 Advise advise = (Advise) session.getAttribute("advise");
         
         PostAdviseLogic postAdviseLogic = new PostAdviseLogic();
         postAdviseLogic.execute(advise);
         
         String strDate = req.getParameter("start_date");
         String Type = req.getParameter("type");
         
         GetAdviseListLogic getAdviseListLogic = new GetAdviseListLogic();
         List<Advise> adviseList = getAdviseListLogic.execute(strDate, Type);
         req.setAttribute("startDate", strDate);
         req.setAttribute("adviseList", adviseList);
         
//         req.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(req, resp);
         
         if(adviseList != null) {
        	 req.getRequestDispatcher("WEB-INF/jsp/Borrwer/advise.jsp").forward(req, resp);
         } else {
        	 req.getRequestDispatcher("WEB-INF/jsp/Borrower/produceSearch.jsp").forward(req, resp);
         }
         
         
		
//		 String forward = "/SotsukenE/advise";
//		 resp.sendRedirect(forward);
		 
	}
}